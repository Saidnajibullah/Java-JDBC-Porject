package com.personal.project.welcomeServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.personal.project.authService.TodoService;
import com.personal.project.model.Todo;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/welcome.jsp")
public class WelcomeServlet extends HttpServlet{
	
	TodoService todo = new TodoService(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException{
		String id = request.getParameter("id");
			if(id == null) {
				request.setAttribute("todos", todo.getTodos());
		 		request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response); 
			}else {
				todo.deleteTodo(Integer.valueOf(id));
				request.setAttribute("todos", todo.getTodos());
				System.out.println(id);
				//response.sendRedirect("/welcome.jsp");
				request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response); 
			}
		
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	    throws ServletException, IOException{
		String name = request.getParameter("name");
		String task = request.getParameter("task");
		todo.addTodo(new Todo(name, task));
		request.setAttribute("todos", todo.getTodos());
		// forwarding to the same page causes the same request to be done multiple times which leads to data duplication
// 		request.getRequestDispatcher("WEB-INF/views/welcome.jsp").forward(request, response); 
		response.sendRedirect("/welcome.jsp");
	}

}
