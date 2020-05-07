package com.project.webapp.utility;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDate {

	public static void main(String[] args) {
		Date d = new Date();	
		System.out.println(d);
		
		java.sql.Date sqlDate = IUtil.getSqlFormatDate(d);
		System.out.println(sqlDate);	
		
		
		Date dt = IUtil.getAnyDate(12, 7, 2018);
		System.out.println(dt);		
		
		java.sql.Date sqlDate2 = IUtil.getSqlFormatDate(dt);
		System.out.println(sqlDate2);
		
		String fixDate = IUtil.getFormattedDate(dt);
		System.out.println("fixDate: "+fixDate);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		try {
			Date date = sdf.parse("12-10-2016");
			System.out.println(date);
			java.sql.Date sqlDate3 = IUtil.getSqlFormatDate(date);
			System.out.println(sqlDate3);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

}
