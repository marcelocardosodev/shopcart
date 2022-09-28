<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/myStyle.css">
<meta charset="ISO-8859-1">
<title>My ShopCart - Register User</title>
</head>
<body>
	<%
	 String message = null;
	%>
	<nav class="myNav">
		<ul>
			<li><span style="color: yellow">MyShopCart</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="login.jsp">Sign in</a></li>
		</ul>
	</nav>
	<main class="myMain">
		<form action="adduser" method="post" class="myForm">
			<div>
				<label><strong>User Name:</strong></label><input type="text"
					name="name">
			</div>
			<div>
				<label><strong>Balance:</strong></label><input type="text"
					name="balance">
			</div>
			<div>
				<label><strong>Password:</strong></label><input type="text"
					name="password">
			</div>

			<label><strong>Type Admin:</strong></label><input
				type="checkbox" name="admin">
			<br>
			<div>
				<input id="myButton" type="submit" name="register"
					value="Register User">
			</div>
			<div>
				<%
				 message = (String)request.getAttribute("message");
				if(message != null){
					out.print(message);
				}
				%>
			</div>
		</form>
	</main>
</body>
</html>