package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.util.Date;
import java.util.Map;

//import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

public class BuddyAplikace implements IBuddyAplikace {
	
	private boolean konecBuddyAplikace = false;
	private Map<Integer, Buddy> seznamBuddy;
	private Map<Integer, Exchange> seznamExchange;
	private Map<Integer, Admin> seznamAdminu;
	private Map<Integer, Akce> seznamAkci;
	private Map<Integer, Request> seznamRequestu;
	private Map<Integer, VztahStudentu> seznamVztahuStudentu;
	private Uzivatel aktualniUzivatel;
	
	/**
     *  Konstruktor buddyAplikace. Načte data z databáze do patřičných seznamů.
     *  
     */
	public BuddyAplikace() {
		// TODO načíst data z databáze
	}
	
	/**
     *  Metoda uloží data z aplikace do databáze.
     *  
     *  @return boolean
     */
	public boolean ulozData() {
		//když proběhlo uložení dobře
		if (true){
			//TODO
			//uložit všechna data do databáze
			//bude se tak dít po stisknutní tlačítka "uložit", nebo před koncem aplikace, kdy se
			//ve vyskakovacím okně zeptáme uživatele, zda si přeje uložit.
			//
			//možná by bylo dobrý data z databáze smazat a pak tam nahrát komplet nový. Jinak nevim jak
			//snadno zaznamenávat zvlášť změny pro zápis a zvlášť změny pro vymazání nebo změnu.
	}
		return false;
	}
	//----------------------------------------------------------------------------
	//			Metody pro přihlášení a odhlášení
	//----------------------------------------------------------------------------
	/**
     *  Metoda sloužící k přihlášení uživatele do aplikace. Pokud přihlášení proběhne
     *  úspěšně, takto přihlášený uživatel bude v promenně aktualniUzivatel
     *  
     *  @param String email, String heslo
     *  
     *  @return boolean
     */
	public boolean logIn(String email, String heslo){
		
		if (kontrolaPritomnostiAdmina(seznamAdminu, email, heslo)) {//když je email v tabulce admin tak zkontroluj heslo a pak nastav aktualniho uzivatele a access
			//TODO
			return true;
		}else if (kontrolaPritomnostiExchange(seznamExchange, email, heslo)) {//když je email v tabulce buddy tak zkontroluj heslo a pak nastav aktualniho uzivatele a access
			//TODO
			return true;
		}else if (kontrolaPritomnostiBuddy(seznamBuddy, email, heslo)) {//když je email v tabulce exchange tak zkontroluj heslo a pak nastav aktualniho uzivatele a access
			//TODO
			return true;
		}else {
			return false;
		}
	}
	/**
     *  Metoda kontroluje přítomnost uživatele v seznamu adminů.
     *  
     *  @param Map<Integer, Admin> tabulka, String email, String heslo
     *  
     *  @return boolean
     */
	public boolean kontrolaPritomnostiAdmina(Map<Integer, Admin> tabulka, String email, String heslo) {
		//TODO
		//if (je v tabulce && se shoduje heslo)
		//tak return true;
		return false;
	}
	/**
     *  Metoda kontroluje přítomnost uživatele v seznamu exchange studentů.
     *  
     *  @param Map<Integer, Exchange> tabulka, String email, String heslo
     *  
     *  @return boolean
     */
	public boolean kontrolaPritomnostiExchange(Map<Integer, Exchange> tabulka, String email, String heslo) {
		//TODO
		//if (je v tabulce && se shoduje heslo)
		//tak return true;
		return false;
	}
	/**
     *  Metoda kontroluje přítomnost uživatele v seznamu buddy studentů.
     *  
     *  @param Map<Integer, Buddy> tabulka, String email, String heslo
     *  
     *  @return boolean
     */
	public boolean kontrolaPritomnostiBuddy(Map<Integer, Buddy> tabulka, String email, String heslo) {
		//TODO
		//if (je v tabulce && se shoduje heslo)
		//tak return true;
		return false;
	}
	
	/**
     *  Metoda odhlásí přihlášeného uživatele
     *  
     *  @return boolean
     */
	public boolean logOut(){
		//TODO
		//dotaz na uložení
		aktualniUzivatel = null;
		return true;
	}
	
