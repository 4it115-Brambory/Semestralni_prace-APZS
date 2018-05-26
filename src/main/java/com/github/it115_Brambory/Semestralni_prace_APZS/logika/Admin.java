package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Libor Zíka
 * 
 * Třída popisující administrátora.
 * Moc atributů nemá, ale potřebuje se jen přihlásit a dělat úpravy.
 * 
 */
@Entity
public class Admin extends Uzivatel{
	
	private String jmeno;
	private String prijmeni;
	private int id;
	
	/**
     * Konstruktor pro admina.
     * 
     * @param String email, String heslo, boolean access, String jmeno, String prijmeni, int id.
     */
	public Admin(String email, String heslo, int access, String jmeno, String prijmeni, int id) {
		super(email, heslo, access);
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.id = id;
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
     * Getter na jméno.
     * 
     * @return String jmeno.
     */
	public String getJmeno() {
		return jmeno;
	}
	
	/**
     * Setter na jméno.
     * 
     * @param String jmeno.
     */
	public void setJmeno(String jmeno) {
		this.jmeno = jmeno;
	}
	
	/**
     * Getter na příjmení.
     * 
     * @return String prijmeni.
     */
	public String getPrijmeni() {
		return prijmeni;
	}
	
	/**
     * Setter na příjmení.
     * 
     * @param String prijmeni.
     */
	public void setPrijmeni(String prijmeni) {
		this.prijmeni = prijmeni;
	}
	
	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Student [jmeno=" + jmeno + ", prijmeni=" + prijmeni + "]";
	}
	
}
