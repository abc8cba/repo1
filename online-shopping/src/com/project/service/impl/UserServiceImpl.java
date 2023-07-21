package com.project.service.impl;

import java.util.Scanner;

import com.project.dao.UserDao;
import com.project.dao.impl.UserDaoImpl;
import com.project.dao.impl.UserDaoMysqlImpl;
import com.project.dto.UserDTO;
import com.project.service.UserService;

public class UserServiceImpl implements UserService {
	
	//private UserDao userDao = new UserDaoImpl();
	private UserDao userDao = new UserDaoMysqlImpl();

	@Override
	public boolean saveUser(UserDTO user) {		
		boolean status = userDao.saveUser(user);
		return status;
	}

	@Override
	public boolean updateUser(int userId) {
		if(userId != 0) {
			UserDTO user = searchUser(userId);
			System.out.println("Before Update: "+user);
			Scanner s = new Scanner(System.in);
			System.out.println("Enter first name");
			String firstName = s.next();			
			
			System.out.println("Enter last name");
			String lastName = s.next();			
			
			System.out.println("Enter email name");
			String email = s.next();			
			
			System.out.println("Enter password");
			String password = s.next();			
			
			System.out.println("Enter address");
			String address = s.next();
			
			if(user != null) {
				user.setFirstName(firstName);
				user.setLastName(lastName);
				user.setEmail(email);
				user.setPassword(password);
				user.setAddress(address);
			}
			s.close();
			System.out.println("After Update: "+user);
			userDao.updateUser(user);
			
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		return false;
	}

	@Override
	public UserDTO searchUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
