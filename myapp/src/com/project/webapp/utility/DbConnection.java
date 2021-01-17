package com.project.webapp.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
	
	private static Connection con = null;
	
	private DbConnection(){
		con = makeConnection();
	}
	
	public static Connection makeConnection(){
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con  = DriverManager.getConnection("jdbc:mysql://localhost:3306/sandydb", "sandy", "sandy");
			System.out.println("Connection created....");
			return con;
		}catch(Exception e){
			System.out.println("Something went wrong!! Connection does not eastablished..");
			e.printStackTrace();
		}
		return null;
	}
	
	// static method to create instance of Singleton class 
    public static Connection getConnection() 
    { 
        if (con == null) {
        	System.out.println("-----------------------------------------------------");
        	new DbConnection(); 
    		System.out.println("default contructor called...");
        	System.out.println("-----------------------------------------------------");
        }
        else
        	System.out.println("Connection alredy exist..");
  
        return con; 
    } 
}
