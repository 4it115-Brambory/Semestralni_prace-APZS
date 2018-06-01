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
public class PridaniExchangeStudentaController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	@FXML
	private TextField jmeno;
	@FXML
	private TextField prijmeni;
	@FXML
	private TextField email;
	@FXML
	private TextField pohlavi;
	@FXML
	private TextField statniprislusnost;
	@FXML
	private TextField adresa;
	@FXML
	private TextField telefon;
	@FXML
	private TextField heslo;
	@FXML
	private TextField datumnarozeni;
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
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		this.buddyAplikace = buddyAplikace;
		prihlasen.setEditable(false);
		

	}

	@FXML	
	private void sceneZpetNaPrehledExchange (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledExchangeStudentuProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledExchangeStudentuController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.setTitle("Přehled Exchange studentů");
		window.show();
	}

	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
	
	public void uloz() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovyExchangeStudent(email.getText(),heslo.getText(),2, jmeno.getText(),
				prijmeni.getText(), datumnarozeni.getText(), telefon.getText(), pohlavi.getText(),
				statniprislusnost.getText(), adresa.getText());

	}

}
