package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * @author Libor Zíka
 * 
 * 
 * Třída popisující základní atributy akce.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Akce {

	private int akce_id;
	private String typ;
	private String nazev;
	private String casOd;
	private String casDo;
	private String misto;
	private String popis;
	private int cena; //bude to jenom v Kč, ať si to neděláme těžší
	private int maxUcast;
	
	/**
     * Konstruktor třídy Akce.
     * 
     * @param int id, String druh, String nazev, Date datumACasOd, Date datumACasDo, String misto, String popis,
			int cena, int maxUcast.
     */
	public Akce(int akce_id, String typ, String nazev, String casOd, String casDo, String misto, String popis,
			int cena, int maxUcast) {
		this.akce_id = akce_id;
		this.typ = typ;
		this.nazev = nazev;
		this.casOd = casOd;
		this.casDo = casDo;
		this.misto = misto;
		this.popis = popis;
		this.cena = cena;
		this.maxUcast = maxUcast;
	}
	
	/**
     * Getter na Id akce.
     * 
     * @return int id akce.
     */
	@Id
	public int getAkceId() {
		return akce_id;
	}
	
	/**
     * Getter na typ akce.
     * 
     * @return String typ.
     */
	public String getTypAkce() {
		return typ;
	}

	/**
     * Setter na typ akce.
     * 
     * @param String typ.
     */
	public void setTypAkce(String druh) {
		this.typ = typ;
	}
	
	/**
     * Getter na misto akce.
     * 
     * @return String misto.
     */
	public String getMisto() {
		return misto;
	}

	/**
     * Setter na misto akce.
     * 
     * @param String misto.
     */
	public void setMisto(String misto) {
		this.misto = misto;
	}
	
	/**
     * Getter na popis akce.
     * 
     * @return String popis.
     */
	public String getPopis() {
		return popis;
	}

	/**
     * Setter na popis akce.
     * 
     * @param String popis.
     */
	public void setPopis(String popis) {
		this.popis = popis;
	}

	/**
     * Getter na nazev akce.
     * 
     * @return String nazev.
     */
	public String getNazev() {
		return nazev;
	}

	/**
     * Setter na nazev akce.
     * 
     * @param String nazev.
     */
	public void setNazev(String nazev) {
		this.nazev = nazev;
	}
	
	/**
     * Getter na čas, kdy akce začíná.
     * 
     * @return Date datumACasOd.
     */
	public String getCasOd() {
		return casOd;
	}

	/**
     * Setter na čas, kdy akce začíná.
     * 
     * @param Date casOd.
     */
	public void setCasOd(String casOd) {
		this.casOd = casOd;
	}
	
	/**
     * Getter na čas, kdy akce končí.
     * 
     * @return Date casDo.
     */
	public String getCasDo() {
		return casDo;
	}

	/**
     * Setter na čas, kdy akce končí.
     * 
     * @param Date casDo.
     */
	public void setCasDo(String casDo) {
		this.casDo = casDo;
	}
	
	/**
     * Getter na cenu akce.
     * 
     * @return int cena.
     */
	public int getCena() {
		return cena;
	}

	/**
     * Setter na cenu akce.
     * 
     * @param int cena.
     */
	public void setCena(int cena) {
		this.cena = cena;
	}

	/**
     * Getter na maximální počet účastníků akce.
     * 
     * @return int maxUcast.
     */
	public int getMaxUcast() {
		return maxUcast;
	}

	/**
     * Setter na maximální počet účastníků akce.
     * 
     * @param int maxUcast.
     */
	public void setMaxUcast(int maxUcast) {
		this.maxUcast = maxUcast;
	}
	
	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Akce [id=" + akce_id + ", druh=" + typ + ", nazev=" + nazev + ", datumACasOd=" + casOd
				+ ", datumACasDo=" + casDo + ", misto=" + misto + ", popis=" + popis + ", cena=" + cena
				+ ", maxUcast=" + maxUcast + "]";
	}
	
}
