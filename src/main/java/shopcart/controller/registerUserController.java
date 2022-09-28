package shopcart.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.buf.StringUtils;

import shopcart.model.Type;
import shopcart.model.UserStore;

/**
 * Servlet implementation class registerUserController
 */
@WebServlet("/registerUserController")
public class registerUserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public registerUserController() {
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String message;
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("registerUser.jsp");
		
		var name = request.getParameter("name");
		var balance = request.getParameter("balance");
		var password = request.getParameter("password");
		var admin = request.getParameter("admin");
		
		if((name != null && !name.isEmpty())
				&&(balance != null && !balance.isEmpty())
				&&( password != null && !password.isEmpty())) {
			
			
			UserStore user = new UserStore();
			user.setName(name);
			user.setPassword(password);
			
			if(admin != null && admin.equals("on")) {
				user.setType(Type.ADMIN);
			}else {
				user.setType(Type.COMMON);
			}
			if(balance!= null && !balance.isEmpty()) {
				
				try {
					user.setBalance(Double.valueOf(balance));
				} catch (Exception e) {
					
					user.setBalance(Double.valueOf("0.0"));
				}
				
			}
			
			if(user.saveUser(user)) {
				
				message = "User saved successfully";
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
