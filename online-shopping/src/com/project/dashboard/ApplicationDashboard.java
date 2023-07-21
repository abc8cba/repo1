package com.project.dashboard;

import java.util.Scanner;

import com.project.controller.CartController;
import com.project.controller.OrderController;
import com.project.controller.ProductController;
import com.project.controller.UserController;

public class ApplicationDashboard {
	

	public static void main(String[] args) {
		finalCode();

	}
	
	private static void finalCode() {
		Scanner s = new Scanner(System.in);
        int option = 0,optionUser = 0,optionProduct = 0,optionCart = 0, optionOrder = 0;
        do{
            System.out.println("Welcome to Dashboard\n=====================================");
            System.out.println("1. Select 1 for User\n2. Select 2 for Product\n3. Select 3 for Cart\n4. Select 4 for Order\n5. Select 5 for Exit");
            option = s.nextInt();
            switch(option){
                case 1:
                    new UserController();
                    break;
                case 2:
                    new ProductController();
                    break;
                case 3:
                    new CartController();
                    break;
                case 4:
                    new OrderController();
                    break;
                case 5:
                    System.out.println("Case 5 Executed...");
                    System.out.println("Exited Successfully...");
                    s.close();
                    System.exit(0);
                    break;
            }
        }while(option != 5);
    }

}
