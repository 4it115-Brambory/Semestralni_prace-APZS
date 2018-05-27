package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.util.Date;

/**
 * @author Libor Zíka
 * 
 * Třída popisující obecného studenta.
 * Ve třídách Exchange a Buddy jsou blíže vysvětleni potomci třídy - čeští studenti a zahraniční.
 * 
 */
public class Student extends Uzivatel{
	
	private String jmeno;
	private String prijmeni;
	private String datumNarozeni;
	private String telefon;
	private String pohlavi;
	private String statniPrislusnost;
	
	/**
     * Konstruktor pro obecného studenta.
     * Potomci třídy - buddy a exchange student.
     * 
     * @param String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost.
     */
	public Student(String email, String heslo, int access, String jmeno, String prijmeni, String datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost) {
		super(email, heslo, access);
		this.jmeno = jmeno;
		this.prijmeni = prijmeni;
		this.datumNarozeni = datumNarozeni;
		this.telefon = telefon;
		this.pohlavi = pohlavi;
		this.statniPrislusnost = statniPrislusnost;
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
     * Getter na datum narození studenta.
     * 
     * @return Date datumNarozeni.
     */
	public String getDatumNarozeni() {
		return datumNarozeni;
	}

	/**
     * Setter na datum narození studenta.
     * 
     * @param Date datumNarozeni.
     */
	public void setDatumNarozeni(String datumNarozeni) {
		this.datumNarozeni = datumNarozeni;
	}
	
	/**
     * Getter na telefonní číslo.
     * 
     * @return String telefon.
     */
	public String getTelefon() {
		return telefon;
	}
	
	/**
     * Setter na telefonní číslo.
     * 
     * @param String telefon.
     */
	public void setTelefon(String telefon) {
		this.telefon = telefon;
	}
	
	/**
     * Getter na pohlaví studenta.
     * 
     * @return String pohlavi.
     */
	public String getPohlavi() {
		return pohlavi;
	}
	
	/**
     * Setter na pohlaví studenta.
     * 
     * @param String pohlavi.
     */
	public void setPohlavi(String pohlavi) {
		this.pohlavi = pohlavi;
	}
	
	/**
     * Getter na státní příslušnost.
     * 
     * @return String statniPrislusnost.
     */
	public String getStatniPrislusnost() {
		return statniPrislusnost;
	}
	
	/**
     * Setter na státní příslušnost.
     * 
     * @param String statniPrislusnost.
     */
	public void setStatniPrislusnost(String statniPrislusnost) {
		this.statniPrislusnost = statniPrislusnost;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Student [jmeno=" + jmeno + ", prijmeni=" + prijmeni + ", datumNarozeni="
				+ datumNarozeni + ", telefon=" + telefon + ", pohlavi=" + pohlavi + ", statniPrislusnost="
				+ statniPrislusnost + "]";
	}
	
}
