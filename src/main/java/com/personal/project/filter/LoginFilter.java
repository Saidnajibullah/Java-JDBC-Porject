package com.personal.project.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = "*.jsp")
public class LoginFilter implements Filter{

	@Override
	public void destroy() {
		
	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		HttpServletRequest request = (HttpServletRequest) req;
		if(request.getSession().getAttribute("name") != null) {
			chain.doFilter(req, resp);
		}else {
			request.getRequestDispatcher("WEB-INF/views/login.jsp").forward(req, resp);
		}
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		
	}


}
