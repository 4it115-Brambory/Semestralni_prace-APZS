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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou - slouží pro načtení přehledu buddy
 * 
 * @author Jan Mandík
 *
 */
public class SuperController extends Pane implements Observer {
	//zjistit, jak se používá tableview
	private IBuddyAplikace buddyAplikace;	
	
	@FXML private TextArea prihlasen;

	/**
     *  Metoda k inicializaci hry. Načte všechny potřebné prvky
     *  GUI a přidá observery.
     *  
	 * @throws SQLException - to je kvůli těm testům na konci metody
     */
	
	public void inicializuj(IBuddyAplikace buddyAplikace) {  
    
		
		this.buddyAplikace = buddyAplikace;
		
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);
		
		
	}
	
	
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
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

