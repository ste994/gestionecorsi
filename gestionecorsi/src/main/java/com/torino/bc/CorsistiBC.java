package com.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.torino.architecture.dao.CorsistiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.idgenerator.CorsistiIdGenerator;
import com.torino.bc.model.Corsisti;

public class CorsistiBC {
	private Connection conn;
	private CorsistiIdGenerator idGen;

	public CorsistiBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
		idGen = CorsistiIdGenerator.getInstance();
	}

	public void createOrUpdate(Corsisti c) throws DAOException, ClassNotFoundException, IOException {
		try {
			if (c.getCodCorsista() > 0) {
				CorsistiDAO.getFactory().update(conn, c);
			} else {
				c.setCodCorsista(idGen.getNextId());
				CorsistiDAO.getFactory().create(conn, c);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Corsisti c) throws DAOException {
		try {
			CorsistiDAO.getFactory().delete(conn, c);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsisti[] getCorsisti() throws DAOException {
		try {
			return CorsistiDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsisti getById(long id) throws DAOException {
		try {
			return CorsistiDAO.getFactory().getId(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
