package com.package1;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Vector;

public class TestException {	
	

	static void exception1(){//NumberFormatException
		String str = "hello";
		int num = Integer.parseInt(str);
		System.out.println(num);
	}
	
	static void exception2(){//StrinIndexOutOfBoundException 
		String str = "Hello";
		char ch = str.charAt(1);
		System.out.println(ch);
	}
	
	static void exception3(){// InputMismatchException
		Scanner s = new Scanner(System.in);
		System.out.println("Enter a number");
		int num = s.nextInt();
		System.out.println(num);	
	}

	static void exception4() {
        //Scanner s = null;
        Scanner s  = new Scanner(System.in);
        System.out.println("Enter any string");
        String str = s.next();//NullPointerException
        System.out.println(str);// Sandeep
    }

    static void exception5() {
        int arr[] = {5, 6};
        System.out.println(arr[3]);//ArrayIndexOutOfBoundException
        //6
    }

    static void exception6() {
        Vector<Integer> arr = new Vector();
        arr.add(10);
        arr.add(20);
        System.out.println("Vector Value = "+arr);
        System.out.println(arr.get(2));//IndexOutOfBoundException
    }

    public static void main(String s[]) {
        try{
            exception4();
            exception5();
            exception6();
        }catch(Exception ne){
            ne.printStackTrace();
            System.out.println("Exception Generated.. ");
        }
        
        System.out.println("Hello");

    }
}
