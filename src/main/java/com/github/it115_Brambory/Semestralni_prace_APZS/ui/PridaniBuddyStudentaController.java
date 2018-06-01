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
public class PridaniBuddyStudentaController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	private Buddy ukladanyBuddy;
	@FXML
	private TextField jmeno;
	@FXML
	private TextField prijmeni;
	@FXML
	private TextField email;
	@FXML
	private TextField pohlavi;
	@FXML
	private TextField telefon;
	@FXML
	private TextField heslo;
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

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	@FXML	
	private void sceneZpetNaPrehledBuddyStudentu (ActionEvent event) throws Exception {
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
	
	public void uloz() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovyBuddyStudent(email.getText(),heslo.getText(),1, jmeno.getText(),
				prijmeni.getText(), datumnarozeni.getText(), telefon.getText(), pohlavi.getText(),
				statniprislusnost.getText(), xname.getText(), titul.getText(), adresa.getText());

	}



	

}
