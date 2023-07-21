package com.project.service;

import com.project.dto.UserDTO;

public interface UserService {
	
	boolean saveUser(UserDTO user);
	boolean updateUser(int userId);
	boolean deleteUser(int userId);
	
	UserDTO searchUser(int userId);

}
