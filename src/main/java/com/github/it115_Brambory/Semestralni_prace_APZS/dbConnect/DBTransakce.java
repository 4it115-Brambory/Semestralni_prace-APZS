package com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;


import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;

/**
 * @author Libor Zíka
 *
 *         Třída, která využívá komunikace s databází. Metody této třídy slouží
 *         k manipulaci s daty v databázi a zde v programu. Jsou zde
 *         předpřipravené metody pro dotazy SELECT, INSERT, UPDATE a DELETE pro
 *         jednotlivé tabulky. V komentáři u metody je jako příklad popsána
 *         situace, kde danou metodu použijeme. Výsledky dotazů SELECT jsou
 *         ukládány do map.
 * 
 *         Pozn. pro členy týmu: k výpisu všech záznamů, např. akcí nebo buddy,
 *         slouží mapa, kde jsou uložené záznamy z dotazu. Metoda, která by
 *         takto realizovala dotaz na jeden záznam (SELECT ... WHERE xxx = y)
 *         zde není. K tomu použijte výběr z mapy pomocí klíče <Int> - id
 *         záznamu - v databázi primární klíč.
 */

public class DBTransakce {

	private Map<Integer, Buddy> seznamBuddy;
	private Map<Integer, Exchange> seznamExchange;
	private Map<Integer, Admin> seznamAdminu;
	private Map<Integer, Akce> seznamAkci;
	private Map<Integer, Request> seznamRequestu;
	private Map<Integer, VztahStudentu> seznamVztahuStudentu;
	ConnectionClass connectionClass = new ConnectionClass();

	// ----------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metody pro získávání seznamů, ve fxml se používa pro výpis přehledu
	// akcí/buddy/... //
	// //
	// ----------------------------------------------------------------------------------------------------------//

