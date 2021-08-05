package com.torino.bc.idgenerator;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.architecture.dao.DAOConstants;

public class CorsistiIdGenerator implements DAOConstants, IdGeneratorInterface {
	private static CorsistiIdGenerator istanza;
	private Connection conn;
	private Statement stmt;
	private ResultSet rs;

	private CorsistiIdGenerator() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}

	public static CorsistiIdGenerator getInstance() throws DAOException, ClassNotFoundException, IOException {
		if (istanza == null)
			istanza = new CorsistiIdGenerator();
		return istanza;
	}

	@Override
	public long getNextId() throws ClassNotFoundException, DAOException, IOException {
		long id = 0;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(SELECT_CORSISTISEQ);
			rs.next();
			id = rs.getLong(1);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return id;
	}
}
