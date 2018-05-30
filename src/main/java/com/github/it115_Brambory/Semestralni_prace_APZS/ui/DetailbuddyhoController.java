package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Observable;

import javafx.application.Platform;
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
public class DetailbuddyhoController extends Pane implements Observer {
	
	private IBuddyAplikace buddyAplikace;	
	private Buddy vybranyBuddy;
	@FXML private TextField jmeno;
	@FXML private TextField prijmeni;
	@FXML private TextField email;
	@FXML private TextField pohlavi;
	@FXML private TextField statniprislusnost;
	@FXML private TextField adresa;
	@FXML private TextField datumnarozeni;
	@FXML private TextField xname;
	@FXML private TextField titul;
	@FXML private TextArea prihlasen;
	@FXML private TextArea textAreaTest;
	
	/**
     *  Metoda k inicializaci hry. Načte všechny potřebné prvky
     *  GUI a přidá observery.
     *  
	 * @throws SQLException - to je kvůli těm testům na konci metody
     */
	public void inicializuj(IBuddyAplikace buddyAplikace, Buddy vybranyBuddy) throws SQLException {
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		
		this.buddyAplikace = buddyAplikace;
		jmeno.setText(vybranyBuddy.getJmeno());
		prijmeni.setText(vybranyBuddy.getPrijmeni());
		email.setText(vybranyBuddy.getEmail());
		pohlavi.setText(vybranyBuddy.getPohlavi());
		statniprislusnost.setText(vybranyBuddy.getStatniPrislusnost());
		adresa.setText(vybranyBuddy.getAdresa());
		datumnarozeni.setText(vybranyBuddy.getDatumNarozeni());
		xname.setText(vybranyBuddy.getXname());
		titul.setText(vybranyBuddy.getTitul());
		prihlasen.setEditable(false);
		
		
		
		
		
		//---------------------------------------------------------------------------------------------------------------------------------
		//Ahoj, tohle mi tady nechte zakomentovaný, jsou to testy, že funguje databázový připojení
		//a že se data správně vkládaj do programu
		textAreaTest.setText("Ahoj, toto je test, že funguje okno\n");
		//jmeno.setText(this); Potřeba zíkávat hodnotu jednotlivých fieldů, nevím, jak to udělat
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logInTest();
		
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
