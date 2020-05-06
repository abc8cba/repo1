package com.project.webapp.controller;

import java.io.IOException;
import java.security.SecureRandom;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.RandomStringUtils;


@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String csrfValue = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
		//String csrfValue = RandomStringUtils.randomAlphanumeric(20);
		HttpSession session = request.getSession();
		session.setAttribute("csrfToken", csrfValue);
		request.setAttribute("csrfTokenReq", csrfValue);
		System.out.println("----Inside HomeController------");
		System.out.println("Session Token = "+csrfValue);
		System.out.println("Request Token = "+csrfValue);
		request.getRequestDispatcher("login.jsp").forward(request, response);
	}
	
}
