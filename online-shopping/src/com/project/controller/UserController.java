package com.project.controller;

import java.util.List;
import java.util.Scanner;

import com.project.dto.UserDTO;
import com.project.service.UserService;
import com.project.service.impl.UserServiceImpl;

public class UserController {
	
	private int optionUser = 0;
	private UserService userService = null;
	
	private Scanner s = new Scanner(System.in);
	
	{//Instance block
		
		do{
            System.out.println("1. Select 1 Add User\n2. Select 2 Delete User\n3. Select 3 Update User" +
                    "\n4. Select 4 to Show All User\n5. Select 5 to Show Any User\n6. Select 6 for Exit");
            optionUser = s.nextInt();
            switch(optionUser) {
                case 1:
                    //System.out.println("Add User...");
                    addUser();
                    break;
                case 2:
                    System.out.println("Delete User...");
                    deleteUser();                    
                    break;
                case 3:
                    System.out.println("Update User...");
                    updateUser();
                    break;
                case 4:
                    System.out.println("Show All User...");
                    break;
                case 5:
                    System.out.println("Show Any User...");
                    break;
                case 6:
                    System.out.println("Exited from User Section Successfully...");
                    break;
            }
        }while(optionUser != 6);
		
	}//instance block closed
	
	public void addUser() {
		System.out.println("Enter userId");
		int userId = s.nextInt();
		
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
		
		UserDTO user = new UserDTO(userId, firstName, lastName, email, password, address);
		userService = new UserServiceImpl();
		boolean b = userService.saveUser(user);
		if(b==true) {
			System.out.println("Data saved successfully");
		}else {
			System.out.println("Something went wrong."
					+ "\n---------------------\nData is not saved as yet ");
		}
		
		
	}
	
	
	public void updateUser() {	
		System.out.println("Enter UserId to update details");
		int userId = s.nextInt();
		userService = new UserServiceImpl();
		boolean b = userService.updateUser(userId);
		if(b==true) {
			System.out.println("Record has been updated successfully");
		}else {
			System.out.println("Something went wrong."
					+ "\n---------------------\nData is not updated as yet ");
		}
		
	}
	
	public void deleteUser() {	
		System.out.println("Enter UserId to delete");
		int id = s.nextInt();
		userService = new UserServiceImpl();
		boolean b = userService.deleteUser(id);
		if(b==true) {
			System.out.println("Record has been deleted successfully");
		}else {
			System.out.println("Something went wrong."
					+ "\n---------------------\nData is not deleted as yet ");
		}
		
	}
	
	public void showAllUser() {
		
	}
	
	public void searchUser(int id) {
		
	}
	
	

}
