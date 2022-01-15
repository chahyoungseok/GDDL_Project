

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/LoadOwnOrdersServlet")
public class LoadOwnOrdersServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ArrayList<Board_Module> UserOwnOrders = new ArrayList<Board_Module>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String OwnOrder = gson.toJson(UserOwnOrders);
		response.getWriter().append(OwnOrder);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		UserOwnOrders = new BoardDAO().LoadOwnBoard(request.getParameter("UserOwnOrders"));
		doGet(request, response);
	}

}
