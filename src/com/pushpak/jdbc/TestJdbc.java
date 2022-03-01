package com.pushpak.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {
	public static void main(String[] args) {

		String url = "jdbc:oracle:thin:@localhost:1521:orcl1";

		String user = "system";
		String pass = "root";
		try {

			System.out.println("Connectiong to DataBase : " + url);
			
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			Connection con = DriverManager.getConnection(url, user, pass);
			
			con.isValid(32);
			System.out.println("connected ? "+con.isValid(3));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
