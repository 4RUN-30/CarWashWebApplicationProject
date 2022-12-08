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
		String mail = session.getAttribute("mail").toString();
			String status="";
			String sql = "SELECT * FROM sample.customer WHERE mail="+"'"+mail+"';";
			Class.forName("org.postgresql.Driver");
			Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
			Statement st = con.createStatement();
			ResultSet rs = st.executeQuery(sql);
			
		
	%>
	<div>
	<table>
	<tr><th>Location</th><th>Date</th><th>Status</th></tr>
		<%while(rs.next()){ %>
		<tr><td><%=rs.getString(2) %></td><td><%=rs.getString(4) %></td><td><%=rs.getString(5) %></td></tr>
		<%} %>
	
	</table>
	</div>
</body>
</html>