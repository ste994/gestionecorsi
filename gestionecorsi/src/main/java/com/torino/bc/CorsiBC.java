package com.torino.bc;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import com.torino.architecture.dao.CorsiDAO;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;
import com.torino.bc.idgenerator.CorsiIdGenerator;
import com.torino.bc.model.Corsi;

public class CorsiBC {
	private Connection conn;
	private CorsiIdGenerator idGen;

	public CorsiBC() throws DAOException, ClassNotFoundException, IOException{
			conn = DBAccess.getConnection();
			idGen = CorsiIdGenerator.getInstance();
}

	public void createOrUpdate(Corsi c) throws DAOException, ClassNotFoundException, IOException {
		try {
			if (c.getCodCorso() > 0) { 
				CorsiDAO.getFactory().update(conn, c);
			} else {
			 c.setCodCorso(idGen.getNextId());
			 CorsiDAO.getFactory().create(conn, c);
			}
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public void delete(Corsi c) throws DAOException {
		try {
			CorsiDAO.getFactory().delete(conn, c);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsi[] getCorsi() throws DAOException {
		try {
			return CorsiDAO.getFactory().getAll(conn);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}

	public Corsi getById(long id) throws DAOException {
		try {
			return CorsiDAO.getFactory().getId(conn, id);
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
