<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	font-size:x-large;
}
    .whole-page{
      display:grid;
      grid-template-columns: 1fr 1fr;
      height: 680px;
    }
    .next{
      margin-top: 20%;
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
    button{
	margin-top:10px;
	padding:8px;
	background-color:white;
	color:blue;
	border:1px solid blue;
	border-radius:2px;
}
button:hover{
	background-color:blue;
	color:white;
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
        <a href="viewcustomer.jsp">ALL CUSTOMERS</a><br>
	<a href="locationfilter.jsp">CUSTOMER FILTER</a><br>
	<a href="admindashboard.jsp">EXIT</a><br>
      </div>
      
    </div>
  </div>
</div>
</body>
</html>