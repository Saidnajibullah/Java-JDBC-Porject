package com.personal.project.loginServlet;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.personal.project.authService.AuthService;
/*
 * Browser sends Http Request to Web Server
 * 
 * Code in Web Server => Input:HttpRequest, Output: HttpResponse
 * JEE with Servlets
 * 
 * Web Server responds with Http Response
 */

//Java Platform, Enterprise Edition (Java EE) JEE6

//Servlet is a Java programming language class 
//used to extend the capabilities of servers 
//that host applications accessed by means of 
//a request-response programming model.

//1. extends javax.servlet.http.HttpServlet
//2. @WebServlet(urlPatterns = "/login.do")
//3. doGet(HttpServletRequest request, HttpServletResponse response)
//4. How is the response created?

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
//		PrintWriter out = response.getWriter();
//		out.println("<html>");
//		out.println("<head>");   
//		out.println("<title>Yahoo!!!!!!!!</title>");
//		out.println("</head>");
//		out.println("<body>");
//		out.println("My First Servlet");  
//		out.println("</body>");
//		out.println("</html>");
//		String username = request.getParameter("name");
//		request.setAttribute("name", username);
		request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);

	}
	     
	@Override  
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException{
		String username = request.getParameter("name");
		String password = request.getParameter("password");       
		AuthService auth = new AuthService();
		boolean authentication = auth.isNameAndPasswordValid(username, password);
		if(authentication) {
			request.setAttribute("name", request.getParameter("name"));
			request.getSession().setAttribute("name", username);
//			TodoService todo = new TodoService();   
//			request.setAttribute("todos", todo.getTodos());
//     		request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response); 
			response.sendRedirect("/welcome.jsp");
		}else {
			request.setAttribute("name", "wrong");       
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response); 
		}
		 
		
	}    
  
}