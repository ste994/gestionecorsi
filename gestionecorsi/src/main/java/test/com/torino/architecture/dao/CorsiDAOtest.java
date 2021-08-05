package test.com.torino.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.CorsiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Corsi;

class CorsiDAOtest {

	private static Corsi corso;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corso = new Corsi();
		corso.setNomeCorso("Java Academy");
		corso.setDataInizioCorso(new GregorianCalendar(1977, 6, 6).getTime());
		corso.setDataFineCorso(new GregorianCalendar(1977, 10, 9).getTime());
		corso.setCostoCorso(201.10);
		corso.setCommentiCorso("Commento corso");
		corso.setAulaCorso(1);
		corso.setCodDocente(1);
	}

	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsiDAO.getFactory().create(conn, corso);
			System.out.println("creato factory corso");
			System.out.println(corso.toString());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try {
			corso = new Corsi();
			corso.setNomeCorso("provaAc");
			corso.setDataInizioCorso(new GregorianCalendar(2021, 11, 6).getTime());
			corso.setDataFineCorso(new GregorianCalendar(2021, 11, 10).getTime());
			corso.setCostoCorso(200.05);
			corso.setCommentiCorso("PRovaprova prova");
			corso.setAulaCorso(25);
			corso.setCodDocente(1);
			System.out.println(corso.toString());
			
			CorsiDAO.getFactory().update(conn, corso);
			System.out.println("Modificato corso");
			corso = CorsiDAO.getFactory().getId(conn, 0);
			System.out.println(corso.getAulaCorso());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsiDAO.getFactory().delete(conn, corso);
			corso = null;
			conn.commit();
			System.out.println("Record eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
