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
public class DetailExchangeStudentaController extends Pane implements Observer {

	private Exchange detailExchange;
	private IBuddyAplikace buddyAplikace;
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
	public void inicializuj(IBuddyAplikace buddyAplikace, Exchange vybranyExchange) throws SQLException {
		this.buddyAplikace = buddyAplikace;
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);
		
		detailExchange = vybranyExchange;
		jmeno.setText(detailExchange.getJmeno());
		prijmeni.setText(detailExchange.getPrijmeni());
		email.setText(detailExchange.getEmail());
		pohlavi.setText(detailExchange.getPohlavi());
		statniprislusnost.setText(detailExchange.getStatniPrislusnost());
		adresa.setText(detailExchange.getAdresa());
		datumnarozeni.setText(detailExchange.getDatumNarozeni());
		telefon.setText(detailExchange.getTelefon());

	}

	
	/**
	 * Metoda na přepne na přehled a zavře po sobě okno
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML	
	private void sceneZpetNaPrehledExchangeStudentu (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledExchangeStudentuProAdmina.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledExchangeStudentuController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

	/**
	 * Metoda předá zadané údaje databázi
	 * 
	 * 
	 * @throws SQLException
	 */	
	public void uloz() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().updateExchangeStudenta(detailExchange.getId(), jmeno.getText(),
				prijmeni.getText(), datumnarozeni.getText(),telefon.getText(), pohlavi.getText(),
				statniprislusnost.getText(), adresa.getText(), email.getText());

	}
	
	/**
	 * Metoda předá databázové metodě pokyn k odstranění zvoleného studenta
	 * 
	 * 
	 * @throws SQLException
	 */		
	public void odstran() throws SQLException {
		buddyAplikace.getBuddyAplikace().getDatabazeOperace().deleteExchangeStudent(detailExchange.getId());
		Stage curretStage = (Stage) email.getScene().getWindow();
		curretStage.close();
	}

}
