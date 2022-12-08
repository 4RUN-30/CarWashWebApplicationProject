package com.arun.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/servicechange1")
public class ServiceManager extends HttpServlet {
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String val = req.getParameter("service");
		String type = req.getParameter("type");
		String g = generateString(type); // service1
		HttpSession session = req.getSession();
		String location = session.getAttribute("location").toString();
		if(val.equals("add")) {
			String sql = "UPDATE sample.location SET "+g+"='"+type+"' WHERE location='"+location+"';";
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
				ps.close();
				con.close();
			} 
			catch (Exception e) {
				
			}
			
		}
		else{
			String sql = "UPDATE sample.location SET "+g+"='"+session.getAttribute("arun")+"' WHERE location='"+location+"';";
			
			try {
				Class.forName("org.postgresql.Driver");
				Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
				PreparedStatement ps = con.prepareStatement(sql);
				ps.executeUpdate();
				ps.close();
				con.close();
			} 
			catch (Exception e) {
				
			}
		}
		res.sendRedirect("admindashboard.jsp");
	}
	static String generateString(String type) {
		return "service"+type;
	} 
}
