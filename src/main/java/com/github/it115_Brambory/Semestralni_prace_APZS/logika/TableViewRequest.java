package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 * @author Libor Zíka
 * 
 * Třída složící pro získání žádostí z databáze, v takové formě, aby se z nich dal dobře sestavit TableView
 * 
 * 
 */
public class TableViewRequest {

	private SimpleStringProperty jmeno; // exchange
	private SimpleStringProperty prijmeni; // exchange
	private SimpleStringProperty telefon; // exchange
	private SimpleStringProperty stat; // exchange
	private SimpleStringProperty datumNarozeni; // exchange
	private SimpleStringProperty nazevAkce; // akce
	private SimpleIntegerProperty prihlasenych; // hmm
	private SimpleIntegerProperty maxUcast; // maxUcast akce
	private SimpleIntegerProperty id; // request Id
	private SimpleStringProperty zaplaceno; // request
	private SimpleStringProperty schvaleno; // request
	
	/**
     * Konstruktor TableView
     * 
     * 
     * 
     * @param String jmeno, String prijmeni, String telefon, String stat, String datumNarozeni,
			String nazevAkce, Integer prihlasenych, Integer maxUcast, Integer id, String zaplaceno, String schvaleno.
     */
	public TableViewRequest(String jmeno, String prijmeni, String telefon, String stat, String datumNarozeni,
			String nazevAkce, Integer prihlasenych, Integer maxUcast, Integer id, String zaplaceno, String schvaleno) {

		this.jmeno = new SimpleStringProperty(jmeno);
		this.prijmeni = new SimpleStringProperty(prijmeni);
		this.telefon = new SimpleStringProperty(telefon);
		this.stat = new SimpleStringProperty(stat);
		this.datumNarozeni = new SimpleStringProperty(datumNarozeni);
		this.nazevAkce = new SimpleStringProperty(nazevAkce);
		this.prihlasenych = new SimpleIntegerProperty(prihlasenych);
		this.maxUcast = new SimpleIntegerProperty(maxUcast);
		this.id = new SimpleIntegerProperty(id);
		this.zaplaceno = new SimpleStringProperty(zaplaceno);
		this.schvaleno = new SimpleStringProperty(schvaleno);

	}
	
	
	/**
     * Getter na id
     * 
     * @return Integrer ID.
     */
	public Integer getId() {
		return id.get();
	}

	/**
     * Setter na id
     * 
     * @return Integrer ID.
     */
	public void setId(Integer id) {
		this.id.set(id);
	}

	/** getter jmena
	 * @return String jmeno
	 */
	public String getJmeno() {
		return jmeno.get();
	}

	/** setter jmena
	 * @param jmeno
	 */
	public void setJmeno(String jmeno) {
		this.jmeno.set(jmeno);
	}

	/** getter prijmeni
	 * @return String prijmeni
	 */
	public String getPrijmeni() {
		return prijmeni.get();
	}

	/** setter prijmeni
	 * @param prijmeni
	 */
	public void setPrijmeni(String prijmeni) {
		this.prijmeni.set(prijmeni);
	}

	/** getter telefonu
	 * @return String telefon
	 */
	public String getTelefon() {
		return telefon.get();
	}

	/** setter telefonu
	 * @param telefon
	 */
	public void setTelefon(String telefon) {
		this.telefon.set(telefon);
	}

	/** getter stat
	 * @return String stat
	 */
	public String getStat() {
		return stat.get();
	}

	/** setter stat
	 * @param stat
	 */
	public void setStat(String stat) {
		this.stat.set(stat);
	}

	/** Getter data narození
	 * @return String datumNarozeni
	 */
	public String getDatumNarozeni() {
		return datumNarozeni.get();
	}

	/** setter data narození
	 * @param datumNarozeni
	 */
	public void setDatumNarozeni(String datumNarozeni) {
		this.datumNarozeni.set(datumNarozeni);
	}

	/** getter názvu akce
	 * @return String nazevAkce
	 */
	public String getNazevAkce() {
		return nazevAkce.get();
	}

	/** setter názvu akce
	 * @param nazevAkce
	 */
	public void setNazevAkce(String nazevAkce) {
		this.nazevAkce.set(nazevAkce);
	}

	/** Getter počtu přihlášených
	 * @return Integrer prihlasenych
	 */
	public Integer getPrihlasenych() {
		return prihlasenych.get();
	}

	/** Setter počtu přihlášených
	 * 
	 * @param prihlasenych
	 */
	public void setPrihlasenych(Integer prihlasenych) {
		this.prihlasenych.set(prihlasenych);
	}

	/** Getter Maximální účasti
	 * @return Integrer MaxUcast
	 */
	public Integer getMaxUcast() {
		return maxUcast.get();
	}

	/** Setter maximální účasti
	 * @param maxUcast
	 */
	public void setMaxUcast(Integer maxUcast) {
		this.maxUcast.set(maxUcast);
	}

	/** getter zaplaceno
	 * @return String zaplaceno
	 */
	public String getZaplaceno() {
		return zaplaceno.get();
	}

	/** Setter zaplaceno
	 * @param zaplaceno
	 */
	public void setZaplaceno(String zaplaceno) {
		this.zaplaceno.set(zaplaceno);
	}
	
	/** Getter schvaleno
	 * @return schvaleno
	 */
	public String getSchvaleno() {
		return schvaleno.get();
	}

	/** Setter schvaleno
	 * @param schvaleno
	 */
	public void setSchvaleno(String schvaleno) {
		this.schvaleno.set(schvaleno);
	}
}
