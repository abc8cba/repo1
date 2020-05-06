package com.project.webapp.utility;

public class TestCommaInString {

	public static void main(String[] args) {
		Object arr[] = {"Sandeep, Singh",45.6,"Keshav Prasad",40};
		StringBuilder sb = new StringBuilder(); 
		for(Object s:arr){
			String str = s.toString();
			if(str.contains(",")){
				System.out.println(s);
				sb.append("\""+str+"\""+",");				
			}
			else{
				sb.append(s+",");
				if(s instanceof Integer)
					System.out.println(s+" is Integer");
				if(s instanceof Double)
					System.out.println(s+" is Double");
			}
		}
		System.out.println("sb: "+sb);

	}

}
