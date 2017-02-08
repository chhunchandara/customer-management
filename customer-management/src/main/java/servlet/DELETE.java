package servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DELETE extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		C_CUSTOMER obj = new C_CUSTOMER();
		obj.set_cus_id(Integer.parseInt(request.getParameter("id")));
		obj.delete_customer();
		response.sendRedirect("/CLS_CUSTOMER");
	}
}
