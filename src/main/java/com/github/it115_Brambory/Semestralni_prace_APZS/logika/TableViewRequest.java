package com.github.it115_Brambory.Semestralni_prace_APZS.logika;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class TableViewRequest {

	private SimpleStringProperty jmeno; // exchange
	private SimpleStringProperty prijmeni; // exchange
	private SimpleStringProperty telefon; // exchange
	private SimpleStringProperty stat; // exchange
	private SimpleStringProperty datumNarozeni; // exchange
	private SimpleStringProperty nazevAkce; // akce
	private SimpleIntegerProperty prihlasenych; // hmm
	private SimpleIntegerProperty maxUcast; // maxUcast akce
	private SimpleIntegerProperty id; // request Id
	private SimpleStringProperty zaplaceno; // request
	private SimpleStringProperty schvaleno; // request

	public TableViewRequest(String jmeno, String prijmeni, String telefon, String stat, String datumNarozeni,
			String nazevAkce, Integer prihlasenych, Integer maxUcast, Integer id, String zaplaceno, String schvaleno) {

		this.jmeno = new SimpleStringProperty(jmeno);
		this.prijmeni = new SimpleStringProperty(prijmeni);
		this.telefon = new SimpleStringProperty(telefon);
		this.stat = new SimpleStringProperty(stat);
		this.datumNarozeni = new SimpleStringProperty(datumNarozeni);
		this.nazevAkce = new SimpleStringProperty(nazevAkce);
		this.prihlasenych = new SimpleIntegerProperty(prihlasenych);
		this.maxUcast = new SimpleIntegerProperty(maxUcast);
		this.id = new SimpleIntegerProperty(id);
		this.zaplaceno = new SimpleStringProperty(zaplaceno);
		this.schvaleno = new SimpleStringProperty(schvaleno);

	}

	public Integer getId() {
		return id.get();
	}

	public void setId(Integer id) {
		this.id.set(id);
	}

	public String getJmeno() {
		return jmeno.get();
	}

	public void setJmeno(String jmeno) {
		this.jmeno.set(jmeno);
	}

	public String getPrijmeni() {
		return prijmeni.get();
	}

	public void setPrijmeni(String prijmeni) {
		this.prijmeni.set(prijmeni);
	}

	public String getTelefon() {
		return telefon.get();
	}

	public void setTelefon(String telefon) {
		this.telefon.set(telefon);
	}

	public String getStat() {
		return stat.get();
	}

	public void setStat(String stat) {
		this.stat.set(stat);
	}

	public String getDatumNarozeni() {
		return datumNarozeni.get();
	}

	public void setDatumNarozeni(String datumNarozeni) {
		this.datumNarozeni.set(datumNarozeni);
	}

	public String getNazevAkce() {
		return nazevAkce.get();
	}

	public void setNazevAkce(String nazevAkce) {
		this.nazevAkce.set(nazevAkce);
	}

	public Integer getPrihlasenych() {
		return prihlasenych.get();
	}

	public void setPrihlasenych(Integer prihlasenych) {
		this.prihlasenych.set(prihlasenych);
	}

	public Integer getMaxUcast() {
		return maxUcast.get();
	}

	public void setMaxUcast(Integer maxUcast) {
		this.maxUcast.set(maxUcast);
	}

	public String getZaplaceno() {
		return zaplaceno.get();
	}

	public void setZaplaceno(String zaplaceno) {
		this.zaplaceno.set(zaplaceno);
	}
	
	public String getSchvaleno() {
		return schvaleno.get();
	}

	public void setSchvaleno(String schvaleno) {
		this.schvaleno.set(schvaleno);
	}
}
