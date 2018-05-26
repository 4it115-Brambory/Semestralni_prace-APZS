package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Libor Zíka
 * 
 * Třída popisující vztah mezi akcí a žadatelem v podobě žádosti.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Request {

	private int id;
	private Exchange zadatel;//žadatel = exchange student
	private Akce akce;
	private boolean zaplaceno;
	//false - nezaplaceno, true - zaplaceno
	private boolean schvaleno;
	//false - neschvaleno, true - schvaleno
	
	/**
     * Konstruktor pro request.
     * 
     * @param int id, Exchange zadatel, Akce akce.
     */
	public Request(int id, Exchange zadatel, Akce akce) {
		this.id = id;
		this.zadatel = zadatel;
		this.akce = akce;
		this.zaplaceno = false;
		this.schvaleno = false;
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
     * Getter na akci.
     * 
     * @return Akce akce.
     */
	public Akce getAkce() {
		return akce;
	}
	
	/**
     * Setter na akci.
     * 
     * @param Akce akce.
     */
	public void setAkce(Akce akce) {
		this.akce = akce;
	}
	
	/**
     * Getter na zaplaceno.
     * 
     * @return boolean zaplaceno.
     */
	public boolean getZaplaceno() {
		return zaplaceno;
	}
	
	/**
     * Nastaví hodnotu zaplaceno na true -> žadatel zaplatil za akci.
     * 
     */
	public void setZaplaceno() {
		zaplaceno = true;
	}

	/**
     * Getter na schváleno.
     * 
     * @return boolean schvaleno.
     */
	public boolean getSchvaleno() {
		return schvaleno;
	}
	
	/**
     * Nastaví hodnotu schvaleno na true -> admin schválil žádost o přihlášení na akci.
     * 
     */
	public void setSchvaleno() {
		schvaleno = true;
	}
	
	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Request [id=" + id + ", zadatel=" + zadatel + ", akce=" + akce + ", zaplaceno=" + zaplaceno + "]";
	}
}
