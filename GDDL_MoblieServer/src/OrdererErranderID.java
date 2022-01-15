

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/OrdererErranderID")
public class OrdererErranderID extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ChatModule chatModule = new ChatModule();
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String ID = gson.toJson(chatModule);
		response.getWriter().append(ID);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("InputIDForChat");
		chatModule = new ChatlistDAO().getID(userID);
		
		doGet(request, response);
	}

}
