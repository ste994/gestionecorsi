package test.com.torino.bc;

import static org.junit.jupiter.api.Assertions.fail;

import java.io.IOException;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.CorsistiBC;
import com.torino.bc.model.Corsisti;

class CorsistiBCTest{
	
	private static Corsisti corsista;
	private static CorsistiBC corsistaBC;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		corsista = new Corsisti();
		corsista.setNomeCorsista("Mario");
		corsista.setCognomeCorsista("Rossi");
		corsista.setPrecedentiFormativi("si");
		corsistaBC = new CorsistiBC();
		System.out.println(corsista.toString());
		
	}
	
	@Test
	@Order(1)
	void testCreateorUpdate() throws ClassNotFoundException, IOException {
		try {
			corsistaBC.createOrUpdate(corsista);
			System.out.println(corsista.toString());
			System.out.println("creato BC corsista");
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}
	
	

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		try {
			corsistaBC.delete(corsista);
			corsista = null;
			corsistaBC = null;
			System.out.println("Record eliminato");
			DBAccess.closeConnection();
		} catch (DAOException exc) {
			exc.printStackTrace();
			fail(exc.getMessage());
		}
	}

	

}