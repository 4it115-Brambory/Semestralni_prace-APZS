package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.sql.SQLException;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou - slouží k počátečnímu testování správnosti dotazů do DB
 * 
 * @author Libor Zíka
 *
 */
public class TestController extends GridPane implements Observer {
	
	private IBuddyAplikace buddyAplikace;	
	@FXML private TextArea textAreaTest;
	
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
		//a že se data správně vkládají do programu
		textAreaTest.setText("Ahoj, toto je test, že funguje okno\n");
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logInTest();
		//("dd.MM. HH:mm yyyy")
		
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovaAkce("Pesi", "Pochodak",
				"5.6. 14:30 2018", "5.6. 18:30 2018", "Bezdez", "pesi vylet", 450, 5);
		
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
	
}
