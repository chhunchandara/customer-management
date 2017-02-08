package servlet;

import java.io.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;

public class CLS_CUSTOMER extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try
		{
			HttpSession session=request.getSession(false);
			if (session.getAttribute("uname") == null )
				{
				return;
				}; 
		
		
		response.setContentType("text/html");
		 PrintWriter out = response.getWriter();
		 out.println("<h1> INFORMATION </h1>");
		 out.println("<form action='/add.jsp'>");
		 out.println("<input type='submit' value='Add New' />");
		 out.println("</form>");
		 
		 	
		 List<C_CUSTOMER> myList1 = new ArrayList<C_CUSTOMER>();
		 
		 out.println("<table border=1 style='border-collapse: collapse; ' ><th>ID</th><th>First Name</th><th>Last Name</th><th>Gender</th><th>Email Address</th><th>Date of Birth</th><th>Address</th><th>Phone Number</th><th>Create Date</th><th>Update Date</th><th>Action</th>");
		 myList1 = select_customer();
		 for (int i = 0; i < myList1.size(); i++) {
			 out.println("<tr>");
			 	out.println("<td>");
			 		out.println(myList1.get(i).get_cus_id());
				out.println("</td>");
				
			 	out.println("<td>");
		 			out.println(myList1.get(i).get_cus_first_name());
		 		out.println("</td>");

			 	out.println("<td>");
	 				out.println(myList1.get(i).get_cus_last_name());
	 			out.println("</td>");

			 	out.println("<td>");
		 			out.println(myList1.get(i).get_cus_gender());
		 		out.println("</td>");
			
		 		out.println("<td>");
	 				out.println(myList1.get(i).get_cus_email_address());
	 			out.println("</td>");

	 			out.println("<td>");
 					out.println(myList1.get(i).get_cus_DOB());
 				out.println("</td>");	 			

			 	out.println("<td>");
 					out.println(myList1.get(i).get_cus_address());
 				out.println("</td>");
		
	 			out.println("<td>");
 					out.println(myList1.get(i).get_cus_phoneNumber());
 				out.println("</td>");

 				out.println("<td>");
 				out.println(myList1.get(i).get_date_created());
 				/*
 				try{
 					SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					out.println(formatter.format(myList1.get(i).get_date_created()));
 				}catch (Exception e){
 					
 				}*/
				out.println("</td>");	
				
 				out.println("<td>");
 					out.println(myList1.get(i).get_date_updated());
 				out.println("</td>");
 				out.println("<td>");
 					out.println("<a href='/update.jsp?"+ myList1.get(i).get_onecus() +"'>Update</a>");
 					out.println("<a href='/delete?id="+ myList1.get(i).get_cus_id() +"'>Delete</a>");
				out.println("</td>");
		     out.println("</tr>");
		 }
		 out.println("</table>");
	}
		 catch(Exception e)
			{}
	}
	public List<C_CUSTOMER> select_customer(){
		 List<C_CUSTOMER> myList = new ArrayList<C_CUSTOMER>();
		 try
		 {
			 CLS_MYSQLDB obj = new CLS_MYSQLDB();
			 Connection conn = obj.get_connection();
			 String sql="SELECT * from td_customer" ;
			 PreparedStatement statement = conn.prepareStatement(sql);
			 ResultSet result = statement.executeQuery();
			  
			 
			 while (result.next()){
				 C_CUSTOMER c = new C_CUSTOMER();
				 c.set_cus_id(result.getInt(1));
				 c.set_cus_first_name(result.getString(2));
				 c.set_cus_last_name(result.getString(3));
				 c.set_cus_gender(result.getString(4));
				 c.set_cus_email_address(result.getString(5));
				 c.set_cus_DOB(result.getDate(6));
				 c.set_cus_address(result.getString(7));
				 c.set_cus_phoneNumber(result.getString(8));
				 try
				 {
					 c.set_date_created(result.getDate(9));
					 c.set_date_updated(result.getDate(10));
				 }
				 catch(Exception e){
					 
				 }
				 myList.add(c);
			 	}
			 conn.close();
		 }
		 catch (Exception e)
		 {
			 System.out.println(e.toString());
	     }
		 return myList;
	}

}
