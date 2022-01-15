

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/CustomReportServlet")
public class CustomReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Custom_Module custom_module;
    

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		custom_module = new Custom_Module();
		custom_module.setReporter(request.getParameter("Reporter"));
		custom_module.setTitle(request.getParameter("Title"));
		custom_module.setCheck_content(request.getParameter("CheckContent"));
		custom_module.setContent(request.getParameter("Content"));
		custom_module.setDefandant(request.getParameter("defendant"));
		
		new CustomCareDAO().Report(custom_module);
		doGet(request, response);
	}

}
