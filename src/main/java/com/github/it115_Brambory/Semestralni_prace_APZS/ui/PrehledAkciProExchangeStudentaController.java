package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;

import java.sql.SQLException;
import java.util.Observable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení přehledu buddy
 * 
 * @author Jan Mandík
 *
 */
public class PrehledAkciProExchangeStudentaController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	@FXML
	private ListView<Akce> seznamAkci;
	@FXML
	private Button odhlasit;
	@FXML
	private TableColumn cena;
	@FXML
	private TextArea prihlasen;

	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {

		this.buddyAplikace = buddyAplikace;
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);
		
		seznamAkci.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamAkciKolekce());
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().addObserver(this);

		

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.buddyAplikace = buddyAplikace;
		seznamAkci.getItems().clear();
		try {
			seznamAkci.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamAkciKolekce());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@FXML
	private void sceneDetailAkce() throws Exception {
		Akce vybranaAkce = seznamAkci.getSelectionModel().getSelectedItem();
		if (vybranaAkce != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("DetailAkceProStudenta.fxml"));
			Parent root = loader.load();
			DetailAkceProExchangeController controller = new DetailAkceProExchangeController();
			controller = loader.getController();

			controller.inicializuj(buddyAplikace, vybranaAkce);
			Stage DetailAkceExchange = new Stage();
			DetailAkceExchange.setScene(new Scene(root));
			DetailAkceExchange.show();
			DetailAkceExchange.setTitle("Detail akce");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Upozornění");
		    alert.setHeaderText(null);
		    alert.setContentText("Nemáš vybranou akci");
		    alert.showAndWait();
		}
	}

	/**
	 * Matoda na odhlášení uživatele po kliknutí na tlačítko "odhlásit". Aktuální
	 * uživatel se nastaví na null a scéna se změní na přihlášení.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	public void odhlasit(ActionEvent event) throws Exception {

		this.buddyAplikace.getBuddyAplikace().logOut();
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("Prihlaseni.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrihlaseniController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();

	}

}
