<%@page import="shopcart.model.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/myStyle.css">

<meta charset="ISO-8859-1">
<title>My ShopCart - Login</title>
</head>
<body>
	<nav class="myNav">
		<ul>
			<li><span style="color: yellow">MyShopCart</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="registerUser.jsp">Register User</a></li>
		</ul>
	</nav>
	<main class="myMain">
	<div class="myForm">
		<form action="login" method="post">
			<div>
				<label><strong>User Name:</strong></label><input
					type="text" name="name">
			</div>
			<div>
				<label><strong>Password:</strong></label><input
					type="text" name="password">
			</div>
			<br>
			<div class="myColumn">
				<input id="myButton" type="submit" name="login"
					value="Sign in">
			</div>
			<div class="myColumn">
				<%
				String message = (String) request.getAttribute("message");
				if (message != null)
					out.print(message);
				%>
			</div>
		</form>
	</div>
	</main>
</body>
</html>