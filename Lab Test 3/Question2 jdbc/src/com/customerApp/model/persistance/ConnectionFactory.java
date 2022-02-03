package com.customerApp.model.persistance;

import java.io.*;
import java.sql.*;
import java.util.*;

public class ConnectionFactory {

	private static Connection connection = null;

	public static Connection getConnection() {
		Properties prop = new Properties();

		try {
			FileInputStream fir = new FileInputStream(new File(
					"C:\\Users\\ve00ym329\\Documents\\lab assignments\\jdbcAssessmentym329\\src\\db.properties"));
			prop.load(fir);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String url = prop.getProperty("jdbc.url");
		String driver = prop.getProperty("jdbc.driver");
		String username = prop.getProperty("jdbc.username");
		String password = prop.getProperty("jdbc.password");

		try {
			Class.forName(driver);
			System.out.println("driver is loaded...");
			connection = DriverManager.getConnection(url, username, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return connection;

	}

}
