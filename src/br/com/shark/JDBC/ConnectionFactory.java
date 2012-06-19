package br.com.shark.JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import br.com.shark.XML.MapConfig;

public class ConnectionFactory {

	private static final String DRIVER = "com.mysql.jdbc.Driver";
	
	public static Connection getConnection() {
		try {
			Class.forName(DRIVER);
			return DriverManager.getConnection(MapConfig.getInstance().get("CONFIG-DB_URL"), MapConfig.getInstance().get("CONFIG-DB_USER"), MapConfig.getInstance().get("CONFIG-DB_PASSWORD"));
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static void closeConnection(Connection conn){
		try {
			conn.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
