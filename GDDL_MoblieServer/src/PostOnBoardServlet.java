

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PostOnBoardServlet")
public class PostOnBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	Board_Module board_module;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		board_module= new Board_Module();
//		board_module.setO_number(Integer.parseInt(request.getParameter("Post_o_number")));
//		board_module.setO_time(request.getParameter("Post_o_time"));
		board_module.setOrders(request.getParameter("Post_orders"));
//		board_module.setErrand(request.getParameter("Post_errand"));
		board_module.setTitle(request.getParameter("Post_title"));
		board_module.setText(request.getParameter("Post_text"));
		board_module.setLatitude(Double.parseDouble(request.getParameter("Post_latitude")));
		board_module.setLongitude(Double.parseDouble(request.getParameter("Post_longitude")));
		board_module.setDetail_address(request.getParameter("Post_address"));
		board_module.setPrice(Integer.parseInt(request.getParameter("Post_price")));
		board_module.setProgress(request.getParameter("Post_progress"));
			
		new BoardDAO().PostOnBoard(board_module);
		doGet(request, response);
	}

}
