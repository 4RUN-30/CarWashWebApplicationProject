<%@ page language="java" contentType="text/html; charset=ISO-8859-1 "
    pageEncoding="ISO-8859-1"%>
    <%@ page import="java.sql.*,java.util.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link rel="stylesheet" href="table.css">
</head>
<body>
	<%
	
	String sql = "SELECT location from sample.location;";
	ArrayList<String> locations = new ArrayList<>();
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			locations.add(rs.getString(1));
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	%>
	
	<table>
		<tr><th>Locations</th></tr>
		<%for(int i=0;i<locations.size();i++){ %>
		<tr><td><%=locations.get(i) %></td></tr>
		<%} %>
	</table>
	<form action="addservice2.jsp" method="post">
		Location : <input type="text" name="loc"><br>
		<button>submit</button>
	</form><br>
	<a href="admindashboard.jsp">EXIT</a>
</body>
</html>