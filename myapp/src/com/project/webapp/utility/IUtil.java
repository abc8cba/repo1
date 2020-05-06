package com.project.webapp.utility;

import java.security.SecureRandom;

import org.apache.commons.lang3.RandomStringUtils;

public interface IUtil {
	
	static String getRandomNumber(){
		String csrfValue = RandomStringUtils.random(20, 0, 0, true, true, null, new SecureRandom());
		//String csrfValue = RandomStringUtils.randomAlphanumeric(20);
		
		return csrfValue;
	}

}
