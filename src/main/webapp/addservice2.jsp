<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
	<%
	
	String location = request.getParameter("loc");
	
	String sql = "SELECT * FROM sample.location WHERE location="+"'"+location+"';";
	
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		
		rs.next();
		out.println("<table>");
		out.println("<tr>");
		out.println("<th>Service 1</th>");
		out.println("<th>Service 2</th>");
		out.println("<th>Service 3</th>");
		out.println("<th>Service 4</th>");
		out.println("<th>Service 5</th>");
		out.println("</tr>");
		out.println("<tr>");
		out.println("<td>"+rs.getString(2)+"</td>");
		out.println("<td>"+rs.getString(3)+"</td>");
		out.println("<td>"+rs.getString(4)+"</td>");
		out.println("<td>"+rs.getString(5)+"</td>");
		out.println("<td>"+rs.getString(6)+"</td>");
		out.println("</tr>");
		out.println("</table>");
		
		session.setAttribute("location",location);
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	%>
	<form action="servicechange1" method="post">
		CHOOSE SERVICE : <br>
		ADD : <input type="radio" name="service" value="add"><br>
		REMOVE : <input type="radio" name="service" value="remove"><br>
		<input type="text" name="type">
		<button>SUBMIT</button>
	</form>
	
</body>
</html>