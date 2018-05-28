package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect.*;

import java.util.Observer;
import java.awt.TextField;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;


/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class PrihlaseniController extends Pane implements Observer {

	private IBuddyAplikace buddyAplikace;
	private Parent root;
	private Stage window;
	private javafx.scene.control.Button closeButton;

	@FXML
	private TextField email;
	@FXML
	private PasswordField heslo;


	/**
	 * Metoda k inicializaci hry. Načte všechny potřebné prvky GUI a přidá
	 * observery.
	 * 
	 * @throws SQLException
	 *             - to je kvůli těm testům na konci metody
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {

		this.buddyAplikace = buddyAplikace;
		// ToDo

		// ---------------------------------------------------------------------------------------------------------------------------------
		// Ahoj, tohle mi tady nechte zakomentovaný, jsou to testy, že funguje
		// databázový připojení
		// a že se data správně vkládaj do programu
		// textAreaTest.setText("Ahoj, toto je test, že funguje okno\n");
		// jmeno.setText(this); Potřeba zíkávat hodnotu jednotlivých fieldů, nevím, jak
		// to udělat
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logInTest();

	}
	

	/**
	 * Funkční metoda pro přepnutí na výpis akci, jediné problém je, že se nezavře předchozí Stage		
	 */
	@FXML public void sceneExchange() throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("prehledakciexchange.fxml"));    	
    	Parent root = loader.load();
    	PrehledakciexchangeController controller = new PrehledakciexchangeController();
    	controller = loader.getController(); 
    	controller.inicializuj(buddyAplikace);
    	Stage prehledakciexchange = new Stage();   	   	
    	prehledakciexchange.setScene(new Scene(root));
    	prehledakciexchange.show();
    	prehledakciexchange.setTitle("Přehled akcí");    	
    /*	prehledakciexchange.setOnCloseRequest(new EventHandler<WindowEvent>() {
    	    public void handle(WindowEvent we) {                        
    	        Platform.setImplicitExit(false);
    	        prehledakciexchange.close();
    	    }
    	});*/
    	
			}
    	;
	
	
	
	/**
	 Funkční metoda pro přepnutí na výpis akci, jediné problém je, že se nezavře předchozí Stage		
	 */
	@FXML
    private void sceneAdmin() throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("prehledakciadmin.fxml"));    	
    	Parent root = loader.load();
    	PrehledakciadminController controller = new PrehledakciadminController();
    	controller = loader.getController(); 
    	controller.inicializuj(buddyAplikace);
    	Stage prehledakciadmin = new Stage();   	   	
    	prehledakciadmin.setScene(new Scene(root));
    	prehledakciadmin.show();
    	prehledakciadmin.setTitle("Přehled akcí");
    	//prehledakciexchange.setOnCloseRequest(new EventHandler<WindowEvent>());
    	
			}
    	
	
	
	/**
	 * Funkční metoda pro přepnutí na výpis akci, jediné problém je, že se nezavře předchozí Stage		
	 */
	@FXML
    private void sceneBuddy() throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("prehledakciexchange.fxml"));    	
    	Parent root = loader.load();
    	PrehledakcibuddyController controller = new PrehledakcibuddyController();
    	controller = loader.getController(); 
    	controller.inicializuj(buddyAplikace);
    	Stage prehledakcibuddy = new Stage();   	   	
    	prehledakcibuddy.setScene(new Scene(root));
    	prehledakcibuddy.show();
    	prehledakcibuddy.setTitle("Přehled akcí");
    	//prehledakciexchange.setOnCloseRequest(new EventHandler<WindowEvent>());
    	
			}
    	
	
	/**
	 * Tahle metoda by měla rozhodnout o správnosti hesla a přepnout na další stránku, nicméně jsou tu my - nejde mi zvít String z email a heslo.
	 * @throws Exception 
	 */
	@FXML public void prihlasit() throws Exception 	
    { 
		/*String h = heslo.getText();
		String e = email.getText();
		System.out.println(h);*/
		
		
		int ukazatel = buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("dorymachy@gmail.com","heslo123"); 
		if (ukazatel == 0) {
		    System.out.println("Chybné přihlašovací údaje");
		} else if (ukazatel == 1) {
		    sceneExchange();/*přepnutí na exchange*/
		} else if (ukazatel == 2) {
		    sceneBuddy();/*přepnutí na buddyho*/;
		} else  {
			 sceneAdmin();/*přepnutí na admina*/;
		}
				;
			   
        }
	
	

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub  
	}

}

	
	

