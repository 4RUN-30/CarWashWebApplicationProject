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
import javax.servlet.http.HttpSession;

@WebServlet("/addlogin")
public class Manager extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		String username = req.getParameter("mail");
		String password = req.getParameter("pass");
		
		boolean exist = check(username,password);
		
		if(exist) {
			res.sendRedirect("signup.jsp");
		}
		else {
			String sql = "INSERT INTO sample.userlogin (email,password) VALUES(?,?)";
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,username);
				ps.setString(2,password);
				ps.executeUpdate();
				ps.close();
				con.close();
				HttpSession session = req.getSession();
				session.setAttribute("mail", username);
				res.sendRedirect("customerchoice.jsp");
			}
			catch(Exception e) {
				
			}
		}
		
	}
	public boolean check(String username,String password) {
		String sql = "SELECT * FROM sample.userlogin WHERE email="+"'"+username+"';";
		
		try {
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			Statement s = con.createStatement();
			ResultSet rs = s.executeQuery(sql);
			int i=0;
			while(rs.next()) {
				i++;
			}
			if(i==1) {
				System.out.println("true");
				return true;
			}
			else {
				System.out.println("false");
				return false;
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}