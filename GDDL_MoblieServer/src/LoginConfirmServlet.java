

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/LoginConfirmServlet")
public class LoginConfirmServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int confirmState = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String parsedLoginData = gson.toJson(confirmState);
		response.getWriter().append(parsedLoginData);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String userID = request.getParameter("userID");
	    String userPassword = request.getParameter("userPassword");
	    System.out.println(userID+" / "+userPassword);
	    
	    comparePassword(userID,userPassword);
	    doGet(request, response);
	}
	public void comparePassword(String userID, String userPassword){
		String DB_pass = new userDAO().searchPassword(userID);
		System.out.println(DB_pass);
		if(DB_pass.equals(userPassword)){
			confirmState= 1;
		}
		else {
			confirmState= 0;
		}
	}

}
