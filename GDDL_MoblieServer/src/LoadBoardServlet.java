

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import java.util.ArrayList;

@WebServlet("/LoadBoardServlet")
public class LoadBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<Board_Module> OrderOnBoard = new ArrayList<Board_Module>();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Order = gson.toJson(OrderOnBoard);
		response.getWriter().append(Order);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	
		OrderOnBoard=new BoardDAO().LoadBoard();
		doGet(request,response);
	}
	
	

}
