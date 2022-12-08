package com.arun.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/addcustomer")
public class Customer extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		HttpSession session = req.getSession();
		
		String location = session.getAttribute("location").toString();
		String type = req.getParameter("service");
		String date = req.getParameter("date");
		String mail = session.getAttribute("mail").toString();
		String status = "pending";
		
		boolean flag = canRegister(location,date);
		boolean flag2 = alreadyRegistered(mail);
		
		if(flag && flag2) {
			String sql = "INSERT INTO sample.customer VALUES("+"'"+mail+"','"+location+"','"+type+"','"+date+"','"+status+"');";
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
				ps.close();
				con.close();
			}
			catch(Exception e) {
				
			}
			res.sendRedirect("customerchoice.jsp");
		}
		else {
			System.out.println("cant");
			res.sendRedirect("customerchoice.jsp");
		}
		
	}
	public static boolean canRegister(String location,String date) {
		String sql = "SELECT * FROM sample.customer WHERE location="+"'"+location+"' AND date="+"'"+date+"' AND status="+"'success';";    
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				i++;
			}
			System.out.println(i);
			if(i>=5) {
				return false;
			}
			else {
				return true;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	static boolean alreadyRegistered(String mail) {
		try {
			String sql = "SELECT * FROM sample.customer WHERE mail="+"'"+mail+"'"+" AND status != 'reject';";
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				i++;
			}
			if(i==0) {
				return true;
			}
			else {
				return false;
			}
		}
		catch(Exception e) {
			
		}
		return false;
	}
}
