package com.luv2code.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

//this class&package is just to test the jdbc connection to the database
//can be deleted later on (the whole com.luv2code.jdbc package)
public class TestJdbc {

	public static void main(String[] args) {


		String jdbcUrl = "jdbc:mysql://localhost:3306/hb_student_tracker?useSSL=false";
		String user = "hbstudent";
		String pass = "hbstudent";
		try {
			System.out.println("connecting to db: " + jdbcUrl);
			Connection myConn = DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("connection OK!");
			
		} catch (Exception e) {e.printStackTrace();}

	}

}
