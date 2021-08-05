package com.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.torino.architecture.dao.CorsiCorsistiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.idgenerator.CorsiCorsistiIdGenerator;
import com.torino.bc.model.CorsiCorsisti;

public class CorsiCorsistiBC {
	private Connection conn;
	private CorsiCorsistiIdGenerator idGen;

	public CorsiCorsistiBC() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public void create(CorsiCorsisti cc) throws DAOException, ClassNotFoundException, IOException {
		try {
			cc.setCodcc(idGen.getNextId());
			CorsiCorsistiDAO.getFactory().create(conn, cc);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

}
