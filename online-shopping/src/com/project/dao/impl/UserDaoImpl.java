package com.project.dao.impl;

import java.util.ArrayList;
import java.util.List;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;

public class UserDaoImpl implements UserDao{
	
	private List<UserDTO> users = new ArrayList<>();

	@Override
	public boolean saveUser(UserDTO user) {		
		if(user != null) {
			users.add(user);
			//System.out.println(users);
			for(UserDTO u : users) {
				System.out.println(u);
			}
			return true;
		}
		return false;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		if(user != null) {
			//update user to database
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		return false;
	}

	@Override
	public UserDTO searchUser(int userId) {
		for(UserDTO user : users) {
			if(userId != 0) {
				if(userId == user.getUserId()) {
					System.out.println(user);
					return user;
				}
			}
		}		
		
		return null;
	}

}
