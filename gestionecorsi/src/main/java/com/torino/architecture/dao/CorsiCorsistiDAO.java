package com.torino.architecture.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.torino.bc.model.CorsiCorsisti;


public class CorsiCorsistiDAO  extends AdapterDAO<CorsiCorsisti> implements DAOConstants {

	public static CorsiCorsistiDAO getFactory() throws DAOException {
		return new CorsiCorsistiDAO();
	}

	private CachedRowSet rowSet;

	private CorsiCorsistiDAO() throws DAOException {
		try {
			rowSet = RowSetProvider.newFactory().createCachedRowSet();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}

	@Override
	public void create(Connection conn, CorsiCorsisti cc) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSI_CORSISTI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, cc.getCodcc());
			rowSet.updateLong(2, cc.getCodcorsista());
			rowSet.updateLong(3, cc.getCodcorso());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch (SQLException sql) {
			throw new DAOException(sql);
		}

	}
	
	@Override
	public CorsiCorsisti[] getAll(Connection conn) throws DAOException {
		CorsiCorsisti[] cc = null;
		try {
			Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSI_CORSISTI);
			rs.last();
			
			cc = new CorsiCorsisti[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				CorsiCorsisti c = new CorsiCorsisti();
				c.setCodcc(rs.getLong(1));
				c.setCodcorsista(rs.getLong(2));
				c.setCodcorso(rs.getLong(3));
				cc[i] = c;
				
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return cc;
	}
}
