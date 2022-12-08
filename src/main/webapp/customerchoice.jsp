<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
    .whole-page{
      display:grid;
      grid-template-columns: 1fr 1fr;
      height: 680px;
    }
    .next{
      margin-top: 40%;
      margin-left: 40%;;
    }
    a{
      font-size: xx-large;
      display: block;
      text-decoration: none;
      color:black;
    }
    a:hover{
      color:blueviolet
    }
    img{
      height:max-content;
    }
  </style>
</head>
<body>
	
	
	
	<div class="whole-page">
    <div class="left">
      <img src="car1.webp">
    </div>
    <div class="right">
      <div class="next">
      <h1>CUSTOMER DASHBOARD</h1>
        <a href="customerdashboard.jsp">Book Service</a><br>
	<a href="viewstatus.jsp">View Status</a><br>
	<a href="start.html">Logout</a><br>
      </div>
      
    </div>
  </div>
</body>
</html>