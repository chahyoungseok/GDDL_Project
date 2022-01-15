

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/OrderCancelServlet")
public class OrderCancelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	String tmp = "";
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        tmp = request.getParameter("@@Cancel");
        System.out.println("doPost"+tmp);
        new BoardDAO().CancelOrder(tmp);
        doGet(request, response);
    }

}
