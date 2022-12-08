package com.arun.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/checkadmin")
public class Admin extends HttpServlet{
	
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		
		String username = req.getParameter("mail");
		String password = req.getParameter("pass");
		
		String sql = "SELECT * FROM sample.admin WHERE mail='"+username+"'AND password='"+password+"';";
		
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
				res.sendRedirect("admindashboard.jsp");
			}
			else {
				HttpSession session = req.getSession();
				session.setAttribute("validate","invalid");
				res.sendRedirect("admin.jsp");
			}
		} 
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}
