<%@page import="shopcart.model.Product"%>
<%@page import="shopcart.model.UserStore"%>
<%@page import="java.util.List"%>
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
			<li><a href="shoppingBasket.jsp">Shopping Basket</a></li>
			<li><a href="login.jsp">Log off</a></li>
			<li><span style="color: yellow">User: <%out.print(user.getName());%></span></li>
			<li><span style="color: yellow">Balance<%out.print(user.getBalance());%></span></li>
		</ul>
	</nav>
	<main class="myMain">
	<div class="myForm">
		<form action="search" method="post">
			<div>
				<label><strong>Search by description:</strong></label><input
					type="text" name="description">
			</div>
			<br>
			<div class="myColumn">
				<input id="myButton" type="submit" name="salve"
					value="Search Product">
			</div>
			<div class="myColumn">
				<%
				String message = (String) request.getAttribute("message");
				if (message != null)
					out.print(message);
				%>
			</div>
			<div>
				<input type="hidden" name="userId" value = 77 >
			</div>
		</form>
		<%if (request.getAttribute("products") != null) {
			List<?> products = (List<?>) request.getAttribute("products");
			for (int contador = 0; contador <= (products.size() - 1); contador++) {
				Product product = ( Product)products.get(contador);%>
		<form action="changeproduct" method="post">
			<div class="myDivMother">
				<div class="myDivItem">
					<div class="myColumn">
						<span style="font-weight: bold">Id</span> 
						<span><%out.print(product.getIdProduct());%></span> 
						<input type="hidden" name="id" value="<%out.print(product.getIdProduct());%>">
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Description</span>
						<span><%out.print(product.getDescription());%></span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Category</span>
						<span><%out.print(product.getCategory());%>
						</span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Price</span> 
						<span><%out.print(product.getPrice());%></span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Amount</span> 
						<span><%out.print(product.getAmount());%></span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">On-Line</span> 
						<span><%out.print(product.isOnline());%></span>
					</div>
					<div class="myColumn">
						<input id="myItemButton" type="submit" name="change"
							value="Change"> <input id="myItemButton"
							type="submit" name="delete" value="Delete">
					</div>
				</div>
			</div>
		</form>
		<%
		}
		}
		%>
	</div>
	</main>
</body>
</html>