	public Map<Integer, Buddy> getSeznamBuddy() throws SQLException {

		// takhle se selectuje z db
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

	public Map<Integer, Exchange> getSeznamExchange() throws SQLException {

		return seznamExchange;
	}

	public Map<Integer, Akce> getSeznamAkci() throws SQLException {
		return seznamAkci;
	}

	public Map<Integer, Request> getSeznamRequestu() throws SQLException {
		return seznamRequestu;
	}

	public Map<Integer, VztahStudentu> getSeznamVztahuStudentu() throws SQLException {
		return seznamVztahuStudentu;
	}

	public Map<Integer, Admin> getSeznamAdminu() throws SQLException {
		return seznamAdminu;
	}

	public Map<Integer, Exchange> getSeznamExchangePrihlasenychNaAkci(int akceID) throws SQLException {
		// select * from Exchange left join Request where Request.schvaleno = 1
		return seznamExchange;
	}

	// zde vzít inspiraci pro vkládání datumu z sql do javy
	public void printTime() throws SQLException {
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		try {
			String sql = "SELECT CURRENT_DATE, CURRENT_TIME, CURRENT_TIMESTAMP";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				Date datum = resultSet.getDate(1);
				Time cas = resultSet.getTime(2);
				Timestamp timeStamp = resultSet.getTimestamp(3);
				System.out.println(datum);
				System.out.println(cas);
				System.out.println(timeStamp);

				Date dbSqlTimeConverted = new java.util.Date(cas.getTime());
				Date dbSqlDateConverted = new java.util.Date(datum.getTime());
				System.out.println("in standard date");
				System.out.println(dbSqlTimeConverted);
				System.out.println(dbSqlDateConverted);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}

	// --------------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metody pro úpravu jednotlivých záznamů, ve fxml se používa pro
	// editaci jednotlivých akcí/buddy/... //
	// pozn.: po úpravách je nutno opět aktualizovat obsah seznamu v BuddyAplikace
	// metodami pro získání seznamu //
	// --------------------------------------------------------------------------------------------------------------//

	// takhle se updatuje
	/*
	 * 
	 * 
	 * $stmt = $db->
	 * prepare("UPDATE Akce SET misto=?, typ_akce=?, zacatek_akce=?, konec_akce=? WHERE akce_id=?"
	 * ); $stmt->execute(array(htmlspecialchars($_POST['misto']),
	 * htmlspecialchars($_POST['typ_akce']),
	 * htmlspecialchars($_POST['zacatek_akce']),
	 * htmlspecialchars($_POST['konec_akce']), htmlspecialchars($_GET['akce_id'])));
	 * 
	 * 
	 */

	public boolean updateBuddyStudenta(int buddyID) throws SQLException {
		return false;
	}

	public boolean updateExchangeStudenta(int exchangeStudentID) throws SQLException {
		return false;
	}

	public boolean updateAkci(int akceID) throws SQLException {
		return false;
	}

	public boolean updateRequest(int requestID) throws SQLException {
		return false;
	}

	public boolean updateVztahuStudentu(int vztahStudentuID) throws SQLException {
		return false;
	}

	// --------------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metody pro vkládání jednotlivých záznamů, ve fxml se používa pro
	// přidávání akcí/buddy/... //
	// pozn.: to samé jako nahoře, nutno provést aktualizace seznamu //
	// --------------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda pro vložení nové akce do databáze. Není potřeba zadávat Id akce, to se
	 * vytvoří samo. Data začátku a konce musí být jako string v požadovaném formátu
	 * ->dd.MM. HH:mm yyyy<-
	 * 
	 * @param typ
	 * @param nazev
	 * @param casOd
	 * @param casDo
	 * @param misto
	 * @param popis
	 * @param cena
	 * @param maxUcast
	 * 
	 * @throws SQLException
	 */
	public void insertNovaAkce(String typ, String nazev, String casOd, String casDo, String misto, String popis,
			int cena, int maxUcast) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int akce_id = 1;

		try {
			// System.out.println("zkousime");
			// výpočet proměnné, která se dosadí do podmínky
			String sql = "SELECT akce_id FROM Akce ORDER BY akce_id DESC LIMIT 1";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				while (resultSet.next()) {
					// System.out.println("mame result set");
					akce_id = resultSet.getInt("akce_id");
					akce_id += 1;
				}
			}
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. HH:mm yyyy");
			Date casOdUpdated = pozadovanyFormat.parse(casOd);
			Date casDoUpdated = pozadovanyFormat.parse(casDo);

			// sql DATETIME ma tento format -> YYYY-MM-DD HH:MI:SS
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			sql = "INSERT INTO `Akce` (`akce_id`, `typ`, `nazev`, `casOd`, `casDo`, `misto`, `popis`, `cena`, `maxUcast`) VALUES ('"
					+ akce_id + "', '" + typ + "', '" + nazev + "', '" + dateFormat.format(casOdUpdated) + "', '"
					+ dateFormat.format(casDoUpdated) + "', '" + misto + "', '" + popis + "', '" + cena + "', '"
					+ maxUcast + "')";
			statement.executeUpdate(sql);
			System.out.println("nahrano");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenahrano");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro vložení nového exchange studenta do databáze. Není potřeba zadávat
	 * Id, to se vytvoří samo. Datum narození musí být jako string v požadovaném
	 * formátu ->dd.MM. yyyy<- Pohlaví je v databázi jako enum -> "muž", "žena"
	 * 
	 * @param email
	 * @param heslo
	 * @param access
	 * @param jmeno
	 * @param prijmeni
	 * @param datumNarozeni
	 * @param telefon
	 * @param pohlavi
	 * @param statniPrislusnost
	 * @param adresaCR
	 * @throws SQLException
	 */
	public void insertNovyExchangeStudent(String email, String heslo, int access, String jmeno, String prijmeni,
			String datumNarozeni, String telefon, String pohlavi, String statniPrislusnost, String adresaCR)
			throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int exchange_id = 1;

		try {
			// System.out.println("zkousime");
			// výpočet proměnné, která se dosadí do podmínky
			String sql = "SELECT exchange_id FROM Exchange ORDER BY exchange_id DESC LIMIT 1";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				while (resultSet.next()) {
					// System.out.println("mame result set");
					exchange_id = resultSet.getInt("exchange_id");
					exchange_id += 1;
				}
			}
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			sql = "INSERT INTO `Exchange` (`exchange_id`, `adresaCR`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES ('"
					+ exchange_id + "', '" + adresaCR + "', '" + jmeno + "', '" + prijmeni + "', '"
					+ dateFormat.format(datumNarozeniUpdated) + "', '" + telefon + "', '" + pohlavi + "', '"
					+ statniPrislusnost + "', '" + email + "', '" + heslo + "', '" + access + "')";
			statement.executeUpdate(sql);
			System.out.println("nahrano");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenahrano");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro vložení nového buddy studenta do databáze. Není potřeba zadávat
	 * Id, to se vytvoří samo. Datum narození musí být jako string v požadovaném
	 * formátu ->dd.MM. yyyy<- Pohlaví je v databázi jako enum -> "muž", "žena"
	 * 
	 * @param email
	 * @param heslo
	 * @param access
	 * @param jmeno
	 * @param prijmeni
	 * @param datumNarozeni
	 * @param telefon
	 * @param pohlavi
	 * @param statniPrislusnost
	 * @param adresaCR
	 * @throws SQLException
	 */
	public void insertNovyBuddyStudent(String email, String heslo, int access, String jmeno, String prijmeni,
			String datumNarozeni, String telefon, String pohlavi, String statniPrislusnost, String xname, String titul,
			String adresa) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int buddy_id = 1;

		try {
			// System.out.println("zkousime");
			// výpočet proměnné, která se dosadí do podmínky
			String sql = "SELECT buddy_id FROM Buddy ORDER BY buddy_id DESC LIMIT 1";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				while (resultSet.next()) {
					// System.out.println("mame result set");
					buddy_id = resultSet.getInt("buddy_id");
					buddy_id += 1;
				}
			}
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			sql = "INSERT INTO `Buddy` (`buddy_id`, `adresa`, `titul`, `xname`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES ('"
					+ buddy_id + "', '" + adresa + "', '" + titul + "', '" + xname + "', '" + jmeno + "', '" + prijmeni
					+ "', '" + dateFormat.format(datumNarozeniUpdated) + "', '" + telefon + "', '" + pohlavi + "', '"
					+ statniPrislusnost + "', '" + email + "', '" + heslo + "', '" + access + "')";
			statement.executeUpdate(sql);
			System.out.println("nahrano");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenahrano");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro vložení nového requestu do databáze - žádost o přihlášení na akci.
	 * Není potřeba zadávat Id, to se vytvoří samo. Hodnoty atributů "schvaleno" a
	 * "zaplaceno" jsou v základu jako false/nula.
	 * 
	 * @param akce_id
	 * @param exchange_id
	 * @throws SQLException
	 */
	public void insertNovyRequest(int akce_id, int exchange_id) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int request_id = 1;

		try {
			// System.out.println("zkousime");
			// výpočet proměnné, která se dosadí do podmínky
			String sql = "SELECT request_id FROM Request ORDER BY request_id DESC LIMIT 1";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				while (resultSet.next()) {
					// System.out.println("mame result set");
					request_id = resultSet.getInt("request_id");
					request_id += 1;
				}
			}
			sql = "INSERT INTO `Request` (`request_id`, `exchange_id`, `akce_id`, `zaplaceno`, `schvaleno`) VALUES ('"
					+ request_id + "', '" + exchange_id + "', '" + akce_id + "', '0', '0')";
			statement.executeUpdate(sql);
			System.out.println("nahrano");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenahrano");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void insertNovyVztahStudentu(int exchange_id, int buddy_id) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		int vztah_id = 1;

		try {
			// System.out.println("zkousime");
			// výpočet proměnné, která se dosadí do podmínky
			String sql = "SELECT vztah_id FROM VztahBuddyExchange ORDER BY vztah_id DESC LIMIT 1";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			if (resultSet.next()) {
				while (resultSet.next()) {
					// System.out.println("mame result set");
					vztah_id = resultSet.getInt("vztah_id");
					vztah_id += 1;
				}
			}
			sql = "INSERT INTO `VztahBuddyExchange` (`exchange_id`, `buddy_id`, `vztah_id`) VALUES ('" + exchange_id
					+ "', '" + buddy_id + "', '" + vztah_id + "')";
			statement.executeUpdate(sql);
			System.out.println("nahrano");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenahrano");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metody pro vymazání jednotlivých záznamů, ve fxml se používa pro
	// odebrání akce/buddy/... //
	// pozn.: to samé jako nahoře, nutno provést aktualizace seznamu //
	// --------------------------------------------------------------------------------------------------------------//

	// ------------------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metoda pro přihlášení do aplikace, log in. V případě úspěšného
	// přihlášení se nastaví aktuální uživatel. //
	// //
	// ------------------------------------------------------------------------------------------------------------------//

	// jestli se shoduje zahashovany retezec z inputu s hashem v db?
	// Jako tabulka pro dotazování se joinou všechny 3 tabulky s uživateli
	public boolean logIn(String email, String heslo) {

		return false;
	}

	public boolean logIn() throws SQLException {

		return false;
	}

	// ------------------------------------------------------------------------------------------------------------------//
	// //
	// --------- Metody k nastavení stavu žádosti -> schváleno/zamítnuto a
	// zaplaceno/nezaplaceno. Kontrola plnosti akce //
	// //
	// ------------------------------------------------------------------------------------------------------------------//

	// stačí jen metoda na set zaplaceno, protože default hodnota je false, protože
	// hned po přihlášení student zaplaceno nemá.
	public boolean setRequestZaplaceno(int requestID) throws SQLException {
		// todo
		return false;
	}

	// defaultní hodnota je null, proto je potřeba nastavit hodnotu atributu
	// "schváleno" na true nebo false
	public boolean setRequestSchvaleno(int requestID) throws SQLException {
		// todo
		return false;
	}

	public boolean setRequestZamitnuto(int requestID) throws SQLException {
		// todo
		return false;
	}

	public boolean zjistiObsazenostAkce(int requestID) throws SQLException {
		// todo
		// počet schválených přihlášených na akci / celkový počet. Nemůže být
		// větší jak jedna. To už se nedá ani přihlásit a ani schválit žádost
		return false;
	}
}
