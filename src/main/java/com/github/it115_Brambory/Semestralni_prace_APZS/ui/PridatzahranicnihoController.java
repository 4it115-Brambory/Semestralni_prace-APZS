package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou - slouží pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class PridatzahranicnihoController extends Pane implements Observer {
	
	private IBuddyAplikace buddyAplikace;	
	@FXML private TextField jmeno;
	@FXML private TextField prijmeni;
	@FXML private TextField email;
	@FXML private TextField pohlavi;
	@FXML private TextField statniprislusnost;
	@FXML private TextField adresa;
	@FXML private TextField datumnarozeni;
	@FXML private TextArea prihlasen;

	/**
     *  Metoda k inicializaci hry. Načte všechny potřebné prvky
     *  GUI a přidá observery.
     *  
	 * @throws SQLException - to je kvůli těm testům na konci metody
     */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {
		
		this.buddyAplikace = buddyAplikace;
		//ToDo
		
		
		
		
		//---------------------------------------------------------------------------------------------------------------------------------
		//Ahoj, tohle mi tady nechte zakomentovaný, jsou to testy, že funguje databázový připojení
		//a že se data správně vkládaj do programu
		
		//jmeno.setText(this); Potřeba zíkávat hodnotu jednotlivých fieldů, nevím, jak to udělat
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logInTest();
		
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
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
	
}