	//----------------------------------------------------------------------------
	//		Gettery na seznamy + getter na aktuálního uživatele
	//----------------------------------------------------------------------------
	/**
     *  Getter na aktualne prihlaseneho uzivatele.
     *  V UI se pak schvaluje akce na základě jeho accessu.
     *  
     *  @return Uzivatel aktualniUzivatel
     */
	public Uzivatel getAktualniUzivatel() {
		return aktualniUzivatel;
	}
	
	/**
     *  Getter na seznam requestů - zpráv/upozornění pro admina,
     *  že se exchange student přihlásil na nějakou akci.
     *  
     *  @return Map<Integer, Request> seznamRequestu
     */
	public Map<Integer, Request> getSeznamRequestu() {
		return seznamRequestu;
	}
	
	/**
     *  Getter na seznam akcí.
     *  
     *  @return Map<Integer, Akce> seznamAkci
     */
	public Map<Integer, Akce> getSeznamAkci() {
		return seznamAkci;
	}
	
	/**
     *  Getter na seznam buddy studentů.
     *  
     *  @return Map<Integer, Buddy> seznamBuddy
     */
	public Map<Integer, Buddy> getSeznamBuddy() {
		return seznamBuddy;
	}
	
	/**
     *  Getter na seznam exchange studentů.
     *  
     *  @return Map<Integer, Exchange> seznamExchange
     */
	public Map<Integer, Exchange> getSeznamExchange() {
		return seznamExchange;
	}
	
	/**
     *  Getter na seznam adminů.
     *  
     *  @return Map<Integer, Admin> seznamAdminu
     */
	public Map<Integer, Admin> getSeznamAdminu() {
		return seznamAdminu;
	}
	
	/**
     *  Getter na seznam vztahů mezi studenty - buddy a exchange.
     *  
     *  @return Map<Integer, VztahStudentu> seznamVztahuStudentu
     */
	public Map<Integer, VztahStudentu> getSeznamVztahuStudentu() {
		return seznamVztahuStudentu;
	}
	
	//----------------------------------------------------------------------------
	//		Metody pro přidávání objektů do seznamů
	//			pozn.: admina nelze přidat, prostě ne :D
	//			leda tak přímo v databázi no... :D
	//----------------------------------------------------------------------------
	
	/**
     *  Metoda sloužící k přidání buddyho do seznamu buddy studentů.
     *  Nejprve metoda zjistí, jestli už takový buddy se stejným ID v seznamu náhodou není.
     *  
     *  @param String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String xname, String titul,
			String adresa
     *  @return boolean
     */
	public boolean pridejBuddyho(String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String xname, String titul,
			String adresa) {
		if (seznamBuddy.containsKey(id)) {
			return false;
		}else {
			seznamBuddy.put(id, new Buddy(email, heslo, access, jmeno, prijmeni, datumNarozeni,
					telefon, pohlavi, statniPrislusnost, id, xname, titul, adresa));
			return true;
		}
	}
	
	/**
     *  Metoda sloužící k přidání exchange do seznamu exchange studentů.
     *  Nejprve metoda zjistí, jestli už takový exchange se stejným ID v seznamu náhodou není.
     *  
     *  @param String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String adresaCR
     *  @return boolean
     */
	public boolean pridejExchange(String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String adresaCR) {
		if (seznamExchange.containsKey(id)) {
			return false;
		}else {
			seznamExchange.put(id, new Exchange(email, heslo, access, jmeno, prijmeni, datumNarozeni, telefon, pohlavi, statniPrislusnost, id, adresaCR));
			return true;
		}
	}
	
	/**
     *  Metoda sloužící k přidání requestu do seznamu requestů.
     *  Nejprve metoda zjistí, jestli už takový request se stejným ID v seznamu náhodou není.
     *  
     *  @param int id, Exchange zadatel, Akce akce
     *  @return boolean
     */
	public boolean pridejRequest(int id, Exchange zadatel, Akce akce) {
		if (seznamRequestu.containsKey(id)) {
			return false;
		}else {
			seznamRequestu.put(id, new Request(id, zadatel, akce));
			return true;
		}
	}
	
