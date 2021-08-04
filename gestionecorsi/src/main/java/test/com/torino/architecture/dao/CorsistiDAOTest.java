package test.com.torino.architecture.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.CorsistiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Corsisti;

class CorsistiDAOTest {
	
	private static Corsisti corsista;
	private static Connection conn;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
		corsista = new Corsisti();
		corsista.setNomeCorsista("Mario");
		corsista.setCognomeCorsista("Rossi");
		corsista.setPrecedentiFormativi("si");
		System.out.println(corsista.toString());
		
	}
	
	@Test
	@Order(1)
	void testCreate() {
		try {
			CorsistiDAO.getFactory().create(conn, corsista);
			
			System.out.println("creato factory corsista");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	@Order(2)
	void testUpdate() {
		try {
			corsista = new Corsisti();
			corsista.setNomeCorsista("Paolo");
			corsista.setCognomeCorsista("Verdi");
			corsista.setPrecedentiFormativi("si");
			corsista.setCodCorsista(0);
			
			CorsistiDAO.getFactory().update(conn, corsista);
			System.out.println("Modificato corsista");
			corsista = CorsistiDAO.getFactory().getId(conn, 0);
			System.out.println(corsista.getNomeCorsista());
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	@Test
	void testGetAll() {
		try {
			Corsisti[] corsisti = CorsistiDAO.getFactory().getAll(conn);
			assertNotNull(corsisti);
		}catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			CorsistiDAO.getFactory().delete(conn, corsista);
			corsista = null;
			conn.commit();
			System.out.println("Record eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	

}
