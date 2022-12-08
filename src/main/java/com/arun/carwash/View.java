package com.arun.carwash;

import java.io.IOException;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/view")
public class View extends HttpServlet{
	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException {
		String s = req.getParameter("location_choice");
		String date = req.getParameter("date_choice");
		String sql = "SELECT * FROM sample.customer WHERE location="+"'"+s+"' AND date="+"'"+date+"';";
		HttpSession session = req.getSession();
		session.setAttribute("sql",sql);
		res.sendRedirect("viewcustomerlocation.jsp");
	}
	
}
