package com.project.controller;

import java.util.Scanner;

public class OrderController {
	
	private int optionOrder = 0;
	private Scanner s = new  Scanner(System.in);
	
	{
		do{
            System.out.println("1. Select 1 to Book an Order\n2. Select 2 to Book an Order\n3. Select 3 for Exit\"");
            optionOrder = s.nextInt();
            switch(optionOrder) {
                case 1:
                    System.out.println("Book an Order...");
                    break;
                case 2:
                    System.out.println("Cancel the Order...");
                    break;
                case 3:
                    System.out.println("Exited from Order Section Successfully...");
                    break;
            }
        }while(optionOrder != 3);
		
	}

}
