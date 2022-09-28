package shopcart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;

import shopcart.model.Category;
import shopcart.model.Product;
import shopcart.model.Type;
import shopcart.model.UserStore;

/**
 * Servlet implementation class registerProductController
 */
@WebServlet("/registerProductController")
public class registerProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerProductController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		var description = request.getParameter("description");
		var amount = request.getParameter("amount");
		var category = request.getParameter("category");
		var price = request.getParameter("price");
		System.out.println(description);
		System.out.println(amount);
		System.out.println(category);
		System.out.println(price);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerProduct.jsp");
		var description = request.getParameter("description");
		var amount = request.getParameter("amount");
		var category = request.getParameter("category");
		var price = request.getParameter("price");
		var online =  request.getParameter("online");
		
		if((description != null && !description.isEmpty())
				&&(amount != null && !amount.isEmpty())
				&&( category != null && !category.isEmpty())
				&&( price != null && !price.isEmpty())) {
			
			
			Product product = new Product();
			product.setDescription(description);
			product.setCategory(Category.valueOf(category)); 
			product.setAmount(Integer.parseInt(amount));
			
			if(online != null && online.equals("on")) {
				product.setOnline(true);
			}else {
				product.setOnline(false);
			}
			if(price!= null && !price.isEmpty()) {
				
				try {
					product.setPrice(Double.valueOf(price));
				} catch (Exception e) {
					
					product.setPrice(Double.valueOf("10.00"));
				}
				
			}
			
			if(product.saveProduct(product)) {
				
				message = "Product saved successfully";
				request.setAttribute("message", message);
			}else {
				message = "Error saving user";
				request.setAttribute("message", message);
			}
			
		}else {
			message = "All filds are required";
			request.setAttribute("message", message);
		}
		
		dispatcher.forward(request, response);

		
	}

}
