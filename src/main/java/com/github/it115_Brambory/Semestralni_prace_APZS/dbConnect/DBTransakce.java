package com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect;

import java.sql.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Observable;

import com.github.it115_Brambory.Semestralni_prace_APZS.logika.*;
import com.github.it115_Brambory.Semestralni_prace_APZS.ui.PrehledakcibuddyController;;


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

public class DBTransakce extends Observable{

	private Map<Integer, Buddy> seznamBuddy;
	private Map<Integer, Exchange> seznamExchange;
	private Map<Integer, Akce> seznamAkci;
	private Map<Integer, Request> seznamRequestu;
	private Buddy prirazenyBuddy;
	ConnectionClass connectionClass = new ConnectionClass();
	Uzivatel prihlasovany;

	// ----------------------------------------------------------------------------------------------------------//
	//
	// Metody pro získávání seznamů, ve fxml se používa pro výpis přehledu
	// akcí/buddy/... Také jsou zde metody na získávání dalších objektů.
	//
	// ----------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda vrací seznam buddy studentů, které jsou v DB.
	 * 
	 * @return Map<Integer, Buddy>
	 * @throws SQLException
	 */
	public Map<Integer, Buddy> getSeznamBuddy() throws SQLException {

		seznamBuddy = new HashMap<Integer, Buddy>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT * FROM Buddy";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				// formátování - datum narození
				DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
				String datum = pozadovanyFormat.format(resultSet.getDate(7)).toString();

				Buddy buddyStudent = new Buddy(resultSet.getString(11), resultSet.getString(12), resultSet.getInt(13),
						resultSet.getString(5), resultSet.getString(6), datum, resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getInt(1), resultSet.getString(4),
						resultSet.getString(3), resultSet.getString(2));
				seznamBuddy.put(resultSet.getInt(1), buddyStudent);
				// System.out.println(buddyStudent.toString());
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
		return seznamBuddy;
	}
	
	public Collection<Buddy>  getSeznamBuddyKolekce () throws SQLException 
    {
		getSeznamBuddy();
    	return Collections.unmodifiableCollection (seznamBuddy.values());
    }
	
	

	/**
	 * Metoda vrací seznam exchange studentů, kteří jsou v DB.
	 * 
	 * @return Map<Interger, Exchange>
	 * @throws SQLException
	 */
	public Map<Integer, Exchange> getSeznamExchange() throws SQLException {

		seznamExchange = new HashMap<Integer, Exchange>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT * FROM Exchange";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				// formátování - datum narození
				DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
				String datum = pozadovanyFormat.format(resultSet.getDate(5)).toString();

				Exchange exchangeStudent = new Exchange(resultSet.getString(9), resultSet.getString(10),
						resultSet.getInt(11), resultSet.getString(3), resultSet.getString(4), datum,
						resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(1),
						resultSet.getString(2));
				seznamExchange.put(resultSet.getInt(1), exchangeStudent);
				// System.out.println(exchangeStudent.toString());
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
		return seznamExchange;
	}

