package com.personal.project.logoutService;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet(urlPatterns = "/logout.jsp")
public class LogoutServlet extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
       throws ServletException, IOException{
       request.getSession().invalidate();
       request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(request, response);
    }
}
