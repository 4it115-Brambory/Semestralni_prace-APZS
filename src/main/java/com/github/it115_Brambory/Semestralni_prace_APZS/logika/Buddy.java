package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Libor Zíka
 * 
 * Třída popisující Buddy studenta.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Buddy extends Student{

	private int id;
	private String xname;
	private String titul;
	private String adresa;
	
	/**
     * Konstruktor pro buddy studenta.
     * 
     * @param String email, String heslo, int access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String xname, String titul,
			String adresa.
     */
	public Buddy(String email, String heslo, int access, String jmeno, String prijmeni, String datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String xname, String titul,
			String adresa) {
		super(email, heslo, access, jmeno, prijmeni, datumNarozeni, telefon, pohlavi, statniPrislusnost);
		this.id = id;
		this.xname = xname;
		this.titul = titul;
		this.adresa = adresa;
	}

	/**
     * Getter na Id.
     * 
     * @return int id.
     */
	@Id
	public int getId() {
		return id;
	}
	
	/**
     * Setter na Id akce.
     * 
     * @param int id.
     */
	public void setId(int id) {
		this.id = id;
	}
	
	/**
     * Getter na xname.
     * 
     * @return String xname.
     */
	public String getXname() {
		return xname;
	}
	
	/**
     * Setter na Id xname.
     * 
     * @param String xname.
     */
	public void setXname(String xname) {
		this.xname = xname;
	}
	
	/**
     * Getter na titul.
     * 
     * @return String titul.
     */
	public String getTitul() {
		return titul;
	}
	
	/**
     * Setter na titul.
     * 
     * @param String titul.
     */
	public void setTitul(String titul) {
		this.titul = titul;
	}
	
	/**
     * Getter na adresu.
     * 
     * @return String xname.
     */
	public String getAdresa() {
		return adresa;
	}
	
	/**
     * Setter na adresu.
     * 
     * @param String id.
     */
	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Buddy [id=" + id + ", xname=" + xname + ", titul=" + titul + ", adresa=" + adresa + "]";
	}
}
