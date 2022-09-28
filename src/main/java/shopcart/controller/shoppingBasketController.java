package shopcart.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import shopcart.model.Item;
import shopcart.model.Product;
import shopcart.model.ShoppingBasket;
import shopcart.model.UserStore;

/**
 * Servlet implementation class shoppingBasketController
 */
@WebServlet("/shoppingBasketController")
public class shoppingBasketController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public shoppingBasketController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		String addCar = request.getParameter("addCar");
		UserStore user = (UserStore)session.getAttribute("userlogin");
		String idProduct = request.getParameter("id");
		
		if((addCar != null && !addCar.isEmpty())
				&&(user !=null && user.getIdUser() !=null)
				&& (idProduct !=null && !idProduct.isEmpty())){
			Product product = new Product().seacherById(Integer.parseInt(idProduct));
//			Item item = new Item();
//			item.setProduct(product);
//			var itemSalved = item.saveItem(item, 1);
//			ShoppingBasket shpBk = new ShoppingBasket();
//			var basket = shpBk.addItem(itemSalved, user);
			
			Item testItem = new Item();
			testItem.setAmount(1);
			testItem.setIdItem(2);
			testItem.setProduct(product);
			ShoppingBasket sh = new ShoppingBasket();
			sh.setDataCreated("28/09/2022");
			sh.setIdBasket(22);
			sh.setActive(true);
			sh.setUser(user);
			List<Item> its = new ArrayList<>();
			its.add(testItem);
			sh.setList(its);
			session.setAttribute("shoppingBasket", sh);
			
//			session.setAttribute("shoppingBasket", basket);
			RequestDispatcher dispatcher = request.getRequestDispatcher("shoppingBasket.jsp");
			request.setAttribute("message", "Product add in shopping basket");
			dispatcher.forward(request, response);
		}else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("shopProduct.jsp");
			dispatcher.forward(request, response);
		}
		
		doGet(request, response);
	}

}
