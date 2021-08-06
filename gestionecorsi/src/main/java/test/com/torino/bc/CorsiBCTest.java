package test.com.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.CorsiBC;
import com.torino.bc.model.Corsi;

class CorsiBCTest {
	
	private static Corsi corso;
	private static CorsiBC corsoBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corso = new Corsi();
		corso.setNomeCorso("Java Academy");
		corso.setDataInizioCorso(new GregorianCalendar(1977, 6, 6).getTime());
		corso.setDataFineCorso(new GregorianCalendar(1977, 10, 9).getTime());
		corso.setCostoCorso(201.10);
		corso.setCommentiCorso("Commento corso");
		corso.setAulaCorso(1);
		corso.setCodDocente(1);
		corsoBC = new CorsiBC();
		System.out.println(corso.toString());
		
	}
	
	@Test
	@Order(1)
	void testCreateorUpdate() throws ClassNotFoundException, IOException {
		try {
			corsoBC.createOrUpdate(corso);
			System.out.println(corso.toString());
			System.out.println("creato BC corso");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corsoBC.delete(corso);
			corso = null;
			corsoBC = null;
			System.out.println("Record eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	

}
