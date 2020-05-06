package com.project.webapp.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.project.webapp.dao.LoginDao;
import com.project.webapp.model.UserInfo;
import com.project.webapp.utility.DbConnection;

public class LoginDaoImpl implements LoginDao {

	@Override
	public boolean authenticateUser(String username, String password) {
		try(Connection con = DbConnection.makeConnection();
			PreparedStatement ps = con.prepareStatement("select * from user_details where email_id=? and password=?")) {
				
				ps.setString(1, username);
				ps.setString(2, password);
				ResultSet rs = ps.executeQuery();
				if(rs.next()){
					return true;			
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		
			return false;
	}

}
