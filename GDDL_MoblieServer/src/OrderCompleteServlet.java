

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/OrderCompleteServlet")
public class OrderCompleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        new BoardDAO().OrderCompleted(Integer.parseInt(request.getParameter("UserOwnOrders")));
        
        String orderID = request.getParameter("orderID");
        String errandID = request.getParameter("errandID");
        
        new ChatDAO().updateAlive(orderID, errandID);
        new ChatlistDAO().removeChattingRoom(orderID,errandID);
		doGet(request, response);
	}

}
