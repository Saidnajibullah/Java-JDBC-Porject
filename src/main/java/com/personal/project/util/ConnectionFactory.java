package com.personal.project.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionFactory {
	private static String url;
	private static String username;
	private static String password;
	private static final String CREDENTIALS = "src/main/resources/connection.properties";
	private static ConnectionFactory cf;
	
	
	@SuppressWarnings("unused")
	public synchronized static Connection getConnection() {
		if(cf == null) {
			cf = new ConnectionFactory();
		}
		return cf.createConnection();
	}
	
	private ConnectionFactory() {
		Properties p = new Properties();   
		try {
			p.load(new FileInputStream(CREDENTIALS));
			url = p.getProperty("url");
			username = p.getProperty("username");
			password = p.getProperty("password");
		}catch(FileNotFoundException e) {
			System.out.println(e);
			
		}catch(IOException e) {
			System.out.println(e);
			
		}
	}
	
	private Connection createConnection() {
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, username, password);
		}catch(SQLException e) {
			System.out.println(e);
		}catch(ClassNotFoundException e) {
			System.out.println(e);
		}
		return conn;
	}

}
