package com.project.webapp.utility;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.commons.lang3.RandomStringUtils;

public interface IUtil {
	
	static String getRandomNumber(){
		String csrfValue = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
		//String csrfValue = RandomStringUtils.randomAlphanumeric(20);
		
		return csrfValue;
	}
	
	static Date getAnyDate(int date,int month,int year){
		Calendar c = Calendar.getInstance();
		c.set(Calendar.DATE, date); 
		c.set(Calendar.MONTH, month);
		c.set(Calendar.YEAR, year);
		Date dt = c.getTime();
		return dt;
	}
	
	static java.sql.Date getSqlFormatDate(java.util.Date date){
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		return sqlDate;
	}
	
	static String getFormattedDate(Date d){
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
		String date = sdf.format(d);		
		return date;
	}

}
