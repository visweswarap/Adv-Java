package com.fita.vishwebtut.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import com.fita.vishwebtut.factory.ConnProvider;
import com.fita.vishwebtut.factory.DBConnectionFactory;

public class JdbcCrud {
	
	final static ConnProvider connprovider = DBConnectionFactory.getInstance("en_CA");
	
	public static void main(String[] args) {
		String query = "SELECT id, \"Name\", \"Dept\", \"Salary\" FROM Employee ORDER BY id ASC";
		
		Connection conn = connprovider.getConnection();
		try {
			//insertEmployee();
			
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(query);
			while(rs.next()){
				System.out.println("\n \n");
				System.out.print(rs.getInt("id"));
				System.out.print("\t"+rs.getString("Name"));
				System.out.print("\t"+rs.getString("Dept"));
				System.out.println("\t"+rs.getDouble("Salary"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void insertEmployee(int id, String name, String dept){
		double sal = 15010;
		String query = "INSERT INTO employee(\"id\",\"Name\", \"Dept\", \"Salary\") VALUES (?,?,?,?)";
		Connection conn = connprovider.getConnection();
		try {
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setInt(1, id);
			stmt.setString(2, name);
			stmt.setString(3, dept);
			stmt.setDouble(4, sal);;
			System.out.println(stmt.execute());
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	private static void deleteEmployee(int id){
		String query = "DELETE FROM employee WHERE id = " + id;
		Connection conn = connprovider.getConnection();
		try {
			Statement stmt = conn.createStatement();
			boolean isSuccess = stmt.execute(query);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) 
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
