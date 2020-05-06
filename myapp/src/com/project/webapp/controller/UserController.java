package com.project.webapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.lang.*;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.project.webapp.dao.UserDao;
import com.project.webapp.dao.impl.UserDaoImpl;
import com.project.webapp.model.Address;
import com.project.webapp.model.Name;
import com.project.webapp.model.UserInfo;
import com.project.webapp.utility.DbConnection;

@WebServlet("/UserController")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String method = request.getParameter("method");
		System.out.println("Method = "+method);
		String message = null;
		if(method.equals("saveRecord")){
			
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String area = request.getParameter("areaname");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String confirmPassword = request.getParameter("cnfpass");
			UserInfo user = new UserInfo(new Name(fname,lname), new Address(country, state, city, pincode), 
					contact, area, email, password, confirmPassword);
			
			UserDao userDao = new UserDaoImpl();
			boolean b = userDao.save(user);
			if(b==true){
				message = "Data saved.";
				request.setAttribute("msg", message);
				request.getRequestDispatcher("signup.jsp").forward(request, response);
				//response.sendRedirect("signup.jsp");
			}
			else
				message = "Failed to save data.";
			    request.setAttribute("error", message);
			    request.getRequestDispatcher("signup.jsp").forward(request, response);
				//response.sendRedirect("error.jsp");
			
		}
		if(method.equals("updateRecord")){
			int id = Integer.parseInt(request.getParameter("id"));
			String fname = request.getParameter("firstname");
			String lname = request.getParameter("lastname");
			String country = request.getParameter("country");
			String state = request.getParameter("state");
			String city = request.getParameter("city");
			String pincode = request.getParameter("pincode");
			String area = request.getParameter("areaname");
			String contact = request.getParameter("contact");
			String email = request.getParameter("email");
			String password = request.getParameter("pass");
			String confirmPassword = request.getParameter("cnfpass");
			
			UserInfo user = new UserInfo(new Name(fname,lname), new Address(country, state, city, pincode), 
					contact, area, email, password, confirmPassword);
			UserDao userDao = new UserDaoImpl();
			userDao.update(user);
			
		}
		if(method.equals("deleteRecord")){			
			int id = Integer.parseInt(request.getParameter("id"));
			UserDao dao = new UserDaoImpl();
			dao.delete(id);			
		}
		
		if(method.equals("getData")){			
			int id = Integer.parseInt(request.getParameter("id"));
			UserDao dao = new UserDaoImpl();
			UserInfo user = dao.getUserData(id);
			request.setAttribute("userdata", user);
			request.getRequestDispatcher("update.jsp").forward(request, response);			
		}
		
		if(method.equals("loadCountry")){
			System.out.println("From loadCountry method");
			UserDao dao = new UserDaoImpl();
			String json = dao.getAllCountry();
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("loadState")){
			System.out.println("From loadState method");
			String countryName = request.getParameter("country_name");
			UserDao dao = new UserDaoImpl();
			String json = dao.getState(countryName);
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("loadCity")){
			System.out.println("From loadCity method");
			String stateName = request.getParameter("state_name");
			UserDao dao = new UserDaoImpl();
			String json = dao.getCity(stateName);
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
		if(method.equals("showAll")){
			UserDao dao = new UserDaoImpl();
			String json = dao.showAll();
			response.setContentType("application/json");	
			response.setCharacterEncoding("UTF-8");
			PrintWriter out= response.getWriter();
			out.println(json);
			out.close();
		}
	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doPost(request, response);
	}

}
