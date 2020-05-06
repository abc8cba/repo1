package com.project.webapp.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;

import com.project.webapp.dao.LoginDao;
import com.project.webapp.dao.impl.LoginDaoImpl;
import com.project.webapp.utility.IUtil;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		System.out.println("Method = "+method);
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		HttpSession session = request.getSession();
		String csrfToken = (String)session.getAttribute("csrfToken");
		String csrfTokenReq = request.getParameter("csrfToken");
		System.out.println("------------Inside LoginController------------------");
		System.out.println("Session Token = "+csrfToken);
		System.out.println("Request Token = "+csrfTokenReq);
		if(method.equals("authenticateUser")){
			if(StringUtils.isNotEmpty(username) && StringUtils.isNotBlank(password)){
				
				LoginDao loginDao = new LoginDaoImpl();
				boolean b = loginDao.authenticateUser(username,password);
				if(b==true){
					session.invalidate();
					HttpSession newSession = request.getSession();
					String jsessionId = newSession.getId();
					System.out.println("Jsession Id = "+jsessionId);
					Cookie cookie = new Cookie(jsessionId, "abcde");
					cookie.setSecure(true);
					cookie.setMaxAge(24*60*30);
					response.addCookie(cookie);
					newSession.removeAttribute("jsessionId");
					newSession.setAttribute("sessionId", "xyzpqr");
					csrfToken = IUtil.getRandomNumber();
					newSession.setAttribute("csrfToken", csrfToken);
					request.setAttribute("csrfTokenReq", csrfToken);
					request.setAttribute("msg", "Welcome to Dashboard");
					request.getRequestDispatcher("dashboard.jsp").forward(request, response);
				}else{
					csrfToken = IUtil.getRandomNumber();
					session.setAttribute("csrfToken", csrfToken);
					request.setAttribute("csrfTokenReq", csrfToken);
					String error = "Username or password incorrect";
					request.setAttribute("error", error);
					request.getRequestDispatcher("login.jsp").forward(request, response);
				}
			}else{
				csrfToken = IUtil.getRandomNumber();
				session.setAttribute("csrfToken", csrfToken);
				request.setAttribute("csrfTokenReq", csrfToken);
				String error = "Username or password incorrect can't blank";
				request.setAttribute("error", error);
				request.getRequestDispatcher("login.jsp").forward(request, response);
			}
		}
		
		if(method.equals("logout")){
			session.invalidate();
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		if(method.equals("forgot_password")){
			session.invalidate();	
			csrfToken = IUtil.getRandomNumber();
			HttpSession newSession = request.getSession();
			System.out.println("------------Inside LoginController------------------");
			System.out.println("------------method forgot_password------------------");
			newSession.setAttribute("csrfToken", csrfToken);
			request.setAttribute("csrfTokenReq", csrfToken);
			System.out.println("Session Token = "+csrfToken);
			System.out.println("Request Token = "+csrfToken);
			request.getRequestDispatcher("forgot_password.jsp").forward(request, response);
		}
		
		if(method.equals("change_password")){
			String pass = request.getParameter("new_pass");
			String con_pass = request.getParameter("conf_new_pass");
			if(pass.equals(con_pass) && StringUtils.isNotBlank(pass)){
				System.out.println("password matched");
			}
			else{
				System.out.println("Change_password method");
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
