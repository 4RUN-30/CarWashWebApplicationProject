package com.arun.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/changestatus")
public class Status extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String operation = req.getParameter("status");
		String mail = req.getParameter("mail");
		String location = req.getParameter("location");
		String date = req.getParameter("date");
		
		if(operation.equals("add")) {
			boolean flag = check(location,date);
			if(flag) {
				String sql = "UPDATE sample.customer SET status='success' WHERE mail="+"'"+mail+"';";
				
				try {
					Class.forName("org.postgresql.Driver");
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
					PreparedStatement  ps = con.prepareStatement(sql);
					ps.executeUpdate();
					ps.close();
					con.close();
				}
				catch(Exception e) {
					
				}
			}
			
		}
		else if(operation.equals("reject")) {
			String sql = "UPDATE sample.customer SET status='reject' WHERE mail="+"'"+mail+"';";
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
				PreparedStatement  ps = con.prepareStatement(sql);
				ps.executeUpdate();
				ps.close();
				con.close();
			}
			catch(Exception e) {
				
			}
		}
		res.sendRedirect("addcustomer.jsp");
	}
	static boolean check(String location,String date) {
		String sql = "SELECT * FROM sample.customer WHERE location="+"'"+location+"' AND date="+"'"+date+"' AND status='success';";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			Statement  ps = con.createStatement();
			ResultSet rs = ps.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				i++;
			}
			System.out.println(i);
			if(i>=5) {
				reject(location,date);
				return false;
			}
			else {
				return true;
			}
		}
		catch(Exception e) {
			
		}
		System.out.println("hellllllo bro");
		return false;
	}
	static void reject(String location,String date) {
		String sql = "UPDATE sample.customer SET status='reject' WHERE location="+"'"+location+"' AND date="+"'"+date+"' AND status='pending';";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			PreparedStatement  ps = con.prepareStatement(sql);
			ps.executeUpdate();
			ps.close();
			con.close();
			System.out.println("rejected");
		}
		catch(Exception e) {
			
		}
		
	}
}
