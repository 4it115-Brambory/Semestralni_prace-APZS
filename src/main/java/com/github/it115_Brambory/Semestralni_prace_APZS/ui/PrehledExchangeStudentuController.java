package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;
import java.awt.TextField;
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
 * pro načtení přehledu zahraničních studentů
 * 
 * @author Jan Mandík
 *
 */
public class PrehledExchangeStudentuController extends Pane implements Observer {
	// zjistit, jak se používá tableview
	private IBuddyAplikace buddyAplikace;

	@FXML
	private ListView<Exchange> seznamExchange;
	@FXML
	private TextArea prihlasen;
	@FXML
	private Button odhlasit;

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
		seznamExchange.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchangeKolekce());
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().addObserver(this);
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.buddyAplikace = buddyAplikace;
		seznamExchange.getItems().clear();
		try {
			seznamExchange.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchangeKolekce());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML	
	private void scenePrehledAkci (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledAkciProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledAkciProAdminaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.setTitle("Přehled akcí");
		window.show();
	}
	
	@FXML	
	private void scenePrehledZadosti (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledZadostiProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledZadostiController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.setTitle("Přehled žádostí");
		window.show();
	}
	
	@FXML	
	private void scenePrehledCeskych (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledBuddyStudentuProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledBuddyStudentuController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.setTitle("Přehled Buddy studentů");
		window.show();
	}
	
	@FXML	
	private void scenePridatZahranicniho (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PridaniNovehoExchange.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PridaniExchangeStudentaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.setTitle("Přidání Exchange studenta");
		window.show();
	}
	
	// detail studenta, todo
	@FXML
	private void sceneDetailStudenta() throws Exception {
		Exchange vybranyExchange = seznamExchange.getSelectionModel().getSelectedItem();
		if (vybranyExchange != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("DetailExchangeProAdmina.fxml"));
			Parent root = loader.load();
			DetailExchangeStudentaController controller = new DetailExchangeStudentaController();
			controller = loader.getController();

			controller.inicializuj(buddyAplikace, vybranyExchange);
			Stage DetailExchange = new Stage();
			DetailExchange.setScene(new Scene(root));
			DetailExchange.show();
			DetailExchange.setTitle("Detail Exchange studenta");
		} else {
			Alert alert = new Alert(AlertType.ERROR);
		    alert.setTitle("Upozornění");
		    alert.setHeaderText(null);
		    alert.setContentText("Nemáš vybraného studenta");
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
