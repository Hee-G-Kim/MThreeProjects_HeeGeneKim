package com.mthree;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;


/**
 * Servlet implementation class LoginServelet
 */
//@WebServlet("/auth" )
public class LoginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
          public LoginServelet() {
                   System.out.println("Inside default constructor of LoginServelet");
          }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         System.out.println("Inside doget LoginServelet");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         System.out.println("Inside dopost LoginServelet");
		  String uname=  request.getParameter("username");
		  String pwd = request.getParameter("password");
		  System.out.println("Data coming from clinet "+uname + " "+pwd);
		  
//		  ServletConfig config = getServletConfig();
//		  String user=config.getInitParameter("username");
//		  String passwd=config.getInitParameter("password");
//		  System.out.println("Data configured in servlet confif is "+user + " "+passwd);
		
		  ServletContext context = getServletContext();
	             String user=context.getInitParameter("username");
	                  String passwd=context.getInitParameter("password");
	                  System.out.println("Data configured in servlet config is and trying to retrieve "
	                                    + "in Helloservelet "+ user + " "+passwd);
		  
		  
		  
//		  PrintWriter writer = response.getWriter();
//		  writer.println("<html>");
//		  writer.println("<header><title>Login Result</title></header>");
//		  writer.println("<body>");
	                  
	                  

//-------------	              
	      int items = (int)context.getAttribute("tshirts");
	      System.out.println(items);         
	                  
		  if(uname.equals(user) && pwd.equals(passwd)) {
		           RequestDispatcher rd = request.getRequestDispatcher("/success.jsp");
                       rd.forward(request,response);
//		           writer.println("Login successful");
//		           writer.println("<p>Welcome" +uname + "</P>");
		  }else {
		           //writer.println("Login unsuccessful");
		           RequestDispatcher rd = request.getRequestDispatcher("/error.jsp");
		           rd.forward(request,response);
		  }
		  
//		  
////		  writer.println("</form>");
//		  writer.println("</body>");
//		  writer.println("</html>");
	}

}
