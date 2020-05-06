package com.project.webapp.controller;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns = {"/LoginController" ,"/UserController"}, filterName = "FilterCsrfToken" )
public class FilterCsrfToken implements Filter {


	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("Before servlet");
		HttpServletRequest req = (HttpServletRequest)request;
		HttpSession session = req.getSession();
		String csrfToken = (String)session.getAttribute("csrfToken");
		String csrfTokenReq = request.getParameter("csrfToken");
		System.out.println("------------Inside Filter------------------");
		System.out.println("Session Token = "+csrfToken);
		System.out.println("Request Token = "+csrfTokenReq);
		if(csrfToken.equals(csrfTokenReq)){
			chain.doFilter(request, response);
			System.out.println("After servlet");
		}
		else{
			req.setAttribute("error", "Security issue, csrf token mismatch");
			session.invalidate();
			System.out.println("Session invalidated...");
			req.getRequestDispatcher("login.jsp").forward(req, response);
		}
		
		
	}

}
