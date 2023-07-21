package com.project.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.project.dao.UserDao;
import com.project.dto.UserDTO;
import com.project.utility.DbConnection;

public class UserDaoMysqlImpl implements UserDao {
	
	private Connection connection = null;
	private PreparedStatement preparedStatement = null;

	@Override
	public boolean saveUser(UserDTO user) {
		try {
			connection = DbConnection.estabishConnection();
			preparedStatement = connection.prepareStatement("insert into "
					+ "tbl_user(first_name,last_name,email,password,address) values(?,?,?,?,?)");
			preparedStatement.setString(1, user.getFirstName());
			preparedStatement.setString(2, user.getLastName());
			preparedStatement.setString(3, user.getEmail());
			preparedStatement.setString(4, user.getPassword());
			preparedStatement.setString(5, user.getAddress());
			
			int rows = preparedStatement.executeUpdate();
			if(rows>0) {
				return true;
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	@Override
	public boolean updateUser(UserDTO user) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteUser(int userId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public UserDTO searchUser(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
