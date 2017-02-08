package servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ADD extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try
		{	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			Date dbo1 = formatter.parse(request.getParameter("dob"));
		C_CUSTOMER obj = new C_CUSTOMER(
										request.getParameter("fname"), 
										request.getParameter("lname"), 
										request.getParameter("gender"), 
										request.getParameter("email"),
										dbo1, 
										request.getParameter("address"), 
										request.getParameter("phone")
										);
		
		obj.insert_customer();
		response.sendRedirect("/CLS_CUSTOMER");
		}
		catch(Exception e)
		{
			System.out.println(e.toString());
		}
	}
}