	/**
     *  Metoda sloužící k přidání akce do seznamu akcí.
     *  Nejprve metoda zjistí, jestli už taková akce se stejným ID v seznamu náhodou není.
     *  
     *  @param int id, String druh, String nazev, Date datumACasOd, Date datumACasDo, String misto, String popis,
			int cena, int maxUcast
     *  @return boolean
     */
	public boolean pridejAkci(int id, String druh, String nazev, Date datumACasOd, Date datumACasDo, String misto, String popis,
			int cena, int maxUcast) {
		if (seznamAkci.containsKey(id)) {
			return false;
		}else {
			seznamAkci.put(id, new Akce(id, druh, nazev, datumACasOd, datumACasDo, misto, popis,
					cena, maxUcast));
			return true;
		}
	}
	
	/**
     *  Metoda sloužící k přidání vztahu studentů do seznamu vztahů studentů.
     *  Nejprve metoda zjistí, jestli už takový vztah se stejným ID v seznamu náhodou není.
     *  
     *  @param int id, Exchange exchange, Buddy buddy
     *  @return boolean
     */
	public boolean pridejVztahStudentu(int id, Exchange exchange, Buddy buddy) {
		if (seznamVztahuStudentu.containsKey(id)) {
			return false;
		}else {
			seznamVztahuStudentu.put(id, new VztahStudentu(id, exchange, buddy));
			return true;
		}
	}
	
	//----------------------------------------------------------------------------
	//		Metody pro odebírání objektů ze seznamů
	//			pozn.: admina nelze odebrat, prostě ne :D
	//			leda tak přímo z databáze no... :D
	//----------------------------------------------------------------------------
	
	/**
     *  Metoda na odebrání buddyho se seznamu buddy studentů
     *  
     *  @param int id buddy studenta
     *  @return boolean
     */
	public boolean vymazBuddyho(int id) {
		if (seznamBuddy.containsKey(id)) {
			seznamBuddy.remove(id);
			return true;
		}else {
			return false;
		}		
	}
	
	/**
     *  Metoda na odebrání exchange se seznamu exchange studentů
     *  
     *  @param int id exchange studenta
     *  @return boolean
     */
	public boolean vymazExchange(int id) {
		if (seznamExchange.containsKey(id)) {
			seznamExchange.remove(id);
			return true;
		}else {
			return false;
		}		
	}
	
	/**
     *  Metoda na odebrání vztahu exchange a buddy studenta
     *  
     *  @param int id vztahu studentů
     *  @return boolean
     */
	public boolean vymazVztahStudentu(int id) {
		if (seznamVztahuStudentu.containsKey(id)) {
			seznamVztahuStudentu.remove(id);
			return true;
		}else {
			return false;
		}		
	}
	
	/**
     *  Metoda na odebrání requestu ze seznamu requestů
     *  
     *  @param int id requestu
     *  @return boolean
     */
	public boolean vymazRequest(int id) {
		if (seznamRequestu.containsKey(id)) {
			seznamRequestu.remove(id);
			return true;
		}else {
			return false;
		}		
	}
	
	/**
     *  Metoda na odebrání akce ze seznamu akcí
     *  
     *  @param int id akce
     *  @return boolean
     */
	public boolean vymazAkci(int id) {
		if (seznamAkci.containsKey(id)) {
			seznamAkci.remove(id);
			return true;
		}else {
			return false;
		}		
	}
		
	//----------------------------------------------------------------------------
	//		Zbytek, nastavení konce aplikace, getter na zjištění konce aplikace
	//----------------------------------------------------------------------------
	/**
     *  Nastaví, že je konec aplikace,
     *  mohou ji použít i další implementace rozhraní (?asi?snad?) IBuddyAplikace.
     *  hodnota true = konec aplikace, false = aplikace pokračuje
     */
    public void setKonecBuddyAplikace() {
        konecBuddyAplikace = true;
    }
	
    /**
     *  Tento getter je asi k ničemu :D, ale kdyby náhodou :D
     *  
     *  @return BuddyAplikace this.
     */
	@Override
	public BuddyAplikace getBuddyAplikace() {
		return this;
	}

	//tohle asi pak dát do observera kvůli konci programu. Před koncem ať ještě
	//vyskočí okno, že doporučujete uložit data před koncem aplikace
	/**
     *  Getter pro zjištění, jestli je konec aplikace, nebo ještě ne.
     *  Je to stejné, jako v adventuře -> hodnota true = konec aplikace, false = aplikace pokračuje
     *  
     *  @return boolean konecBuddyAplikace.
     */
	@Override
	public boolean konecBuddyAplikace() {
		return konecBuddyAplikace;
	}

}
