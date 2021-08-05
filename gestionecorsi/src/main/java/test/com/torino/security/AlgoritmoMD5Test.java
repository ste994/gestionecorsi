package test.com.torino.security;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import com.torino.security.AlgoritmoMD5;

class AlgoritmoMD5Test {

	@Test
	void testConversione() {
		String password=AlgoritmoMD5.converti("pass");
		assertNotNull(password);
		System.out.println(password);
	}

}
