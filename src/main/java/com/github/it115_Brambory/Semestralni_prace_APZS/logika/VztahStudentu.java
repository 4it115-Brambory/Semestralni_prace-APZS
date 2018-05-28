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
	private int exchange_id;
	private int buddy_id;
	
	/**
     * Konstruktor pro definici relace buddy a exchange studenta.
     * 
     * @param int id, Exchange exchange, Buddy buddy.
     */
	public VztahStudentu(int id, int exchange_id, int buddy_id) {
		super();
		this.id = id;
		this.exchange_id = exchange_id;
		this.buddy_id = buddy_id;
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
	public Integer getExchangeId() {
		return exchange_id;
	}
	
	/**
     * Setter na exchange studenta.
     * 
     * @param Exchange exchange.
     */
	public void setExchangeId(int exchange_id) {
		this.exchange_id = exchange_id;
	}
	
	/**
     * Getter na buddy studenta.
     * 
     * @return Buddy buddy.
     */
	public int getBuddyId() {
		return buddy_id;
	}
	
	/**
     * Setter na buddy studenta.
     * 
     * @param Buddy buddy.
     */
	public void setBuddyId(int buddy_id) {
		this.buddy_id = buddy_id;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "VztahStudentu [id=" + id + ", exchange_id=" + exchange_id + ", buddy_id=" + buddy_id + "]";
	}
}
