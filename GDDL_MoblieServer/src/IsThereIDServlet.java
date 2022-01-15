

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/IsThereIDServlet")
public class IsThereIDServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int confirmState = 1;  

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String parsedIDRegisterData = gson.toJson(confirmState);
		response.getWriter().append(parsedIDRegisterData);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String inputID = request.getParameter("inputID");	
		compareID(inputID);
		
		System.out.println(inputID+" is "+confirmState);
		doGet(request,response);

	}
	public void compareID(String inputID){
		String DB_ID = new userDAO().CheckID(inputID);
		if(DB_ID.equals(inputID)) {
			confirmState= 1;
		}
		else {
			confirmState= 0;
		}
	}
}
