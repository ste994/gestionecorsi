package com.torino.security;

import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class AlgoritmoMD5 {
	public static String converti(String password) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] array = md.digest(password.getBytes(Charset.forName("UTF-8")));
			StringBuffer buffer = new StringBuffer();
			String salt="E%)9$aVB/1a3?1";
			for (int i = 0; i < array.length; i++) {
				buffer.append(String.format("%x", array[i])+salt);

			}
			return buffer.toString();

		} catch (NoSuchAlgorithmException exc) {
			return null;
		}
	}

}
