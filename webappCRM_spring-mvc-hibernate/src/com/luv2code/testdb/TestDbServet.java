package com.luv2code.testdb;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.*;

/**
 * Servlet implementation class TestDbServet
 */
@WebServlet("/TestDbServet")
public class TestDbServet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// setup connection vars
		String user = "springstudent";
		String pass = "springstudent";
		String jdbcURL = "jdbc:mysql://localhost:3306/web_customer_tracker?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC";
		String driver = "com.mysql.cj.jdbc.Driver";
		
		// get connection from db
		try {
			PrintWriter out  = response.getWriter();
			out.println("connecting to db: "+jdbcURL);
			Class.forName(driver);
			Connection myCon = DriverManager.getConnection(jdbcURL, user, pass);
			out.println("Connection ok.");
			myCon.close();
			
		}
		catch (Exception e){
			e.printStackTrace();
			throw new ServletException(e);}
		
	}

}
