package com.github.it115_Brambory.Semestralni_prace_APZS.logika;


/**
 * @author Libor Zíka
 * 
 * Třída popisující obecného uživatele.
 * Potomci - admin, student.
 * 
 */
public class Uzivatel{
	
	private String email;
	private String heslo;
	private int access;
	//0 pro buddy, 1 pro exchange a 2 pro admina
	
	/**
     * Konstruktor pro uživatele.
     * 
     * @param String email, String heslo, boolean access.
     */
	public Uzivatel(String email, String heslo, int access) {
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
	public int getAccess() {
		return access;
	}
	
	/**
     * Setter k nastavení práv pro přístup.
     * 
     * @param boolean access.
     */
	public void setAccess(int access) {
		this.access = access;
	}

	/**
     * Metoda toString slouží pro výpis obsahu proměnných.
     * 
     * @return String výpis atributů.
     */
	@Override
	public String toString() {
		return "Uzivatel [email=" + email + ", heslo=" + heslo + ", access=" + access + "]";
	}
	
}
