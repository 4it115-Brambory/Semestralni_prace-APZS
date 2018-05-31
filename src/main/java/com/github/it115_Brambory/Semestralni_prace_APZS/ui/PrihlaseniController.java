package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect.*;

import java.util.Observer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.control.TextField;

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
		
	}

	@FXML
	/**
	 * Tahle metoda by se měla postarat o změnu Stage, nicméně nefunguje a nevím
	 * proč. Myslím, že by ještě měla načítat kontroler
	 */
	private void sceneExchange () throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("Prehledakciexchange.fxml"));    	
    	Parent root = loader.load();
    	PrehledakciexchangeController controller = new PrehledakciexchangeController();
    	controller = loader.getController(); 
    	controller.inicializuj(buddyAplikace);
    	Stage Prehledakciexchange = new Stage();    	
    	Prehledakciexchange.setScene(new Scene(root));
    	Prehledakciexchange.show();
    	Prehledakciexchange.setTitle("Přehled akcí");
    	
	}

	/**
	 * Tahle metoda by se měla postarat o změnu Stage, nicméně nefunguje a nevím
	 * proč. Myslím, že by ještě měla načítat kontroler
	 */
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

	/**
	 * Tahle metoda by se měla postarat o změnu Stage, nicméně nefunguje a nevím
	 * proč. Myslím, že by ještě měla načítat kontroler
	 */
	@FXML
	private void sceneBuddy() throws Exception {
		FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(getClass().getResource("Prehledakcibuddy.fxml"));    	
    	Parent root = loader.load();
    	PrehledakcibuddyController controller = new PrehledakcibuddyController();
    	controller = loader.getController(); 
    	controller.inicializuj(buddyAplikace);
    	Stage Prehledakcibuddy = new Stage();    	
    	Prehledakcibuddy.setScene(new Scene(root));
    	Prehledakcibuddy.show();
    	Prehledakcibuddy.setTitle("Přehled akcí");
    	
	}

	@FXML
	public void prihlasit() throws Exception {

		//kontrolní výpis emailu a hesla
		System.out.println("Kontrolní výpis emailu -->" + email.getText() + "<--");
		System.out.println("Kontrolní výpis hesla -->" + heslo.getText() + "<--");

		int ukazatel = buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn(email.getText(), heslo.getText(),
				buddyAplikace);
		if (ukazatel == 0) {
			//vyskočí modální okno
			ukazAlertBad();
		} else if (ukazatel == 1) {
			Stage curretStage = (Stage) email.getScene().getWindow();
			sceneBuddy();  /* přepnutí na buddyho */
			curretStage.close(); 
			
		} else if (ukazatel == 2) {
			Stage curretStage = (Stage) email.getScene().getWindow();
			sceneExchange(); /* přepnutí na exchange */
			curretStage.close();
			;
		} else {
			Stage curretStage = (Stage) email.getScene().getWindow();
			sceneAdmin();   /* přepnutí na admina */;
			curretStage.close();
		}
	}

	/**
	 * Metoda ukáže modální okno s upozorněním
	 */
	public void ukazAlertBad() {
		Alert alert = new Alert(AlertType.ERROR);
		alert.setTitle("Upozornění");
		alert.setHeaderText(null);
		alert.setContentText("Neplatné jméno nebo heslo!");
		alert.showAndWait();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
	
	//odhlašovací metoda, hádám, že bude stačit zabít celou aplikaci
		@FXML
		private void odhlasit() throws Exception {
			Platform.exit();
			Start.main(null); //tohle by mělo aplikaci zas spustit, ale nějak se to neděje, tak na to kašlu. Hlavně, že se to zavře
		}

}
