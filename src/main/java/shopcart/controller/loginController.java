package shopcart.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.jasper.xmlparser.SymbolTable;

import shopcart.model.Type;
import shopcart.model.UserStore;

/**
 * Servlet implementation class loginController
 */
@WebServlet("/loginController")
public class loginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginController() {
        super();
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@SuppressWarnings("null")
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		var login = request.getParameter("login");
		var userName = request.getParameter("name");
		var password = request.getParameter("password");
		String message;
		UserStore user = null;
		HttpSession session = request.getSession();
		if((login != null && !login.isEmpty())
				&&(userName!= null && !userName.isEmpty())
				&&(password!= null && !password.isEmpty())) {
			
			user = new UserStore().userStoreAuthenticate(userName,password);
			
			if(user !=null) {
				
		        
				RequestDispatcher dispatcher;
				if(user.getType().equals(Type.ADMIN)) {
					dispatcher = request.getRequestDispatcher("searchProduct.jsp");
				}else {
					dispatcher = request.getRequestDispatcher("shopProduct.jsp");
				}
				
				session.setAttribute("userlogin", user);
				request.setAttribute("user",user);
				request.setAttribute("userId",user.getIdUser());
				request.setAttribute("userType", user.getType());
				dispatcher.forward(request, response);
			
			}else {
				RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
				message = "User not found";
				request.setAttribute("message", message);
				dispatcher.forward(request, response);
			}
				
		}else if(login != null && !login.isEmpty()) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("login.jsp");
			request.setAttribute("message", "All filds are requered");
			dispatcher.forward(request, response);

		}
		
	}

}
