

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/NotifySenderServlet")
public class NotifySenderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	public ArrayList<Notify_Module> notiArray = new ArrayList<Notify_Module>();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String notifyString = gson.toJson(notiArray);
		response.getWriter().append(notifyString);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		notiArray = new NotifyDAO().LoadNotify();
		doGet(request, response);
	}

}
