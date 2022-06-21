package com.mthree;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;



/**
 * Servlet implementation class HelloServelet
 */
//@WebServlet("/login")
public class HelloServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HelloServelet() {
        super();
        System.out.println("Inside default constructor of HelloServelet");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    
    
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Inside doGet of HelloServelet");
		System.out.println("Welcome from Billy");
		
//		ServletConfig config = getServletConfig();
//            String user=config.getInitParameter("username");
//            String passwd=config.getInitParameter("password");
//            System.out.println("Data configured in servlet config is and trying to retrive 
//		in login servelet "+user + " "+passwd);
		
		ServletContext context = getServletContext();
		 String user=context.getInitParameter("username");
	            String passwd=context.getInitParameter("password");
	            System.out.println("Data coming from client "
	                              + "in Helloservelet "+ user + " "+passwd);
		
//-------------	 	   
	    //request.setAttribute("tshirts", 5);
	    context.setAttribute("tshirts", 6);
	            
//		String name= request.getParameter("uname");
//		System.out.println("name retreived from " +name);
		
	    PrintWriter out = response.getWriter();
		RequestDispatcher rd = request.getRequestDispatcher("/loginform.jsp");
		rd.forward(request,response);
	}

	
	
	
	
	@Override
         public void init() throws ServletException {
                 
         }

         /**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	         System.out.println("Inside doPost of HelloServelet");
		doGet(request, response);
	}

         @Override
         public void destroy() {
                  System.out.println("Inside destroy of HelloServelet");
                  super.destroy();
         }

}

//out.println("<HTML><header><title>LoginPage</title></header><body><h1>Hello from " 
//+ name"</h1></body></HTML>");
//String loginhtml = "<HTML><header><title>LoginPage</title></header>"
//                  + "<body><h1>Hello from \" + name\"</h1></body>"
//                  + "</HTML>";

//out.println("<html>");
//out.println("<header><title>LoginPage</title></header>");	
//out.println("<body>");
//out.println("<form method='post' action='auth'>");
//out.println("Enter Username : <input type='text' name='username'/><br>");
//out.println("Enter Password : <input type='password' name='password'/><br>");
//out.println("<input type='submit' value='Submit'/>");
//out.println("</form>");
//out.println("</body>");
//out.println("</html>");