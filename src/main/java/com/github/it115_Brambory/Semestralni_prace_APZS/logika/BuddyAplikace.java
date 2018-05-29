package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect.DBTransakce;

//import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

/**
 * 
 * @author Libor Zíka
 *
 *         Hlavní třída logiky, která si drží data
 */
public class BuddyAplikace implements IBuddyAplikace {

	private boolean konecBuddyAplikace = false;
	private Map<Integer, Buddy> seznamBuddy;
	private Map<Integer, Exchange> seznamExchange;
	private Map<Integer, Admin> seznamAdminu;
	private Map<Integer, Akce> seznamAkci;
	private Map<Integer, Request> seznamRequestu;
	private Map<Integer, VztahStudentu> seznamVztahuStudentu;
	// zde stačí typ uživatel, protože stačí email, heslo a access
	// protože email a heslo je potřeba k přihlášení a access určuje tabulku, ze
	// které uživatel pochází - tedy "práva" pro provádění akcí
	// tedy jestli je to buddy, exchange nebo admin. Jak provedete kontrolu
	// oprávnění nechám na vás :)
	private Uzivatel aktualniUzivatel;
	private DBTransakce databazeOperace; // <- odsud používejte ty metody, jsou to v podstatě sql dotazy
	// jsou tam metody na přidávání, úpravu, mazání a get(select), takže s daty
	// pracujte přes tyto metody,
	// ať se to rovnou mění v databázi a není starost z dalším ukládáním

	/**
	 * Konstruktor buddyAplikace. Načte data z databáze do patřičných seznamů.
	 * 
	 * @throws SQLException
	 * 
	 */
	public BuddyAplikace() /* throws SQLException */ {

		seznamBuddy = new HashMap();
		seznamExchange = new HashMap();
		seznamAdminu = new HashMap();
		seznamAkci = new HashMap();
		seznamRequestu = new HashMap();
		seznamVztahuStudentu = new HashMap();
		databazeOperace = new DBTransakce();

		// TODO - něco sem napište :D asi něco k inicializaci, aby to fungovalo no :D

		// data z databáze se budou načítat asi až v jednotlivých FXML, zavolá se metoda
		// pro určitý SQL příkaz a pak se
		// přiřadí do proměnné této třídy, na ně jsou pak gettery.
		// takto - databazeOperace.metoda(parametry);

	}

	// ----------------------------------------------------------------------------
	// Metody pro přihlášení a odhlášení
	//
	// Metoda sloužící k přihlášení uživatele do aplikace je implementována
	// ve třídě DBTransakce, protože je zapotřebí komunikace s DB.
	// ----------------------------------------------------------------------------

	/**
	 * Metoda odhlásí přihlášeného uživatele tak, že nastaví hodnotu proměnné
	 * aktualniUzivatel na null. Je nutné přímo v controlleru nastavit aktuální okno
	 * na přihlašování.
	 * 
	 * @return boolean
	 */
	public void logOut() {
		aktualniUzivatel = null;
	}

	// ----------------------------------------------------------------------------
	// Gettery na databazeOperace, abychom v controllerech mohli používat DB metody
	// ----------------------------------------------------------------------------
	/**
	 * Getter na databazeOperace. Nezapomenout se v UI ptát na hodnotu atributu
	 * access, jen pro jistotu... Stejně by měl každej uživatel mít svoje FXML, kde
	 * se mu nabízej ty akce, asi jsem jen trochu paranoidní už :D
	 * 
	 * @return Uzivatel aktualniUzivatel
	 */
	public DBTransakce getDatabazeOperace() {
		return databazeOperace;
	}

	// ----------------------------------------------------------------------------
	// Gettery na seznamy + getter na aktuálního uživatele
	// ----------------------------------------------------------------------------
	/**
	 * Getter na aktualne prihlaseneho uzivatele. V UI se pak schvaluje akce na
	 * základě jeho accessu.
	 * 
	 * @return Uzivatel aktualniUzivatel
	 */
	public Uzivatel getAktualniUzivatel() {
		return aktualniUzivatel;
	}

	public void setAktualniUzivatel(Uzivatel uzivatel) {
		aktualniUzivatel = uzivatel;
	}

	/**
	 * Getter na seznam requestů - zpráv/upozornění pro admina, že se exchange
	 * student přihlásil na nějakou akci.
	 * 
	 * @return Map<Integer, Request> seznamRequestu
	 */
	public Map<Integer, Request> getSeznamRequestu() {
		return seznamRequestu;
	}

	/**
	 * Getter na seznam akcí.
	 * 
	 * @return Map<Integer, Akce> seznamAkci
	 */
	public Map<Integer, Akce> getSeznamAkci() {
		return seznamAkci;
	}

	/**
	 * Getter na seznam buddy studentů.
	 * 
	 * @return Map<Integer, Buddy> seznamBuddy
	 */
	public Map<Integer, Buddy> getSeznamBuddy() {
		return seznamBuddy;
	}
	
	public Collection<Buddy> getSeznamBuddyKolekce() {
		return Collections.unmodifiableCollection (seznamBuddy.values());
	}

	/**
	 * Getter na seznam exchange studentů.
	 * 
	 * @return Map<Integer, Exchange> seznamExchange
	 */
	public Map<Integer, Exchange> getSeznamExchange() {
		return seznamExchange;
	}

	/**
	 * Getter na seznam adminů.
	 * 
	 * @return Map<Integer, Admin> seznamAdminu
	 */
	public Map<Integer, Admin> getSeznamAdminu() {
		return seznamAdminu;
	}

	/**
	 * Getter na seznam vztahů mezi studenty - buddy a exchange.
	 * 
	 * @return Map<Integer, VztahStudentu> seznamVztahuStudentu
	 */
	public Map<Integer, VztahStudentu> getSeznamVztahuStudentu() {
		return seznamVztahuStudentu;
	}

	// ----------------------------------------------------------------------------
	// Zbytek, nastavení konce aplikace, getter na zjištění konce aplikace
	// ----------------------------------------------------------------------------
	/**
	 * Nastaví, že je konec aplikace, mohou ji použít i další implementace rozhraní
	 * (?asi?snad?) IBuddyAplikace. hodnota true = konec aplikace, false = aplikace
	 * pokračuje
	 */
	public void setKonecBuddyAplikace() {
		konecBuddyAplikace = true;
	}

	/**
	 * Tento getter je asi k ničemu :D, ale kdyby náhodou :D
	 * 
	 * @return BuddyAplikace this.
	 */
	@Override
	public BuddyAplikace getBuddyAplikace() {
		return this;
	}

	// tohle asi pak dát do observera kvůli konci programu. Před koncem ať ještě
	// vyskočí okno, že doporučujete uložit data před koncem aplikace
	/**
	 * Getter pro zjištění, jestli je konec aplikace, nebo ještě ne. Je to stejné,
	 * jako v adventuře -> hodnota true = konec aplikace, false = aplikace pokračuje
	 * 
	 * @return boolean konecBuddyAplikace.
	 */
	@Override
	public boolean konecBuddyAplikace() {
		return konecBuddyAplikace;
	}

}
