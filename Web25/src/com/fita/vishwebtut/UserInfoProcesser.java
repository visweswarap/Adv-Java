package com.fita.vishwebtut;

import java.io.IOException;
import java.sql.Connection;
import java.util.Random;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fita.vishwebtut.factory.PostgresConnection;
import com.fita.vishwebtut.jdbc.JdbcCrud;

public class UserInfoProcesser extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}
	
	protected void service(HttpServletRequest request, HttpServletResponse response) throws IOException{
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		request.setAttribute("userFullName", fname + " " + lname);
		HttpSession session = request.getSession(true);
		session.setAttribute("firstName", fname);
		session.setAttribute("userFullName1", fname + " " + lname);
		response.sendRedirect("./jsps/success.jsp");
		
		/*PostgresConnection pgsqlConnProvider = new PostgresConnection();
		
		Connection pgsqlConnObj = pgsqlConnProvider.getConnection();
		String name = fname + " " + lname;
		
		JdbcCrud.insertEmployee(new Random().nextInt(), name, "Dev");*/
	}
	

	
	public void destroy() {
		super.destroy();
	}
}
