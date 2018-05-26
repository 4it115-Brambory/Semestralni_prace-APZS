package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Libor Zíka
 * 
 * Třída popisující vztah mezi studentem zahraničním a buddy studentem.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class VztahStudentu {

	private int id;
	private Exchange exchange;
	private Buddy buddy;
	
	/**
     * Konstruktor pro definici relace buddy a exchange studenta.
     * 
     * @param int id, Exchange exchange, Buddy buddy.
     */
	public VztahStudentu(int id, Exchange exchange, Buddy buddy) {
		super();
		this.id = id;
		this.exchange = exchange;
		this.buddy = buddy;
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
     * Getter na exchange studenta.
     * 
     * @return Exchange exchange.
     */
	public Exchange getExchange() {
		return exchange;
	}
	
	/**
     * Setter na exchange studenta.
     * 
     * @param Exchange exchange.
     */
	public void setExchange(Exchange exchange) {
		this.exchange = exchange;
	}
	
	/**
     * Getter na buddy studenta.
     * 
     * @return Buddy buddy.
     */
	public Buddy getBuddy() {
		return buddy;
	}
	
	/**
     * Setter na buddy studenta.
     * 
     * @param Buddy buddy.
     */
	public void setBuddy(Buddy buddy) {
		this.buddy = buddy;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "VztahStudentu [id=" + id + ", exchange=" + exchange + ", buddy=" + buddy + "]";
	}
}
