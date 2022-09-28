<%@page import="shopcart.model.UserStore"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/myStyle.css">
<meta charset="ISO-8859-1">
<title>My ShopCart - Register Product</title>
</head>
<body>
	<%
		UserStore user = (UserStore)session.getAttribute("userlogin");
			if(user == null){
				response.sendRedirect("login.jsp");
			}
		%>
	<nav class="myNav">
		<ul>
			<li><span style="color: yellow">MyShopCart</span></li>
			<li><img src="img/bacana.png" height="20px"></li>
			<li><a href="registerProduct.jsp">Register Product</a></li>
			<li><a href="searchProduct.jsp">Search Product</a></li>
			<li><a href="login.jsp">Log off</a></li>
			<li><span style="color: yellow">User: <%out.print(user.getName());%></span></li>
			<li><span style="color: yellow">Balance<%out.print(user.getBalance());%></span></li>
		</ul>
	</nav>
	<main class="myMain">
		<form action="register" method="post" class="myForm">
			<div>
				<label><strong>Description:</strong></label><input type="text"
					name="description">
			</div>
			<div>
				<label><strong>Amount:</strong></label><input type="text"
					name="amount">
			</div>
			<div>
				<label><strong>Category:</strong></label>
				<select style="width: 400px;background-color: #F1AE2B;
				padding: 10px;border: 1px solid gray;border-radius: 8px;" 
				id="appearance-select" name="category">
    				<option value=""></option>
    				<option value="ACCESSORIES">ACCESSORIES</option>
    				<option value="CLOTHES">CLOTHES</option>
    				<option value="FOOTWEAR">FOOTWEAR</option>
    				<option value="SUPPLEMENTS">SUPPLEMENTS</option>
  				</select>
			</div>
			
			<div>
				<label><strong>Price:</strong></label><input type="text"
					name="price">
			</div>

			<label><strong>Available On-Line:</strong></label><input
				type="checkbox" name="online">
			<br>
			<div>
				<input id="myButton" type="submit" name="salvar"
					value="Register Product">
			</div>
			
			<div>
				<%
				 String message = (String)request.getAttribute("message");
				if(message != null){
					out.print(message);
				}
				%>
			</div>
		</form>
	</main>
</body>
</html>