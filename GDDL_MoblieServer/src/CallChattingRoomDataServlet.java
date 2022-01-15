
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/CallChattingRoomDataServlet")
public class CallChattingRoomDataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ArrayList<ServerModule> chattingList;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		String Order = gson.toJson(chattingList);
		response.getWriter().append(Order);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userID = request.getParameter("userID");
		String otherID = request.getParameter("otherID");
		chattingList = new ArrayList<ServerModule>();
		chattingList = new ChatDAO().getChattingRecord(userID,otherID);
		doGet(request, response);
	}

}
