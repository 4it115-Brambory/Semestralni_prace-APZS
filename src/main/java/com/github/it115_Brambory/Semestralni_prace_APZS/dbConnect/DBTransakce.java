package com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect;

import java.sql.*;
import java.util.Map;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

/**
 * @author Libor Zíka
 *
 * Třída, která využívá komunikace s databází. Metody této třídy slouží k manipulaci s daty v databázi a zde v programu.
 * Jsou zde předpřipravené metody pro dotazy SELECT, INSERT, UPDATE a DELETE pro jednotlivé tabulky. V komentáři u metody
 * je jako příklad popsána situace, kde danou metodu použijeme. Výsledky dotazů SELECT jsou ukládány do map.
 * 
 * Pozn. pro členy týmu: k výpisu všech záznamů, např. akcí nebo buddy, slouží mapa, kde jsou uložené záznamy z dotazu.
 * Metoda, která by takto realizovala dotaz na jeden záznam (SELECT ... WHERE xxx = y) zde není. K tomu použijte výběr z mapy
 * pomocí klíče <Int> - id záznamu - v databázi primární klíč.
 */

public class DBTransakce {
	
	private Map<Integer, Buddy> seznamBuddy;
	private Map<Integer, Exchange> seznamExchange;
	private Map<Integer, Admin> seznamAdminu;
	private Map<Integer, Akce> seznamAkci;
	private Map<Integer, Request> seznamRequestu;
	private Map<Integer, VztahStudentu> seznamVztahuStudentu;
	ConnectionClass connectionClass = new ConnectionClass();
	
//----------------------------------------------------------------------------------------------------------//
//																											//
//--------- Metody pro získávání seznamů, ve fxml se používa pro výpis přehledu akcí/buddy/...				//
//																											//
//----------------------------------------------------------------------------------------------------------//
	
	public Map<Integer, Buddy> getSeznamBuddy() throws SQLException{
		
		//takhle se selectuje z db
		String sql = "SELECT * FROM Buddy";
		Connection connection = connectionClass.getConnection();
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		while (resultSet.next()) {
			System.out.println(resultSet.getString(1));
		}
		connection.close();
		return seznamBuddy;
	}
	
	public Map<Integer, Exchange> getSeznamExchange() throws SQLException{
		
		return seznamExchange;		
	}
	
	public Map<Integer, Akce> getSeznamAkci() throws SQLException{
		return seznamAkci;
	}
	
	public Map<Integer, Request> getSeznamRequestu() throws SQLException{
		return seznamRequestu;
	}
	
	public Map<Integer, VztahStudentu> getSeznamVztahuStudentu() throws SQLException{
		return seznamVztahuStudentu;
	}
	
	public Map<Integer, Admin> getSeznamAdminu() throws SQLException{
		return seznamAdminu;
	}
	
	public Map<Integer, Exchange> getSeznamExchangePrihlasenychNaAkci(int akceID) throws SQLException{
		//select * from Exchange left join Request where Request.schvaleno = 1
		return seznamExchange;
	}
	
//--------------------------------------------------------------------------------------------------------------//
//																												//
//--------- Metody pro úpravu jednotlivých záznamů, ve fxml se používa pro editaci jednotlivých akcí/buddy/...	//
//	pozn.: po úpravách je nutno opět aktualizovat obsah seznamu v BuddyAplikace metodami pro získání seznamu	//
//--------------------------------------------------------------------------------------------------------------//	
	
	
	//takhle se updatuje
		/*
		 
		 
		 $stmt = $db->prepare("UPDATE Akce SET misto=?, typ_akce=?, zacatek_akce=?, konec_akce=? WHERE akce_id=?");
	    $stmt->execute(array(htmlspecialchars($_POST['misto']), htmlspecialchars($_POST['typ_akce']),
	                        htmlspecialchars($_POST['zacatek_akce']), htmlspecialchars($_POST['konec_akce']), htmlspecialchars($_GET['akce_id'])));


		 */
	
	
	
	public boolean updateBuddyStudenta(int buddyID) throws SQLException{
		return false;
	}
	
	public boolean updateExchangeStudenta(int exchangeStudentID) throws SQLException{		
		return false;		
	}
	
	public boolean updateAkci(int akceID) throws SQLException{
		return false;
	}
	
	public boolean updateRequest(int requestID) throws SQLException{
		return false;
	}
	
	public boolean updateVztahuStudentu(int vztahStudentuID) throws SQLException{
		return false;
	}
	
//--------------------------------------------------------------------------------------------------------------//
//																												//
//--------- Metody pro vkládání jednotlivých záznamů, ve fxml se používa pro přidávání akcí/buddy/...			//
//						pozn.: to samé jako nahoře, nutno provést aktualizace seznamu							//
//--------------------------------------------------------------------------------------------------------------//


	//takhle se insertuje
		/*
		String sql = "INSERT INTO jmenoTabulky ('atribut1', 'atribut2', 'atribut3')"
				+ "VALUES (hodnota11, hodnota12, hodnota13), (hodnota21, hodnota22, hodnota23), (hodnota31, hodnota32, hodnota33);";
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);    			
		*/


	
	
	
//--------------------------------------------------------------------------------------------------------------//
//																												//
//--------- Metody pro vymazání jednotlivých záznamů, ve fxml se používa pro odebrání akce/buddy/...			//
//						pozn.: to samé jako nahoře, nutno provést aktualizace seznamu							//
//--------------------------------------------------------------------------------------------------------------//





//------------------------------------------------------------------------------------------------------------------//
//																													//
//--------- Metoda pro přihlášení do aplikace, log in. V případě úspěšného přihlášení se nastaví aktuální uživatel.	//
//																													//
//------------------------------------------------------------------------------------------------------------------//	
	
	//jestli se shoduje zahashovany retezec z inputu s hashem v db?
	//Jako tabulka pro dotazování se joinou všechny 3 tabulky s uživateli
	public boolean logIn (String email, String heslo) {
		
		
		return false;
	}
	
	public void logInTest () throws SQLException {
		
		
		
		String sql = "INSERT INTO `Admin` (`admin_id`, `jmeno`, `prijmeni`, `email`, `heslo`, `access`) VALUES ('1', 'Dorota', 'Máchalová', 'dorymachy@gmail.com', 'heslo123', '2')";
		Connection connection = connectionClass.getConnection();
		Statement statement = connection.createStatement();
		statement.executeUpdate(sql);
		
		connection.close();
		
		
	}
	
	
	

//------------------------------------------------------------------------------------------------------------------//
//																													//
//--------- Metody k nastavení stavu žádosti -> schváleno/zamítnuto a zaplaceno/nezaplaceno							//
//																													//
//------------------------------------------------------------------------------------------------------------------//		
	
	//stačí jen metoda na set zaplaceno, protože default hodnota je false, protože hned po přihlášení student zaplaceno nemá.
	public boolean setRequestZaplaceno(int requestID) throws SQLException{
		//todo
		return false;
	}
	
	//defaultní hodnota je null, proto je potřeba nastavit hodnotu atributu "schváleno" na true nebo false
	public boolean setRequestSchvaleno(int requestID) throws SQLException{
		//todo
		return false;
	}
	
	public boolean setRequestZamitnuto(int requestID) throws SQLException{
		//todo
		return false;
	}
	
	
}
