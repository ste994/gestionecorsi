package com.torino.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.torino.bc.model.Docenti;

public class DocentiDAO extends AdapterDAO<Docenti> implements DAOConstants {
	
	public static DocentiDAO getFactory() throws DAOException {
		return new DocentiDAO();
	}

	@Override
	public Docenti getId(Connection conn, long id) throws DAOException {
		Docenti d = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_DOCENTI_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				d = new Docenti();
				d.setCodDocente(rs.getLong(1));
				d.setNomeDocente(rs.getString(2));
				d.setCognomeDocente(rs.getString(3));
				d.setCvDocente(rs.getString(4));
			}
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return d;
	}

	@Override
	public Docenti[] getAll(Connection conn) throws DAOException {
		Docenti[] docenti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_DOCENTI);
			rs.last();
			docenti = new Docenti[rs.getRow()];
			rs.beforeFirst();
			for(int i=0; rs.next(); i++) {
				Docenti d = new Docenti();
				d.setCodDocente(rs.getLong(1));
				d.setNomeDocente(rs.getString(2));
				d.setCognomeDocente(rs.getString(3));
				d.setCvDocente(rs.getString(4));
				docenti[i] = d;
			}
			rs.close();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return docenti;
	}
}
