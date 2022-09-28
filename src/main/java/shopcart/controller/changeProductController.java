package shopcart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shopcart.dao.ProductDao;
import shopcart.model.Category;
import shopcart.model.Product;

/**
 * Servlet implementation class changeProductController
 */
@WebServlet("/changeProductController")
public class changeProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public changeProductController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String delete = request.getParameter("delete");
		String change = request.getParameter("change");
		String saveChange = request.getParameter("saveChange");
		String description = request.getParameter("description");
		String category = request.getParameter("category");
		String amount = request.getParameter("amount");
		String price = request.getParameter("price");
		String online = request.getParameter("online");
		String id = request.getParameter("id");
		
		Boolean on = online ==null? false:true;
		
		if(delete !=null && id !=null) {
			new Product().excluirProduct(Integer.parseInt(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("searchProduct.jsp");
			request.setAttribute("message", "Product deleted");
			dispatcher.forward(request, response);
		
		}else if(change != null && id != null) {
			Product product = new Product().seacherById(Integer.parseInt(id));
			RequestDispatcher dispatcher = request.getRequestDispatcher("changeProduct.jsp");
			request.setAttribute("product", product);
			dispatcher.forward(request, response);

		}else if(saveChange !=null && id != null) {
			Product productReceived = new Product();
			productReceived.setIdProduct(Integer.parseInt(id));
			productReceived.setDescription(description);
			productReceived.setCategory(category!=null?Category.valueOf(category):null);
			productReceived.setAmount(Integer.parseInt(amount));
			productReceived.setPrice(Double.valueOf(price));
			productReceived.setOnline(on);
			
			if(description != null && !description.isEmpty() 
					&& amount != null&& !amount.isEmpty() 
					&& price != null && !price.isEmpty()
					&& category != null&& !category.isEmpty()){
				
				new Product().change(productReceived);
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("searchProduct.jsp");
				request.setAttribute("product", productReceived);
				request.setAttribute("message", "Product successfully changed!");
				dispatcher.forward(request, response);
				
			}else {
				
				RequestDispatcher dispatcher = request.getRequestDispatcher("changeProduct.jsp");
				request.setAttribute("product", productReceived);
				request.setAttribute("message", "The fields need to be filled in!");
				dispatcher.forward(request, response);
			}
		}
		
//		if(description != null && !description.isEmpty() && request.getParameter("amount") != null
//				&& !request.getParameter("amount").isEmpty() && request.getParameter("price") != null
//				&& !request.getParameter("price").isEmpty()&& request.getParameter("category") != null
//				&& !request.getParameter("category").isEmpty()) {
//			
//			int amount;
//			double price;
//			String category;
//			amount = Integer.parseInt(request.getParameter("amount"));
//			price = Double.parseDouble(request.getParameter("price"));
//			category = request.getParameter("category");
//			boolean online = false;
//			if (request.getParameter("online") != null && request.getParameter("online").equals("true"))
//				online = true;
//			Product product = new Product(description, amount,category, price, online);
//			product.setIdProduct(Integer.valueOf(id));
//			product.change();
//			messge = "Product successfully changed!";
//			request.setAttribute("messge", messge);
//		}else {
//			messge = "The fields need to be filled in!";
//			request.setAttribute("messge", messge);
//			dispatcher.forward(request, response);
//		}
	}

}
