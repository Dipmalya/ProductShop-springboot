package com.example.product.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class EncryptString {
	
	public static String encryptPwd(String pwd) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		BigInteger number = new BigInteger(1, md.digest(pwd.getBytes(StandardCharsets.UTF_8)));
		
		StringBuilder hexString = new StringBuilder(number.toString(16));
		return hexString.toString();
	}

}
