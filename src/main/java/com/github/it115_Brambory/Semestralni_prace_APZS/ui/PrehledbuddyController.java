package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Collections;
import java.util.Observable;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení přehledu buddy
 * 
 * @author Jan Mandík
 *
 */
public class PrehledbuddyController extends Pane implements Observer {
	// zjistit, jak se používá tableview
	private IBuddyAplikace buddyAplikace;
	@FXML
	private TableColumn jmeno;
	@FXML
	private TableColumn prijmeni;
	@FXML
	private TableColumn email;
	@FXML
	private TableColumn pohlavi;
	@FXML
	private TableColumn statniprislusnost;
	@FXML
	private TableColumn adresa;
	@FXML
	private TableColumn datumnarozeni;
	@FXML
	private ListView<Buddy> seznamBuddy;
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
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		this.buddyAplikace = buddyAplikace;

		seznamBuddy.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamBuddyKolekce());

		prihlasen.setEditable(false);
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().addObserver(this);

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		this.buddyAplikace = buddyAplikace;
		seznamBuddy.getItems().clear();
		try {
			seznamBuddy.getItems().addAll(buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamBuddyKolekce());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void sceneAdmin() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("Prehledakciadmin.fxml"));
		Parent root = loader.load();
		PrehledakciadminController controller = new PrehledakciadminController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage Prehledakciadmin = new Stage();
		Prehledakciadmin.setScene(new Scene(root));
		Prehledakciadmin.show();
		Prehledakciadmin.setTitle("Přehled akcí");

	}

	@FXML
	private void sceneDetailAkce() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("detailakceadminadmin.fxml"));
		Parent root = loader.load();
		DetailakceadminController controller = new DetailakceadminController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage Detailakceadminadmin = new Stage();
		Detailakceadminadmin.setScene(new Scene(root));
		Detailakceadminadmin.show();
		Detailakceadminadmin.setTitle("Detail akce");

	}

	@FXML
	private void scenePrehledZadosti() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("prehledZadosti.fxml"));
		Parent root = loader.load();
		PrehledZadostiController controller = new PrehledZadostiController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage prehledZadosti = new Stage();
		prehledZadosti.setScene(new Scene(root));
		prehledZadosti.show();
		prehledZadosti.setTitle("Přehled žádostí");

	}

	@FXML
	private void scenePrehledCeskych() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("prehledbuddy.fxml"));
		Parent root = loader.load();
		PrehledbuddyController controller = new PrehledbuddyController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage Prehledbuddy = new Stage();
		Prehledbuddy.setScene(new Scene(root));
		Prehledbuddy.show();
		Prehledbuddy.setTitle("Přehled českých studentů");

	}

	@FXML
	private void scenePrehledZahranicnich() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("prehledzahranicnich.fxml"));
		Parent root = loader.load();
		PrehledzahranicnichController controller = new PrehledzahranicnichController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage Prehledaexchange = new Stage();
		Prehledaexchange.setScene(new Scene(root));
		Prehledaexchange.show();
		Prehledaexchange.setTitle("Přehled zahraničních studnetů");
	}

	@FXML
	private void scenePridatBuddyho() throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(getClass().getResource("pridanibuddyho.fxml"));
		Parent root = loader.load();
		PridanibuddyhoController controller = new PridanibuddyhoController();
		controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		Stage Pridanibuddyho = new Stage();
		Pridanibuddyho.setScene(new Scene(root));
		Pridanibuddyho.show();
		Pridanibuddyho.setTitle("Přidání buddyho");
	}

	// detail buddyho, todo
	@FXML
	private void sceneDetailBuddyho() throws Exception {
		Buddy vybranyBuddy = seznamBuddy.getSelectionModel().getSelectedItem();
		System.out.print(vybranyBuddy);
		System.out.print(vybranyBuddy.toString());
		if (vybranyBuddy != null) {
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("detailbuddyho.fxml"));
			Parent root = loader.load();
			DetailbuddyhoController controller = new DetailbuddyhoController();
			controller = loader.getController();

			controller.inicializuj(buddyAplikace, vybranyBuddy);
			Stage Detailbuddyho = new Stage();
			Detailbuddyho.setScene(new Scene(root));
			Detailbuddyho.show();
			Detailbuddyho.setTitle("Detail buddyho");
		} else
			System.out.print("nemáš vybraného");

	}

	private void detailStudenta() throws Exception {
		// vybranyBuddy = seznamBuddy.getSelectionModel().getSelectedItem();
		sceneDetailBuddyho();

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

}