	/**
	 * Metoda vrací seznam akcí, kreré jsou v DB.
	 * 
	 * @return Map<Integer, Akce>
	 * @throws SQLException
	 */
	public Map<Integer, Akce> getSeznamAkci() throws SQLException {

		seznamAkci = new HashMap<Integer, Akce>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT * FROM Akce";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				// formátování - datum narození
				DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. HH:mm yyyy");
				String casOd = pozadovanyFormat.format(resultSet.getDate(4)).toString();
				String casDo = pozadovanyFormat.format(resultSet.getDate(5)).toString();

				Akce akce = new Akce(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), casOd, casDo,
						resultSet.getString(6), resultSet.getString(7), resultSet.getInt(8), resultSet.getInt(9));
				seznamAkci.put(resultSet.getInt(1), akce);
				// System.out.println(akce.toString());
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
		return seznamAkci;
	}

	/**
	 * Metoda pro získání seznamu všech requestů. Použití v admin controlleru pro
	 * zobrazení přehledu žádostí.
	 * 
	 * @return Map<Integer, Request>
	 * @throws SQLException
	 */
	public Map<Integer, Request> getSeznamRequestu() throws SQLException {

		seznamRequestu = new HashMap<Integer, Request>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT * FROM Request";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				Request request = new Request(resultSet.getInt(1), resultSet.getInt(2), resultSet.getInt(3));
				if (resultSet.getInt(4) == 1) {
					request.setZaplaceno();
				}
				if (resultSet.getInt(5) == 1) {
					request.setSchvaleno();
				}
				seznamRequestu.put(resultSet.getInt(1), request);
				System.out.println(request.toString());
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
		return seznamRequestu;
	}

	/**
	 * Metoda vrací buddy studenta, který je přiřazen danému exchange studentovi.
	 * Seznam vztahů by neměl být potřeba v programu. Bude stačit toto k výpisu
	 * jména buddy studenta v controlleru pro detail exchange studenta.
	 * 
	 * @param exchange_id
	 * @return Buddy
	 * @throws SQLException
	 */
	public Buddy getPrirazenehoBuddyStudenta(int exchange_id) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT Buddy.* FROM Buddy LEFT JOIN VztahBuddyExchange ON Buddy.buddy_id=VztahBuddyExchange.buddy_id WHERE VztahBuddyExchange.exchange_id = '"
					+ exchange_id + "'";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);

			while (resultSet.next()) {

				// změna string parametru času do java date, aby se mohl preformatovat pro sql
				DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
				String datum = pozadovanyFormat.format(resultSet.getDate(7)).toString();

				prirazenyBuddy = new Buddy(resultSet.getString(11), resultSet.getString(12), resultSet.getInt(13),
						resultSet.getString(5), resultSet.getString(6), datum, resultSet.getString(8),
						resultSet.getString(9), resultSet.getString(10), resultSet.getInt(1), resultSet.getString(4),
						resultSet.getString(3), resultSet.getString(2));
				// System.out.println(prirazenyBuddy.toString());
			}

			System.out.println("nalezeno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nenalezeno");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return prirazenyBuddy;
	}

	/**
	 * Metoda slouží pro získání seznamu exchange studentů, kteří mají podanou
	 * žádost na danou akci. Metoda se využíva pro výpis v detailu akce.
	 * 
	 * @param akce_id
	 * @return Map<Integer, Exchange>
	 * @throws SQLException
	 */
	public Map<Integer, Exchange> getSeznamExchangeSZadostiNaAkci(int akce_id) throws SQLException {
		// select * from Exchange left join Request where Request.schvaleno = 1
		seznamExchange = new HashMap<Integer, Exchange>();
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		try {
			String sql = "SELECT Exchange.* FROM Exchange LEFT JOIN Request ON Exchange.exchange_id=Request.exchange_id WHERE Request.akce_id = '"
					+ akce_id + "'";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {

				// formátování - datum narození
				DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
				String datum = pozadovanyFormat.format(resultSet.getDate(5)).toString();

				Exchange exchangeStudent = new Exchange(resultSet.getString(9), resultSet.getString(10),
						resultSet.getInt(11), resultSet.getString(3), resultSet.getString(4), datum,
						resultSet.getString(6), resultSet.getString(7), resultSet.getString(8), resultSet.getInt(1),
						resultSet.getString(2));
				seznamExchange.put(resultSet.getInt(1), exchangeStudent);
				// System.out.println(exchangeStudent.toString());
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
		return seznamExchange;
	}

	/**
	 * Metoda slouží jako inspirace pro práci s formátováním časů atd.
	 * 
	 * @throws SQLException
	 */
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
	//
	// Metody pro úpravu jednotlivých záznamů, ve fxml se používa pro
	// editaci jednotlivých akcí/buddy/...
	// pozn.: po úpravách je nutno opět aktualizovat obsah seznamu v BuddyAplikace
	// metodami pro získání seznamu
	//
	// --------------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda pro úpravu buddy studenta, volá se v detailu buddy studenta při
	 * stisknutí tlačítka pro uložení. ID, access, email a heslo upravit nelze.
	 * 
	 * @param buddy_id
	 * @param jmeno
	 * @param prijmeni
	 * @param datumNarozeni
	 * @param telefon
	 * @param pohlavi
	 * @param statniPrislusnost
	 * @param xname
	 * @param titul
	 * @param adresa
	 * @throws SQLException
	 */
	public void updateBuddyStudenta(int buddy_id, String jmeno, String prijmeni, String datumNarozeni, String telefon,
			String pohlavi, String statniPrislusnost, String xname, String titul, String adresa, String email) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			// System.out.println("zkousime");
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "UPDATE `Buddy` SET `adresa`='" + adresa + "', `titul`='" + titul + "', `xname`='" + xname
					+ "', `jmeno`='" + jmeno + "', `prijmeni`='" + prijmeni + "', `datumNarozeni`='"
					+ dateFormat.format(datumNarozeniUpdated) + "', `telefon`='" + telefon + "', `pohlavi`='" + pohlavi
					+ "', `statniPrislusnost`='" + statniPrislusnost + "' WHERE `buddy_id`='" + buddy_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro úpravu exchange studenta, volá se v detailu exchange studenta při
	 * stisknutí tlačítka pro uložení. ID, access, email a heslo upravit nelze.
	 * 
	 * @param exchange_id
	 * @param jmeno
	 * @param prijmeni
	 * @param datumNarozeni
	 * @param telefon
	 * @param pohlavi
	 * @param statniPrislusnost
	 * @param adresaCR
	 * @throws SQLException
	 */
	public void updateExchangeStudenta(int exchange_id, String jmeno, String prijmeni, String datumNarozeni,
			String telefon, String pohlavi, String statniPrislusnost, String adresaCR) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			// System.out.println("zkousime");
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			String sql = "UPDATE `Exchange` SET `adresaCR`='" + adresaCR + "', `jmeno`='" + jmeno + "', `prijmeni`='"
					+ prijmeni + "', `datumNarozeni`='" + dateFormat.format(datumNarozeniUpdated) + "', `telefon`='"
					+ telefon + "', `pohlavi`='" + pohlavi + "', `statniPrislusnost`='" + statniPrislusnost
					+ "' WHERE `exchange_id`='" + exchange_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro úpravu akce, volá se v detailu akce při stisknutí tlačítka pro
	 * uložení. ID upravit nelze.
	 * 
	 * @param akce_id
	 * @param typ
	 * @param nazev
	 * @param casOd
	 * @param casDo
	 * @param misto
	 * @param popis
	 * @param cena
	 * @param maxUcast
	 * @throws SQLException
	 */
	public void updateAkci(int akce_id, String typ, String nazev, String casOd, String casDo, String misto,
			String popis, int cena, int maxUcast) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			// System.out.println("zkousime");
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. HH:mm yyyy");
			Date casOdUpdated = pozadovanyFormat.parse(casOd);
			Date casDoUpdated = pozadovanyFormat.parse(casDo);

			// sql DATETIME ma tento format -> YYYY-MM-DD HH:MI:SS
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			String sql = "UPDATE `Akce` SET `typ`='" + typ + "', `nazev`='" + nazev + "', `casOd`='"
					+ dateFormat.format(casOdUpdated) + "', `casDo`='" + dateFormat.format(casDoUpdated)
					+ "', `misto`='" + misto + "', `popis`='" + popis + "', `cena`='" + cena + "', `maxUcast`='"
					+ maxUcast + "' WHERE `akce_id`='" + akce_id + "'";
			statement.executeUpdate(sql);
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// --------------------------------------------------------------------------------------------------------------//
	//
	// Metody pro vkládání jednotlivých záznamů, ve fxml se používa pro
	// přidávání akcí/buddy/... Obsahuje i metodu pro kontrolu již existující
	// žádosti k dané akci a exchange studentovi.
	// pozn.: to samé jako nahoře, nutno provést aktualizace seznamu
	//
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
			while (resultSet.next()) {
				// System.out.println("mame result set");
				akce_id = resultSet.getInt(1);
				akce_id += 1;
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
			while (resultSet.next()) {
				// System.out.println("mame result set");
				exchange_id = resultSet.getInt(1);
				exchange_id += 1;
			}
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			sql = "INSERT INTO `Exchange` (`exchange_id`, `adresaCR`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES ('"
					+ exchange_id + "', '" + adresaCR + "', '" + jmeno + "', '" + prijmeni + "', '"
					+ dateFormat.format(datumNarozeniUpdated) + "', '" + telefon + "', '" + pohlavi + "', '"
					+ statniPrislusnost + "', '" + email + "', '"
					+ org.apache.commons.codec.digest.DigestUtils.shaHex(heslo) + "', '" + access + "')";
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
			while (resultSet.next()) {
				// System.out.println("mame result set");
				buddy_id = resultSet.getInt(1);
				buddy_id += 1;
			}
			// změna string parametru času do java date, aby se mohl preformatovat pro sql
			DateFormat pozadovanyFormat = new SimpleDateFormat("dd.MM. yyyy");
			Date datumNarozeniUpdated = pozadovanyFormat.parse(datumNarozeni);

			// sql DATE ma tento format -> YYYY-MM-DD
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			sql = "INSERT INTO `Buddy` (`buddy_id`, `adresa`, `titul`, `xname`, `jmeno`, `prijmeni`, `datumNarozeni`, `telefon`, `pohlavi`, `statniPrislusnost`, `email`, `heslo`, `access`) VALUES ('"
					+ buddy_id + "', '" + adresa + "', '" + titul + "', '" + xname + "', '" + jmeno + "', '" + prijmeni
					+ "', '" + dateFormat.format(datumNarozeniUpdated) + "', '" + telefon + "', '" + pohlavi + "', '"
					+ statniPrislusnost + "', '" + email + "', '"
					+ org.apache.commons.codec.digest.DigestUtils.shaHex(heslo) + "', '" + access + "')";
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
			while (resultSet.next()) {
				// System.out.println("mame result set");
				request_id = resultSet.getInt(1);
				request_id += 1;
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

	/**
	 * Metoda slouží ke kontrole, zda-li daný exchange student již žádost o
	 * přihlášení nepodal. V případě, že exchange již podanou žádost na akci má,
	 * vrátí metoda "true". Pokud žádost k dané akci ještě nemá, vrátí "false". V
	 * controlleru pak může student podat na akci žádost.
	 * 
	 * @param akce_id
	 * @param exchange_id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean zjistiExistujiciRequestProExchange(int akce_id, int exchange_id) throws SQLException {

		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;
		boolean check = false;

		try {
			String sql = "SELECT * FROM Request WHERE `exchange_id`= '" + exchange_id + "' AND `akce_id` = '" + akce_id
					+ "'";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				check = true;
				System.out.println("request nalezen, exchange student nemůže znovu podat žádost na stejnou akci");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("chyba ve zjišťování existujícího requestu");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (!check) {
			System.out.println("request nenalezen, je možno podat žádost");
		}
		return check;
	}

	/**
	 * Metoda pro vložení nového vztahu studentů. Není potřeba zadávat Id vztahu, to
	 * se vytvoří samo.
	 * 
	 * @param exchange_id
	 * @param buddy_id
	 * @throws SQLException
	 */
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
			while (resultSet.next()) {
				// System.out.println("mame result set");
				vztah_id = resultSet.getInt(1);
				vztah_id += 1;
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

	// metoda kontroluje, zda-li již v DB není vztah jednoho, nebo druhého studenta
	// zaznamenán. Jeden buddy může mít pouze jednoho exchange a naopak.

	/**
	 * Metoda slouží ke kontrole, zda-li již daný buddy student nemá přiřazeného
	 * exchange studenta. Vrací true, pokud vztah již existuje.
	 * 
	 * @param buddy_id
	 * @return boolean
	 */
	public boolean checkExistenciVztahuProBuddy(int buddy_id) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int vztah = 0;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT COUNT(buddy_id) FROM VztahBuddyExchange WHERE buddy_id = '" + buddy_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				vztah = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("někde je chyba");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (vztah == 1) {
			System.out.println("vracím true - buddy student už má přiřazeného exchange studenta");
			return true;
		} else {
			System.out.println("vracím false - buddy student se zatím o níkoho nestará");
			return false;
		}
	}

	/**
	 * Metoda slouží ke kontrole, zda-li již daný exchange student nemá přiřazeného
	 * buddy studenta. Vrací true, pokud vztah již existuje.
	 * 
	 * @param exchange_id
	 * @return boolean
	 */
	public boolean checkExistenciVztahuProExchange(int exchange_id) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		int vztah = 0;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT COUNT(buddy_id) FROM VztahBuddyExchange WHERE exchange_id = '" + exchange_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				vztah = resultSet.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("někde je chyba");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (vztah == 1) {
			System.out.println("vracím true - exchange student už má přiřazeného buddy studenta");
			return true;
		} else {
			System.out.println("vracím false - o exchange studenta se zatím nikdo nestará");
			return false;
		}
	}

	// --------------------------------------------------------------------------------------------------------------//
	//
	// Metody pro vymazání jednotlivých záznamů, ve fxml se používa pro
	// odebrání akce/buddy/...
	// pozn.: to samé jako nahoře, nutno provést aktualizace seznamu
	//
	// --------------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda na vymazání akce z DB pomocí paramentru - Id akce
	 * 
	 * 
	 * @param akce_id
	 * @throws SQLException
	 */
	public void deleteAkce(int akce_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			String sql = "DELETE FROM `Akce` WHERE `akce_id`='" + akce_id + "'";
			statement.executeUpdate(sql);
			System.out.println("vymazáno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nevymazáno");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda na vymazání buddy studenta z DB pomocí paramentru
	 * 
	 * @param buddy_id
	 * @throws SQLException
	 */
	public void deleteBuddyStudent(int buddy_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			String sql = "DELETE FROM `Buddy` WHERE `buddy_id`='" + buddy_id + "'";
			statement.executeUpdate(sql);
			System.out.println("vymazáno");
			setChanged();
		    notifyObservers();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nevymazáno");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda na vymazání exchange studenta z DB pomocí paramentru
	 * 
	 * @param exchange_id
	 * @throws SQLException
	 */
	public void deleteExchangeStudent(int exchange_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			String sql = "DELETE FROM `Exchange` WHERE `exchange_id`='" + exchange_id + "'";
			statement.executeUpdate(sql);
			System.out.println("vymazáno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nevymazáno");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda na vymazání vztahu studentů z DB pomocí paramentru - ID vztahu
	 * 
	 * @param vztah_id
	 * @throws SQLException
	 */
	public void deleteVztahStudentu(int vztah_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			String sql = "DELETE FROM `VztahBuddyExchange` WHERE `vztah_id`='" + vztah_id + "'";
			statement.executeUpdate(sql);
			System.out.println("vymazáno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nevymazáno");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda na vymazání requestu z DB pomocí paramentru - Id
	 * 
	 * @param request_id
	 * @throws SQLException
	 */
	public void deleteRequest(int request_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			String sql = "DELETE FROM `Request` WHERE `request_id`='" + request_id + "'";
			statement.executeUpdate(sql);
			System.out.println("vymazáno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("nevymazáno");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	// ------------------------------------------------------------------------------------------------------------------//
	//
	// Metoda pro přihlášení do aplikace, log in. V případě úspěšného
	// přihlášení se nastaví aktuální uživatel.
	//
	// ------------------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda slouží k přihlášení do aplikace. Zjistí, jestli je daný uživatel s
	 * daným heslem v DB. Pokud ano, nastaví aktuálního uživatele v aplikaci a
	 * metoda vrátí kladonou hodnotu, podle toho, jaká je hodnota atributu "access".
	 * Pokud ne, vrátí nulovou hodnotu "access" a proces přihlášení se nezdaří.
	 * Porovnává se zahashovaný řetězec ze vstupu s hashem v DB
	 * 
	 * @param email
	 * @param heslo
	 * @param aplikace
	 * @return
	 */
	public int logIn(String email, String heslo, IBuddyAplikace aplikace) {

		String shaHashInputHeslo = org.apache.commons.codec.digest.DigestUtils.shaHex(heslo);
		int access = 0;
		Connection connection = null;
		ResultSet resultSet = null;
		Statement statement = null;

		// zkus najít admina
		try {
			// System.out.println("zkousime");
			String sql = "SELECT `email`, `access`, `heslo` FROM `Admin`";
			connection = connectionClass.getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (Objects.equals(email, resultSet.getString("email"))
						&& Objects.equals(shaHashInputHeslo, resultSet.getString("heslo"))) {
					System.out.println("Admin found - logged in");
					access = resultSet.getInt("access");
					prihlasovany = new Uzivatel(email, shaHashInputHeslo, access);
					aplikace.getBuddyAplikace().setAktualniUzivatel(prihlasovany);
					resultSet.close();
					statement.close();
					connection.close();
					return access;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba u ověřování - admin");
		}

		// zkus najít exchange
		try {
			// System.out.println("zkousime");
			String sql = "SELECT `email`, `access`, `heslo` FROM `Exchange`";
			//connection = connectionClass.getConnection();
			//statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (Objects.equals(email, resultSet.getString("email"))
						&& Objects.equals(shaHashInputHeslo, resultSet.getString("heslo"))) {
					System.out.println("Exchange student found - logged in");
					access = resultSet.getInt("access");
					prihlasovany = new Uzivatel(email, shaHashInputHeslo, access);
					aplikace.getBuddyAplikace().setAktualniUzivatel(prihlasovany);
					resultSet.close();
					statement.close();
					connection.close();
					return access;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba u ověřování - exchange student");
		}

		// zkus najít buddy
		try {
			// System.out.println("zkousime");
			String sql = "SELECT `email`, `access`, `heslo` FROM `Buddy`";
			//connection = connectionClass.getConnection();
			//statement = connection.createStatement();
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				if (Objects.equals(email, resultSet.getString("email"))
						&& Objects.equals(shaHashInputHeslo, resultSet.getString("heslo"))) {
					System.out.println("Buddy found - logged in");
					access = resultSet.getInt("access");
					prihlasovany = new Uzivatel(email, shaHashInputHeslo, access);
					aplikace.getBuddyAplikace().setAktualniUzivatel(prihlasovany);
					resultSet.close();
					statement.close();
					connection.close();
					return access;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Chyba u ověřování - buddy");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Neplatné jméno nebo heslo");
		return access;
	}

	// ------------------------------------------------------------------------------------------------------------------//
	//
	// Metody k nastavení stavu žádosti -> schváleno/zamítnuto a
	// zaplaceno/nezaplaceno. Kontrola plnosti akce //
	//
	// ------------------------------------------------------------------------------------------------------------------//

	/**
	 * Metoda upraví vztah dvou studentů. Id vztahu upravit nelze.
	 * 
	 * @param vztah_id
	 * @param exchange_id
	 * @param buddy_id
	 * @throws SQLException
	 */
	public void updateVztahuStudentu(int vztah_id, int exchange_id, int buddy_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "UPDATE `VztahBuddyExchange` SET `exchange_id`='" + exchange_id + "', `buddy_id`='" + buddy_id
					+ "' WHERE `vztah_id`='" + vztah_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda k nastavení stavu žádosti exchange studenta na zaplacenou, ve sloupci
	 * v DB "zaplaceno" bude hodnota 1. Stačí pouze tato metoda na nastavení
	 * zaplacení, protože při vytvoření requestu je defaultně v DB nastavena 0 jako
	 * nezaplaceno.
	 * 
	 * @param request_id
	 * @throws SQLException
	 */
	public void setRequestZaplaceno(int request_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "UPDATE `Request` SET `zaplaceno`= 1 WHERE `request_id`='" + request_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated zaplaceno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro nastavení žádosti na schválenou - od admina. V DB se u requestu ve
	 * sloupci "schvaleno" nastaví hodnota 1. Defaultně je nastavena hodnota NULL,
	 * protože admin může žádost i zamítnout - hodnota 0.
	 * 
	 * @param request_id
	 * @throws SQLException
	 */
	public void setRequestSchvaleno(int request_id) throws SQLException {
		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "UPDATE `Request` SET `schvaleno`= 1 WHERE `request_id`='" + request_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated schvaleno");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda pro nastavení žádosti na zamítnutou - od admina. V DB se u requestu ve
	 * sloupci "schvaleno" nastaví hodnota 0. Defaultně je nastavena hodnota NULL,
	 * protože admin může žádost i schválit - hodnota 1.
	 * 
	 * @param request_id
	 * @throws SQLException
	 */
	public void setRequestZamitnuto(int request_id) throws SQLException {

		Connection connection = null;
		Statement statement = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "UPDATE `Request` SET `schvaleno`= 0 WHERE `request_id`='" + request_id + "'";

			statement.executeUpdate(sql);
			System.out.println("updated zamítnuto");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("not updated");
		} finally {
			try {
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Metoda se volá v cotrolleru pro detail akce exchange studenta a to před tím,
	 * než student podá žádost o přihlášení na akci. Pokud by akce již byla
	 * obsazena, nedovolí mu se na akci přihlásit. Pokud je akce již plná, metoda
	 * vrací hodnotu true, pokud je ještě místo, vrací false.
	 * 
	 * Dále se metoda používá v admin controlleru pro seznam requestů kvůli
	 * kontrole. Admin nemůže schválit request, jestli je na akci již schválen plný
	 * počet účastníků. Může ho pak buďto nechat bez reakce anebo ho zamítnout. Tato
	 * situace může nastat, pokud více studentů zažádá a admin je schválí až
	 * dodatečně.
	 * 
	 * 
	 * @param akce_id
	 * @return boolean
	 * @throws SQLException
	 */
	public boolean zjistiObsazenaAkceProExchange(int akce_id) throws SQLException {

		int pocetPrihlasenychNaAkci = 0;
		int maxKapacitaAkce = 0;

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {
			connection = connectionClass.getConnection();
			statement = connection.createStatement();

			String sql = "SELECT COUNT(akce_id) FROM `Request` WHERE `schvaleno` = 1 AND `akce_id`='" + akce_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				pocetPrihlasenychNaAkci = resultSet.getInt(1);
			}
			resultSet.close();

			sql = "SELECT maxUcast FROM `Akce` WHERE `akce_id`='" + akce_id + "'";
			resultSet = statement.executeQuery(sql);
			while (resultSet.next()) {
				maxKapacitaAkce = resultSet.getInt(1);
			}

			System.out.println("Počet přihlášených - " + pocetPrihlasenychNaAkci);
			System.out.println("Kapacita akce - " + maxKapacitaAkce);
			System.out.println("čísla uloženy do proměnných");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("někde je chyba");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		if (maxKapacitaAkce > pocetPrihlasenychNaAkci) {
			System.out.println("vracím false - akce má místo");
			return false;
		} else {
			System.out.println("vracím true - akce je plná");
			return true;
		}
	}

}
