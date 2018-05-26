package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

/**
 * @author Libor Zíka
 * 
 *  Rozhraní které musí implementovat BuddyAplikace, je na ně navázáno uživatelské rozhraní
 *
 */
public interface IBuddyAplikace {

	/**
     *  Metoda vrátí odkaz na BuddyAplikaci.
     *  
     *  @return     odkaz na BuddyAplikaci
     */
	public BuddyAplikace getBuddyAplikace();
	
	/**
     *  Metoda nastaví konec aplikace
     */
	public void setKonecBuddyAplikace();
	
	/** 
     * Vrací informaci o tom, zda BuddyAplikace již skončila.
     * 
     * @return   true = konec aplikace, false = aplikace pokračuje
     */
	public boolean konecBuddyAplikace();
}
