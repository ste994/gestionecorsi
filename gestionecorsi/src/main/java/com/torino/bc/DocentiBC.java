package com.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dao.DocentiDAO;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.model.Docenti;

public class DocentiBC {
	private Connection conn;

	public DocentiBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public Docenti[] getDocenti() throws DAOException {
		try {
			return DocentiDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Docenti getById(long id) throws DAOException {
		try {
			return DocentiDAO.getFactory().getId(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
