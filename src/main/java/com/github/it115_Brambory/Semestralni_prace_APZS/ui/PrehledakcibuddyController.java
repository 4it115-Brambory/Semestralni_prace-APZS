package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.main.Start;

import java.util.Observer;
import java.awt.TextField;
import java.sql.SQLException;
import java.util.Observable;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou
 * a logikou - slouží pro načtení přehledu buddy
 * 
 * @author Jan Mandík
 *
 */
public class PrehledakcibuddyController extends Pane implements Observer {

		//zjistit, jak se používá tableview
		private IBuddyAplikace buddyAplikace;	
		@FXML private TableColumn typ;
		@FXML private TableColumn nazev;
		@FXML private TableColumn casDo;
		@FXML private TableColumn casOd;
		@FXML private TableColumn misto;

		@FXML private TableColumn cena;
		@FXML private TextArea prihlasen;

	/**
     *  Metoda k inicializaci hry. Načte všechny potřebné prvky
     *  GUI a přidá observery.
     *  
	 * @throws SQLException - to je kvůli těm testům na konci metody
     */
	public void inicializuj(IBuddyAplikace buddyAplikace) throws SQLException {
		
		this.buddyAplikace = buddyAplikace;
		prihlasen.setText(buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		prihlasen.setEditable(false);
		
		
		
		
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
	
	//odhlašovací metoda, hádám, že bude stačit zabít celou aplikaci
		@FXML
		private void odhlasit() throws Exception {
			Platform.exit();
			Start.main(null); //tohle by mělo aplikaci zas spustit, ale nějak se to neděje, tak na to kašlu. Hlavně, že se to zavře
		}
	
}

