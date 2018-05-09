package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Třída popisující zahraničního studenta.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Exchange extends Student{

	private int id;
	//jak se kurva udělá fotka :D, na tu asi prdim :D
	private String adresaCR;
	
	/**
     * Konstruktor pro exchange studenta.
     * 
     * @param String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String adresaCR.
     */
	public Exchange(String email, String heslo, boolean access, String jmeno, String prijmeni, Date datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, int id, String adresaCR) {
		super(email, heslo, access, jmeno, prijmeni, datumNarozeni, telefon, pohlavi, statniPrislusnost);
		this.id = id;
		this.adresaCR = adresaCR;
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
     * Getter na adresu exchange studenta v ČR.
     * 
     * @return String adresaCR.
     */
	public String getAdresa() {
		return adresaCR;
	}
	
	/**
     * Setter na adresu exchange studenta v ČR.
     * 
     * @param String adresaCR.
     */
	public void setAdresa(String adresaCR) {
		this.adresaCR = adresaCR;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Exchange [id=" + id + ", adresaCR=" + adresaCR + "]";
	}
}
