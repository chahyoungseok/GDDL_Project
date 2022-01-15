

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/ShowUserInfoServlet")
public class ShowUserInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	User_Module ShowInfo = new User_Module();


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String parsedInfo = gson.toJson(ShowInfo);
		response.getWriter().append(parsedInfo);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");		
		String Access = request.getParameter("AccessInfoByID");
			
		ShowInfo = new userDAO().LoadUserInfo(Access);
		doGet(request, response);
	}

}
