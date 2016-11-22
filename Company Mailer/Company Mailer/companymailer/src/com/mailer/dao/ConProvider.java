package com.mailer.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConProvider {

	public static Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "system", "rajsheki123");
		} catch (Exception e) {
			System.out.println(e);
		}
		return con;
	}
}
