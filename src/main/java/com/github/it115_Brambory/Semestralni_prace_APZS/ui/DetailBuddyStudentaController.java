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
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class DetailBuddyStudentaController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	private Buddy detailBuddy;
	@FXML
	private TextField jmeno;
	@FXML
	private TextField prijmeni;
	@FXML
	private TextField email;
	@FXML
	private TextField telefon;
	@FXML
	private TextField pohlavi;
	@FXML
	private TextField statniprislusnost;
	@FXML
	private TextField adresa;
	@FXML
	private TextField datumnarozeni;
	@FXML
	private TextField xname;
	@FXML
	private TextField titul;
	@FXML
	private TextArea prihlasen;
	// @FXML private TextArea textAreaTest;
	@FXML
	private Button odhlasit;

	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace, Buddy vybranyBuddy) throws SQLException {

		this.buddyAplikace = buddyAplikace;
		detailBuddy = vybranyBuddy;
		jmeno.setText(detailBuddy.getJmeno());
		prijmeni.setText(detailBuddy.getPrijmeni());
		email.setText(detailBuddy.getEmail());
		pohlavi.setText(detailBuddy.getPohlavi());
		statniprislusnost.setText(detailBuddy.getStatniPrislusnost());
		adresa.setText(detailBuddy.getAdresa());
		datumnarozeni.setText(detailBuddy.getDatumNarozeni());
		xname.setText(detailBuddy.getXname());
		titul.setText(detailBuddy.getTitul());

		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
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
		loader.setLocation(this.getClass().getResource("prihlaseni.fxml"));
		Parent tableViewParent = loader.load();

		Scene tableViewScene = new Scene(tableViewParent);

		PrihlaseniController controller = loader.getController();
		controller.inicializuj(buddyAplikace);

		Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();

	}

	public void uloz() throws SQLException {
		System.out.print(
				detailBuddy.getId() + " " + jmeno.getText() + " " + prijmeni.getText() + " " + telefon.getText() + " "
						+ pohlavi.getText() + " " + datumnarozeni.getText() + " " + statniprislusnost.getText() + " "
						+ xname.getText() + " " + titul.getText() + " " + adresa.getText() + " " + email.getText());
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().updateBuddyStudenta(detailBuddy.getId(), jmeno.getText(),
				prijmeni.getText(), datumnarozeni.getText(), telefon.getText(), pohlavi.getText(),
				statniprislusnost.getText(), xname.getText(), titul.getText(), adresa.getText(), email.getText());

	}

}
