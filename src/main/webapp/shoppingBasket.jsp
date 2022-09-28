<%@page import="shopcart.model.ShoppingBasket"%>
<%@page import="shopcart.model.UserStore"%>
<%@page import="shopcart.model.Item"%>
<%@page import="shopcart.model.Product"%>
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
			<li><span style="color: yellow">Balance: <%out.print(user.getBalance());%></span></li>
		</ul>
	</nav>
		<main class="myMain">
	<div class="myForm">
		<form action="search" method="post">
			<br>
			<div class="myColumn">
				<input id="myButton" type="submit" name="buy"
					value="Buy All">
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
		<%if (session.getAttribute("shoppingBasket") != null) {
			ShoppingBasket shopBasket = (ShoppingBasket)session.getAttribute("shoppingBasket");
			List<?> items = (List<?>)shopBasket.getList() ;
			for (int contador = 0; contador <= (items.size() - 1); contador++) {
				Item itemBasket = ( Item)items.get(contador);%>
		<form action="changeproduct" method="post">
			<div class="myDivMother">
				<div class="myDivItem">
					<div class="myColumn">
						<span style="font-weight: bold">Amount</span> 
						<span><%out.print(itemBasket.getAmount());%></span> 
						<input type="hidden" name="id" value="<%out.print(itemBasket.getIdItem());%>">
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Id Product</span> 
						<span><%out.print(itemBasket.getProduct().getIdProduct());%></span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Description</span>
						<span><%out.print(itemBasket.getProduct().getDescription());%></span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Category</span>
						<span><%out.print(itemBasket.getProduct().getCategory());%>
						</span>
					</div>
					<div class="myColumn">
						<span style="font-weight: bold">Price</span> 
						<span><%out.print(itemBasket.getProduct().getPrice());%></span>
					</div>
					<div class="myColumn">
						<input id="myItemButton"
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