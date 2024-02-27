package com.jsp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectDatabase {
	
	public Connection getConnection() {
		try {
			Class.forName("org.postgresql.Driver");
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/servlet_assignment","postgres","root");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
