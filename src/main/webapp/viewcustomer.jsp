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
		String sql = "SELECT * FROM sample.customer;";
		
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		 
	%>
			<table>
		
				<tr><th>Mail</th><th>Location</th><th>Service</th><th>Date</th><th>Status</th></tr>
				<%while(rs.next()){ %>
					<tr><td><%=rs.getString(1)%></td><td><%=rs.getString(2)%></td><td><%=rs.getString(3)%></td><td><%=rs.getString(4)%></td><td><%=rs.getString(5)%></td></tr>
				<%} %>
			</table>
			<br>
	<a href="admindashboard.jsp">EXIT</a>
	
</body>
</html>