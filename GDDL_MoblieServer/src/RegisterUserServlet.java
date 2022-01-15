

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	User_Module user = new User_Module();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String r_userID = request.getParameter("Regi_id");
		String r_userPass = request.getParameter("Regi_pass");
		String r_userName = request.getParameter("Regi_name");
		String r_userMajor = request.getParameter("Regi_major");
		String r_userSchoolNumber = request.getParameter("Regi_school_number");
		String r_userGender = request.getParameter("Regi_gender");
		
		user.setUserId(r_userID);
		user.setUserPass(r_userPass);
		user.setUserName(r_userName);
		user.setUserMajor(r_userMajor);
		user.setUserSchoolNumber(r_userSchoolNumber);
		user.setUserGender(r_userGender);
		
		new userDAO().RegisterUser(user);
		doGet(request, response);
	}

}
