package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import java.util.Date;
import java.util.Map;

import javax.persistence.Entity;
import javax.persistence.Id;


/**
 * Třída popisující základní atributy akce.
 * 
 * Je nutné použít API pro persistenci a identifikovat třídu jako entitu, která je možným předmětem persistence.
 * Dále je nutné, aby objekt měl jasný identifikátor, ten je označen anotací.
 *
 */
@Entity
public class Akce {

	private int id;
	private String druh;
	private String nazev;
	private Date datumACasOd;
	private Date datumACasDo;
	private String misto;
	private String popis;
	private int cena; //bude to jenom v Kč, ať si to neděláme těžší
	private int maxUcast;
	private Map<Integer, Exchange> seznamExchangeNaAkci;
	
	/**
     * Konstruktor třídy Akce.
     * 
     * @param int id, String druh, String nazev, Date datumACasOd, Date datumACasDo, String misto, String popis,
			int cena, int maxUcast.
     */
	public Akce(int id, String druh, String nazev, Date datumACasOd, Date datumACasDo, String misto, String popis,
			int cena, int maxUcast) {
		this.id = id;
		this.druh = druh;
		this.nazev = nazev;
		this.datumACasOd = datumACasOd;
		this.datumACasDo = datumACasDo;
		this.misto = misto;
		this.popis = popis;
		this.cena = cena;
		this.maxUcast = maxUcast;
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
     * Getter na druh akce.
     * 
     * @return String druh.
     */
	public String getDruh() {
		return druh;
	}

	/**
     * Setter na druh akce.
     * 
     * @param String druh.
     */
	public void setDruh(String druh) {
		this.druh = druh;
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
	public Date getDatumACasOd() {
		return datumACasOd;
	}

	/**
     * Setter na čas, kdy akce začíná.
     * 
     * @param Date datumACasOd.
     */
	public void setDatumACasOd(Date datumACasOd) {
		this.datumACasOd = datumACasOd;
	}
	
	/**
     * Getter na čas, kdy akce končí.
     * 
     * @return Date datumACasDo.
     */
	public Date getDatumACasDo() {
		return datumACasDo;
	}

	/**
     * Setter na čas, kdy akce končí.
     * 
     * @param Date datumACasDo.
     */
	public void setDatumACasDo(Date datumACasDo) {
		this.datumACasDo = datumACasDo;
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
     * Metoda sloužící k přidání studenta na akci po tom, co zaplatil.
     * 
     * @param Exchange student
     * @return boolean
     */
	public boolean pridejStudentaNaAkci(Exchange student) {
		if (seznamExchangeNaAkci.containsKey(id)) {
			return false;
		}else {
			seznamExchangeNaAkci.put(student.getId() , student);
			return true;
		}
	}
	
	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Akce [id=" + id + ", druh=" + druh + ", nazev=" + nazev + ", datumACasOd=" + datumACasOd
				+ ", datumACasDo=" + datumACasDo + ", misto=" + misto + ", popis=" + popis + ", cena=" + cena
				+ ", maxUcast=" + maxUcast + "]";
	}
	
}
