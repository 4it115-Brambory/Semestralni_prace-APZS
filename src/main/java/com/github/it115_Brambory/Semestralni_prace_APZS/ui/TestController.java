package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.sql.SQLException;
import java.util.Observable;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;

/**
 * Kontroler, který zprostředkovává komunikaci mezi grafikou a logikou - slouží
 * k počátečnímu testování správnosti dotazů do DB
 * 
 * @author Libor Zíka
 *
 */
public class TestController extends GridPane implements Observer {

	private IBuddyAplikace buddyAplikace;
	@FXML
	private TextArea textAreaTest;

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
		// a že se data správně vkládají do programu
		textAreaTest.setText("Ahoj, toto je test, že funguje okno\n");
		/*
		 * testování vkládání a upravování akcí
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovaAkce("Pesi", "Pochodak", "5.6. 14:30 2018",
				"5.6. 18:30 2018", "Bezdez", "pesi vylet", 450, 5);
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().updateAkci(1, "Na kole", "Cyklovylet",
				"5.6. 14:30 2018", "5.6. 18:30 2018", "Bezdez", "pesi vylet", 450, 5);
		*/
		/*
		testování přihlášení
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("yvvlado@mid.ru", "LcKe8d2", this.buddyAplikace.getBuddyAplikace());
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("guitarmage@jazzfusion.com", "g11Rm9oL", this.buddyAplikace.getBuddyAplikace());
		this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("lucifer@peklo.de", "rumplcimprcampr", this.buddyAplikace.getBuddyAplikace());
		System.out.println(this.buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());
		*/
		
		
		
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
