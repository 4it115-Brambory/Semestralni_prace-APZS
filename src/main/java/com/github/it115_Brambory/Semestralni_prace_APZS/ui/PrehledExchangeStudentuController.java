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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
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
		prihlasen.setEditable(false);
		// ToDo

	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
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
		window.show();
	}
	
	// detail studenta, todo
	@FXML
	private void sceneDetailStudenta() throws Exception {

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
