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
import javafx.scene.Node;
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
	@FXML
	private TextField email;
	@FXML
	private PasswordField heslo;

	/**
	 * Metoda k inicializaci.
	 * 
	 */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {

		this.buddyAplikace = buddyAplikace;
		
	}

	@FXML
	/**
	 * Metoda mění scénu na přehled akcí pro exchange studenta.
	 * 
	 * @param event
	 * @throws Exception
	 */
	private void sceneExchange (ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledAkciProExchange.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledAkciProExchangeStudentaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	/**
	 * Metoda mění scénu na přehled akcí pro administrátora.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void sceneAdmin(ActionEvent event) throws Exception {
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

	/**
	 * Metoda mění scénu na přehled akcí pro buddy studenta.
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void sceneBuddy(ActionEvent event) throws Exception {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(this.getClass().getResource("PrehledAkciProBuddy.fxml"));
		Parent tableViewParent = loader.load();
    	
		Scene tableViewScene = new Scene(tableViewParent);
		
		PrehledAkciProBuddyStudentaController controller = loader.getController();
		controller.inicializuj(buddyAplikace);
		
		Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
		window.setScene(tableViewScene);
		window.show();
	}

	@FXML
	public void prihlasit(ActionEvent event) throws Exception {

		//kontrolní výpis emailu a hesla
		//System.out.println("Kontrolní výpis emailu -->" + email.getText() + "<--");
		//System.out.println("Kontrolní výpis hesla -->" + heslo.getText() + "<--");

		int ukazatel = buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn(email.getText(), heslo.getText(),
				buddyAplikace);
		if (ukazatel == 0) {
			//vyskočí modální okno
			ukazAlertBad();
		} else if (ukazatel == 1) {
			sceneBuddy(event);  /* přepnutí na buddyho */
			
		} else if (ukazatel == 2) {
			sceneExchange(event); /* přepnutí na exchange */
			;
		} else {
			sceneAdmin(event);   /* přepnutí na admina */;
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
	
}
