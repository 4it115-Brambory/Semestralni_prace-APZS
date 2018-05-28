package com.github.it115_Brambory.Semestralni_prace_APZS.ui;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

import java.util.Observer;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
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

		// ---------------------------------------------------------------------------------------------------------------------------------
		// Ahoj, tohle mi tady nechte zakomentovaný, jsou to testy, že funguje
		// databázový připojení
		// a že se data správně vkládají do programu
		textAreaTest.setText("Ahoj, toto je test, že funguje okno\n");

		// testování vkládání a upravování akcí - FUNGUJE
		/*
		 * this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().insertNovaAkce(
		 * "Pesi", "Pochodak", "5.6. 14:30 2018", "5.6. 18:30 2018", "Bezdez",
		 * "pesi vylet", 450, 5);
		 */
		/*
		 * this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().updateAkci(1,
		 * "Na kole", "Cyklovylet", "5.6. 14:30 2018", "5.6. 18:30 2018", "Bezdez",
		 * "pesi vylet", 450, 5);
		 */

		// testování přihlášení - FUNGUJE
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("yvvlado@mid.ru",
		// "LcKe8d2", this.buddyAplikace.getBuddyAplikace());
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("guitarmage@jazzfusion.com",
		// "g11Rm9oL", this.buddyAplikace.getBuddyAplikace());
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().logIn("lucifer@peklo.de",
		// "rumplcimprcampr", this.buddyAplikace.getBuddyAplikace());
		// System.out.println(this.buddyAplikace.getBuddyAplikace().getAktualniUzivatel().getEmail());

		// mazání - FUNGUJE
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().deleteAkce(1);
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().zjistiObsazenaAkce(2);

		// updatování requestu - FUNGUJE
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestSchvaleno(3);
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestZamitnuto(3);
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().setRequestZaplaceno(2);

		// get - zjisti obsazenost akce - FUNGUJE
		// this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().zjistiObsazenaAkce(3);

		// podával už exchange student na tuhle akci žádost? pokud ano, tak nemůže podat
		// znova - přečíst dokumentaci k návratovým hodnotám metod
		// - FUNGUJE
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().zjistiExistujiciRequestProExchange(3, 2);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().zjistiExistujiciRequestProExchange(3, 3);
		
		//test jestli funguje získávání seznamu buddy studentů - FUNGUJE
		//Map<Integer, Buddy> seznamBuddy = new HashMap<Integer, Buddy>();
		//seznamBuddy = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamBuddy();
		//System.out.println(seznamBuddy.get(5).getJmeno());
		
		//test jestli funguje získávání seznamu exchange studentů - FUNGUJE
		//Map<Integer, Exchange> seznamExchange = new HashMap<Integer, Exchange>();
		//seznamExchange = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchange();
		//System.out.println(seznamExchange.get(5).getJmeno());
		
		//test jestli funguje získávání seznamu akcí - FUNGUJE
		//Map<Integer, Akce> seznamakci = new HashMap<Integer, Akce>();
		//seznamakci = this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamAkci();
		//System.out.println(seznamakci.get(5).getNazev());
		
		//test jestli funguje získávání seznamu exchange studentů, kteří jsou přihlášeni na dané akci - FUNGUJE
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchangePrihlasenychNaAkci(1);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchangePrihlasenychNaAkci(2);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamExchangePrihlasenychNaAkci(3);
		
		//test jestli funguje získávání seznamu akcí - FUNGUJE
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getSeznamRequestu();
		
		//test jestli se vybere přiřazený buddy podle id exchange studenta - FUNGUJE
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getPrirazenehoBuddyStudenta(10);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().getPrirazenehoBuddyStudenta(5);
		
		//test kontroly existence přiřazení studentů
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().checkExistenciVztahuProBuddy(1);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().checkExistenciVztahuProBuddy(2);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().checkExistenciVztahuProExchange(5);
		//this.buddyAplikace.getBuddyAplikace().getDatabazeOperace().checkExistenciVztahuProExchange(6);
		
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
	}

}
