package com.project.utility;

import java.sql.Connection;

public class TestConnection {

	public static void main(String[] args) {
		Connection con = DbConnection.estabishConnection();
		if(con != null) {
			System.out.println("Connected..");
		}else {
			System.out.println("Not Connected..");
		}

	}

}
