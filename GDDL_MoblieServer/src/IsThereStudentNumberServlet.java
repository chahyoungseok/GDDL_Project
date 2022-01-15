

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;


@WebServlet("/IsThereStudentNumberServlet")
public class IsThereStudentNumberServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public int confirmState = 1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String parsedStudentNumber = gson.toJson(confirmState);
		response.getWriter().append(parsedStudentNumber);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String InputStudentNumber = request.getParameter("InputStudentNumber");
		compareStudentNumber(InputStudentNumber);
		
	    doGet(request, response);
	}
	public void compareStudentNumber(String inputStudentNumber){
		String DB_StuentNumber = new userDAO().CheckStudentNumber(inputStudentNumber);
		if(DB_StuentNumber.equals(inputStudentNumber)){
			confirmState= 1;
		}
		else {
			confirmState= 0;
		}
	}
}
