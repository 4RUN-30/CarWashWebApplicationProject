<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
	
	String sql = "SELECT * from sample.customer;";
	ArrayList<String> locations = new ArrayList<>();
	ArrayList<String> dates = new ArrayList<>();
	try {
		Class.forName("org.postgresql.Driver");
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","3027");
		Statement s = con.createStatement();
		ResultSet rs = s.executeQuery(sql);
		while(rs.next()) {
			locations.add(rs.getString(2));
			dates.add(rs.getString(4));
		}
	} 
	catch (Exception e) {
		e.printStackTrace();
	}
	%>
	
	<table>
		<tr><th>Locations</th><th>Date</th></tr>
		<%for(int i=0;i<locations.size();i++){ %>
		<tr><td><%=locations.get(i) %></td><td><%=dates.get(i) %></td></tr>
		<%} %>
	</table>
	<form action="view" method="post">
		Enter location : <input type="text" name="location_choice"><br>
		Enter date : <input type="date" name="date_choice"><br>
		<button>Submit</button>
	</form>
	
</body>
</html>