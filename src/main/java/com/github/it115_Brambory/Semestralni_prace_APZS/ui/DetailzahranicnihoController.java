package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou - slouží pro načtení detailu buddyho
 * 
 * @author Jan Mandík
 *
 */
public class DetailzahranicnihoController extends Pane implements Observer {
	
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
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}
	
}