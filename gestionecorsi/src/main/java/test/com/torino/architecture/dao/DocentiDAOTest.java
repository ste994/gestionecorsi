package test.com.torino.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dao.DocentiDAO;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Docenti;

class DocentiDAOTest {

	private static Docenti docente;
	private static Connection conn;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		conn = DBAccess.getConnection();
	}

	@Test
	void test() {
		try {
			docente = new Docenti();
			docente = DocentiDAO.getFactory().getId(conn, 1);
			System.out.println(docente.toString());
			
			System.out.println();
			
			Docenti[] docenti = DocentiDAO.getFactory().getAll(conn); 
			assertNotNull(docenti);
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			docente = null;
			conn.commit();
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
}
