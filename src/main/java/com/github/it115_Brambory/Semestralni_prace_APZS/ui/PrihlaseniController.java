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
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
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

	public TextField getEmail() {
		return email;
	}

	public PasswordField getHeslo() {
		return heslo;
	}

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

	@FXML public void prihlasit() throws IOException 
	
    {   FXMLLoader loader = new FXMLLoader();
		int ukazatel = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn(email.toString(), heslo.toString()); 
				switch (ukazatel)
				{case 1: ukazatel = 0; System.out.println("Zadané údaje nejsou platné"); break;
				case 2: ukazatel = 1;
				loader.setLocation(this.getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/TestWindow.fxml"));
				
		    	
				
				break;
				case 3: ukazatel = 2; 
				loader.setLocation(this.getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/TestWindow.fxml"));
				
		    	
				
				break;
				case 4: ukazatel = 3; 
				loader.setLocation(this.getClass().getResource("/com/github/it115_Brambory/Semestralni_prace_APZS/ui/TestWindow.fxml"));
				
		    	
				
				
				break;};				;
				Parent root = loader.load();    
        }

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
