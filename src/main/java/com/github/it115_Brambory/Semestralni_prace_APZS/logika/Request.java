package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Třída popisující vztah mezi akcí a žadatelem v podobě žádosti.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Request {

	private int id;
	private Exchange zadatel;
	private Akce akce;
	private String stav;
	
	/**
     * Konstruktor pro request.
     * 
     * @param int id, Exchange zadatel, Akce akce.
     */
	public Request(int id, Exchange zadatel, Akce akce) {
		this.id = id;
		this.zadatel = zadatel;
		this.akce = akce;
		this.stav = "Pending";
		//pomocí setteru se dá "stav" přepsat na libovolný řetězec.
		//preferoval bych "Pending" nebo "Zaplaceno"
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
     * Getter na žadatele.
     * 
     * @return Exchange zadatel.
     */
	public Exchange getZadatel() {
		return zadatel;
	}
	
	/**
     * Setter na žadatele.
     * 
     * @param Exchange zadatel.
     */
	public void setZadatel(Exchange zadatel) {
		this.zadatel = zadatel;
	}
	
	/**
     * Getter na žadatele.
     * 
     * @return Akce zadatel.
     */
	public Akce getAkce() {
		return akce;
	}
	
	/**
     * Setter na žadatele.
     * 
     * @param Akce zadatel.
     */
	public void setAkce(Akce akce) {
		this.akce = akce;
	}
	
	/**
     * Getter na žadatele.
     * 
     * @return String zadatel.
     */
	public String getStav() {
		return stav;
	}
	
	/**
     * Setter na žadatele.
     * 
     * @param String zadatel.
     */
	public void setStav(String stav) {
		this.stav = stav;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Request [id=" + id + ", zadatel=" + zadatel + ", akce=" + akce + ", stav=" + stav + "]";
	}
}
