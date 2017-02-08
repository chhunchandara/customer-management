package servlet;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.*;
import javax.servlet.http.*;


public class CLS_LOGIN extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
		//response.setContentType("text/html");  
       // PrintWriter out = response.getWriter();  
          
        //HttpSession session=request.getSession(false); 
      //  if (null==request.getSession(false)){
     //   	out.println("No Session");
    //    }
     //   else{
        	//out.println(session.toString());
     //   }
        
        
       // HttpSession session=request.getSession(); 
      //  session.setAttribute("uname","dara");  
  
      //  out.println(session.getAttribute("uname").toString());
	}
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{	
	
		if( request.getParameter("username").toString().equals("admin") && request.getParameter("password").toString().equals("adminPassword") )
		{//&& request.getParameter("password").toString() =="123456"
			 PrintWriter out = response.getWriter();
		     //out.println("Welcome " + request.getParameter("username") + " !") ;
			 
			 HttpSession session=request.getSession(true);
			 session.setAttribute("uname", request.getParameter("username").toString());  
			 response.sendRedirect("CLS_CUSTOMER");
		}	
		else {
			PrintWriter out = response.getWriter();
		     //out.println("Login fail!") ;
			
		     response.sendRedirect("index.jsp?login=false");
		/*     try {
		    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		    	Date DOB = formatter.parse("1998-06-20"); 
		    	C_CUSTOMER d = new C_CUSTOMER("Chhun", "Theary", "Female", "chhuntheary@gmail.com", DOB, "Phnom Penh", "09767676");
		        d.insert_customer ();
		        
		        d.update_customer(1);
		        
		        d.delete_customer(6);
		        d.select_customer(0);
		     } catch (Exception e) {
		         e.printStackTrace();
		     }
		 */
		}
	}
	
	
}
