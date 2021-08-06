package com.torino.bc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorsistaValidator {

	public static boolean validate(String nome,String cognome) {

		Pattern nomecorsistapattern = Pattern.compile("^[a-zA-Z]{2,30}$");
		Matcher nomecorsistamatcher = nomecorsistapattern.matcher(nome);
		if (nomecorsistamatcher.matches() == false) {
			System.out.println("solo caratteri nel nome, max dimensione 30 caratteri");
			return false;
		}

		Pattern cognomecorsistapattern = Pattern.compile("^[a-zA-Z]{2,30}$");
		Matcher cognomecorsistamatcher = cognomecorsistapattern.matcher(cognome);
		if (cognomecorsistamatcher.matches() == false) {
			System.out.println("solo caratteri nel cognome, max dimensione 30 caratteri");
			return false;
		}

		return true;
	}

}
