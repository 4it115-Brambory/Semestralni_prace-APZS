package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect.*;

import java.util.Observer;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Observable;
import javafx.application.Application;
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
	private void sceneExchange() throws IOException {
		System.out.println("Scene changing...");
		root = FXMLLoader
				.load(getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/prihlaseni.fxml"));
		window.setScene(new Scene(root));

	}

	/**
	 * Tahle metoda by se měla postarat o změnu Stage, nicméně nefunguje a nevím
	 * proč. Myslím, že by ještě měla načítat kontroler
	 */
	@FXML
	private void sceneAdmin() throws IOException {
		System.out.println("Scene changing...");
		root = FXMLLoader.load(getClass().getResource("prehledakciadmin.fxml"));
		window.setScene(new Scene(root));
	}

	/**
	 * Tahle metoda by se měla postarat o změnu Stage, nicméně nefunguje a nevím
	 * proč. Myslím, že by ještě měla načítat kontroler
	 */
	@FXML
	private void sceneBuddy() throws IOException {
		System.out.println("Scene changing...");
		root = FXMLLoader.load(getClass().getResource("prehledakcibuddy.fxml"));
		window.getScene().setRoot(root);
	}

	@FXML
	public void prihlasit() throws IOException {

		//kontrolní výpis emailu a hesla
		System.out.println("Kontrolní výpis emailu -->" + email.getText() + "<--");
		System.out.println("Kontrolní výpis hesla -->" + heslo.getText() + "<--");

		int ukazatel = buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn(email.getText(), heslo.getText(),
				buddyAplikace);
		if (ukazatel == 0) {
			//vyskočí modální okno
			ukazAlertBad();			
		} else if (ukazatel == 1) {
			sceneExchange();/* přepnutí na exchange */
		} else if (ukazatel == 2) {
			sceneBuddy();
			/* přepnutí na buddyho */;
		} else {
			sceneAdmin();
			/* přepnutí na admina */;
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
