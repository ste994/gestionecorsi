package test.com.torino.architecture.dao;

import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.CorsiCorsistiDAO;
import com.torino.architecture.dao.CorsiDAO;
import com.torino.architecture.dao.CorsistiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Corsi;
import com.torino.bc.model.CorsiCorsisti;
import com.torino.bc.model.Corsisti;

class CorsiCorsistiDAOTest {
	private static Corsi corsi;
	private static Corsisti corsisti;
	private static Connection conn;
	private static CorsiCorsisti cc;
	

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		
		corsi = new Corsi();
		corsi.setNomeCorso("Java Academy");
		corsi.setDataInizioCorso(new GregorianCalendar(1977, 6, 6).getTime());
		corsi.setDataFineCorso(new GregorianCalendar(1977, 10, 9).getTime());
		corsi.setCostoCorso(201.10);
		corsi.setCommentiCorso("Commento corso");
		corsi.setAulaCorso(1);
		corsi.setCodDocente(1);
		
		corsisti = new Corsisti();
		corsisti.setNomeCorsista("Mario");
		corsisti.setCognomeCorsista("Rossi");
		corsisti.setPrecedentiFormativi("si");
		
		cc = new CorsiCorsisti();
		cc.setCodcc(1);
		cc.setCodcorso(0);
		cc.setCodcorsista(0);
		
		
	}

	

	@Test
	void testCreate() {
		try {
			CorsiDAO.getFactory().create(conn, corsi);
			CorsistiDAO.getFactory().create(conn, corsisti);
			CorsiCorsistiDAO.getFactory().create(conn, cc);
		
			System.out.println("creato factory corsi");
			
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
		
		try {
			CorsiDAO.getFactory().delete(conn, corsi);
			CorsistiDAO.getFactory().delete(conn, corsisti);
			
			
			corsi = null;
			corsisti = null;
			cc = null;
		
			
			conn.commit();
			System.out.println("eliminato factory corsi");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	

}
