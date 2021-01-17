package com.project.webapp.utility;

import java.sql.Connection;

public class ConnectionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Connection connection1 = DbConnection.getConnection();
		Connection connection2 = DbConnection.getConnection();
		Connection connection3 = DbConnection.getConnection();
		
		if(connection1 != null)
			System.out.println( "Connection1 received..");
		else
			System.out.println( "Connection1 does not received..");
		
		if(connection2 != null)
			System.out.println( "Connection2 received..");
		else
			System.out.println( "Connection2 does not received..");
		
		if(connection3 != null)
			System.out.println( "Connection3 received..");
		else
			System.out.println( "Connection3 does not received..");

	}

}
