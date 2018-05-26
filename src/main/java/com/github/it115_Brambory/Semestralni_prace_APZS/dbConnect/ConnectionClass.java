package com.github.it115_Brambory.Semestralni_prace_APZS.dbConnect;

import java.sql.*;

/**
 * @author Admiral Pike
 *
 * Jednoduchá třída sloužící k navázání spojení s databází.
 *
 */
public class ConnectionClass {
	
	public Connection connection;
	public Connection getConnection() {
		
		//String dbName = "zikl00";
		//String userName = "zikl00";
		//String password = "g1SCIjiIYHOSQ7hWVN";
		
		String dbName = "brambory115";
		String userName = "brambora1";
		String password = "brambory159";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			//85.10.205.173
			connection = DriverManager.getConnection("jdbc:mysql://85.10.205.173:3306/"+dbName,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return connection;
	}
}
