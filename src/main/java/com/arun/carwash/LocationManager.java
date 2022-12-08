package com.arun.carwash;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/addloc")
public class LocationManager extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException{
		String location = req.getParameter("location");
		
		String service1 =  req.getParameter("A");
		String service2 =  req.getParameter("B");
		String service3 =  req.getParameter("C");
		String service4 =  req.getParameter("D");
		String service5 =  req.getParameter("E");
		
		store(location,service1,service2,service3,service4,service5);
		res.sendRedirect("admindashboard.jsp");
		
	}
	public static void store(String location,String service1,String service2,String service3,String service4,String service5) {
		String sql = "INSERT INTO sample.location VALUES(?,?,?,?,?,?)";
		
		try {
			Class.forName("org.postgresql.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, location);
			ps.setString(2, service1);
			ps.setString(3, service2);
			ps.setString(4, service3);
			ps.setString(5, service4);
			ps.setString(6, service5);
			
			ps.executeUpdate();
			ps.close();
			con.close();
			
		} 
		catch (Exception e) {
			
		}
		
	}
}
