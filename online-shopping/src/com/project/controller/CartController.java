package com.project.controller;

import java.util.Scanner;

public class CartController {
	
	private int optionCart = 0;
	private Scanner s = new  Scanner(System.in);
	
	{
		 do{
             System.out.println("1. Select 1 Add to Cart\n2. Select 2 Delete From Cart\n3. Select 3 for Exit\"");
             optionCart = s.nextInt();
             switch(optionCart) {
                 case 1:
                     System.out.println("Add to Cart...");
                     break;
                 case 2:
                     System.out.println("Delete From Cart...");
                     break;
                 case 3:
                     System.out.println("Exited from Cart Section Successfully...");
                     break;
             }
         }while(optionCart != 3);
		
	}

}
