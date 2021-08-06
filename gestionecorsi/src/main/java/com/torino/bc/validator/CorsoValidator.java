package com.torino.bc.validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CorsoValidator {
	public static boolean validate(String nome, String dataInizio, String dataFine, String commenti, String aula) {

		if (Pattern.matches("^[a-zA-Z]{2,30}$", nome) == false) {
			System.out.println("solo caratteri nel nome, max dimensione 30 caratteri");
			return false;
		}
		if(Pattern.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", dataInizio) == false){
			System.out.println("Formato data inizio errato");
			return false;
		}
		if(Pattern.matches("^(?:(?:31(\\/|-|\\.)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/|-|\\.)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/|-|\\.)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/|-|\\.)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$", dataFine) == false){
			System.out.println("Formato data fine errato");
			return false;
		}
		if(Pattern.matches("^[A-Za-z ,.']{0,200}$", commenti) == false) {
			System.out.println("Lunghezza commenti max = 200");
			return false;
		}
		if(Pattern.matches("\\d", aula) == false) {
			System.out.println("L'aula deve essere numerica");
			return false;
		}
		
		return true;
	}

}
