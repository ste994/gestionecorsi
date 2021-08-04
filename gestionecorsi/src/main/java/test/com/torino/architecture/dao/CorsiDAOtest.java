package test.com.torino.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Corsi;

class CorsiDAOtest {

	private static Corsi corso;
	private static Connection conn;
	
	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corsi();
		corso.setNomeCorso("Java Academy");
		corso.setDataInizioCorso(new GregorianCalendar(1977,12,12).getTime());
		corso.setDataFineCorso(new GregorianCalendar(1978,12,12).getTime());
		corso.setCommentiCorso("Commento corso");
		corso.setAulaCorso(1);
		corso.setCodDocente(1);
	}

}
