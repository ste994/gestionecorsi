package test.com.torino.bc;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.CorsistiBC;
import com.torino.bc.DocentiBC;
import com.torino.bc.model.Corsisti;
import com.torino.bc.model.Docenti;

class DocentiBCTest {
	
		private static Docenti docente;
		private static DocentiBC docenteBC;
		
		@BeforeAll
		static void setUpBeforeClass() throws Exception {
			docente = new Docenti();
			docente.setNomeDocente("TestDocente");
			docente.setCognomeDocente("CognomeTestDoc");
			docente.setCvDocente("test/test2");
			docenteBC = new DocentiBC();
			System.out.println(docente.toString());
			
		}
		
		@Test
		void testGetById() {
			try {
				docente = docenteBC.getById(1);
				System.out.println(docente.toString());
			} catch (DAOException exc) {
				exc.printStackTrace();
				fail(exc.getMessage());
			}
		}

		@Test
		void testGetAll() {
			try {
				Docenti[] docenti = docenteBC.getDocenti();
				for(int i=0;i<docenti.length;i++) {
					System.out.println(docenti[i].toString());
				}
				assertNotNull(docenti);
			} catch (DAOException exc) {
				exc.printStackTrace();
				fail(exc.getMessage());

			}
		}
		
}
