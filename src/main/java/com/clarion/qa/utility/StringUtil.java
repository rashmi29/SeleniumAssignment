package com.clarion.qa.utility;

public class StringUtil {
	public String generateRandomString(int length) {
		String completeString = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		String randomString="";
		for (int i = 0; i < length; i++) {
		      randomString = randomString + completeString.charAt((int)Math.floor(Math.random() * completeString.length()));
		    }
		return randomString;
	}

}
