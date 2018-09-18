package com.app.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	private static Connection con = null;
	static {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "durga", "oracle");
		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		}
	}

	public static Connection getConnection() {
		return con;
	}
}
