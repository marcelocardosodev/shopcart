<%@page import="shopcart.model.UserStore"%>
<%@page import="shopcart.model.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/myStyle.css">

<meta charset="ISO-8859-1">
<title>My ShopCart</title>
</head>
<body>
	<nav class="myNav">
		<%
			UserStore user = (UserStore)session.getAttribute("userlogin");
			if(user == null){
				response.sendRedirect("login.jsp");
			}
		%>
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
		<form action="changeproduct" method="post" class="myForm">
			<%
			Product product = null;
			if (request.getAttribute("product") != null) {
				product = (Product) request.getAttribute("product");
			}
			%>
			<input type="hidden" name="id" value="<%out.print(product.getIdProduct());%>">
			<div>
				<label><strong>Description:</strong></label><input type="text"
					name="description" value="<%out.print(product.getDescription());%>">
			</div>
			<div>
				<label><strong>Amount:</strong></label>
				<input type="text" name="amount" value="<%out.print(product.getAmount());%>">
			</div>
			<div>
				<label><strong>Category:</strong></label>
				<select style="width: 400px;background-color: #F1AE2B;
				padding: 10px;border: 1px solid gray;border-radius: 8px;" 
				id="appearance-select" name="category">
    				<option value=""><%out.print(product.getCategory());%></option>
    				<option value="ACCESSORIES">ACCESSORIES</option>
    				<option value="CLOTHES">CLOTHES</option>
    				<option value="FOOTWEAR">FOOTWEAR</option>
    				<option value="SUPPLEMENTS">SUPPLEMENTS</option>
  				</select>
			</div>
			<div>
				<label><strong>Price:</strong></label><input type="text"
					name="price" value="<%out.print(product.getPrice());%>">
			</div>

			<label><strong>Avaliable On-Line:</strong></label><input
				type="checkbox" name="online" value="true"
				<%if (product.isOnline()) {
					out.print("checked");
				}%>> <br>
			<div>
				<input id="myButton" type="submit" name="saveChange"
					value="Change Product">
			</div>
			<div>
				<input type="hidden" name="id" >
			</div>
			<div>
				<%
				String message = (String) request.getAttribute("message");
				if (message != null)
					out.print(message);
				%>
			</div>
		</form>
	</main>
</body>
</html>