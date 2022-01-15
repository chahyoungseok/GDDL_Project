

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/EditProgressSevlet")
public class EditProgressSevlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	String progress ="";
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		System.out.println(progress);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		response.getWriter().append(gson.toJson(progress));
		
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		System.out.println(request.getParameter("ErrandUserID"));
		System.out.println(request.getParameter("@@Ongoing"));
		
		progress = new BoardDAO().EditProgress(
				Integer.parseInt(request.getParameter("@@Ongoing")),
				request.getParameter("ErrandUserID"));
		doGet(request, response);
	}

}
