package com.fita.vishwebtut.factory;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PostgresConnection implements ConnProvider {

	public Connection getConnection() {
		Connection conn = null;
		try {
			
			// Getting Connection with Driver class directly
			/*Driver driver = new org.postgresql.Driver();
			Properties prop = new Properties();
			prop.put("user", "postgres");
			prop.put("password", "Vish@2016");
			conn = driver.connect("jdbc:postgresql://127.0.0.1:5432/Vish_tutorial", prop);*/
			
			try {
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
			
			// Getting Connection with DriverManager
			//DriverManager.registerDriver(new org.postgresql.Driver());
			conn = DriverManager.getConnection("jdbc:postgresql://127.0.0.1:5432/Vish_tutorial", "postgres", "Vish@2016");
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}

}
