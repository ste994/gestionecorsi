package test.com.torino.bc.validator;

import static org.junit.jupiter.api.Assertions.*;

import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.bc.model.Corsi;
import com.torino.bc.model.Corsisti;
import com.torino.bc.validator.CorsistaValidator;
import com.torino.bc.validator.CorsoValidator;

class CorsoValidatorTest {

	private static String nome;
	private static String dataInizio;
	private static String dataFine;
	private static String commenti;
	private static String aula;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		nome = "Test";
		dataInizio = "10/10/1999";
		dataFine = "05/10/2010";
		commenti = "Lunghi abbastanza";
		aula = "2";
	}

	@Test
	void testValidate() {
		System.out.println(CorsoValidator.validate(nome, dataInizio, dataFine, commenti, aula));

	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		nome = null;
		dataInizio = null;
		dataFine = null;
		commenti = null;
		aula = null;
	}

}
