package com.github.it115_Brambory.Semestralni_prace_APZS.logika;


/**
 * Třída popisující uživatele.
 * Ve potomek třídy - student.
 * 
 */
public class Uzivatel{
	
	private String email;
	private String heslo;
	private boolean access;
	//0 pro studenta a 1 pro admina
	
	/**
     * Konstruktor pro uživatele.
     * 
     * @param String email, String heslo, boolean access.
     */
	public Uzivatel(String email, String heslo, boolean access) {
		super();
		this.email = email;
		this.heslo = heslo;
		this.access = access;
	}

	/**
     * Getter na e-mail.
     * 
     * @return String email.
     */
	public String getEmail() {
		return email;
	}
	
	/**
     * Setter na e-mail.
     * 
     * @param String email.
     */
	public void setEmail(String email) {
		this.email = email;
	}
	
	/**
     * Getter na heslo.
     * 
     * @return String heslo.
     */
	public String getHeslo() {
		return heslo;
	}
	
	/**
     * Setter na heslo.
     * 
     * @param String heslo.
     */
	public void setHeslo(String heslo) {
		this.heslo = heslo;
	}
	
	/**
     * Getter k právům pro přístup.
     * 1 - admin access, 0 - student access.
     * 
     * @return boolean access.
     */
	public boolean getAccess() {
		return access;
	}
	
	/**
     * Setter k nastavení práv pro přístup.
     * 
     * @param boolean access.
     */
	public void setAccess(boolean access) {
		this.access = access;
	}

	/**
     * Metoda toString k výpisu obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Uzivatel [email=" + email + ", heslo=" + heslo + ", access=" + access + "]";
	}
	
}
