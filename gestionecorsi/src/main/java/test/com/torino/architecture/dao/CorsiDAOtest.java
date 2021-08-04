package test.com.torino.architecture.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.util.GregorianCalendar;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
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
        corso.setDataInizioCorso(new GregorianCalendar(1977,12,12).getTime());
        corso.setDataFineCorso(new GregorianCalendar(1978,12,12).getTime());
        corso.setCommentiCorso("Commento corso");
        corso.setAulaCorso(1);
        corso.setCodDocente(1);
    }

    @Test
    void testCreateCorso() {
        try {
            CorsiDAO.getFactory().create(conn, corso);
            System.out.println("creato factory corso");
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
