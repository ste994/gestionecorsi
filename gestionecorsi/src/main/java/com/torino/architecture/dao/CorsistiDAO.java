package com.torino.architecture.dao;

import javax.sql.rowset.CachedRowSet;
import com.torino.bc.model.Corsisti;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class CorsistiDAO extends AdapterDAO<Corsisti> implements DAOConstants {

	private CachedRowSet rowSet;
	
	public static CorsistiDAO getFactory() throws DAOException {
		return new CorsistiDAO();
	}
	
	@Override
	public void create(Connection conn, Corsisti c) throws DAOException {
		try {
			rowSet.setCommand(SELECT_CORSISTI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1, c.getCodCorsista());
			rowSet.updateString(2, c.getNomeCorsista());
			rowSet.updateString(3, c.getCognomeCorsista());
			rowSet.updateString(4, c.getPrecedentiFormativi());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsisti c) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(UPDATE_CORSISTI);
			ps.setString(1, c.getNomeCorsista());
			ps.setString(2, c.getCognomeCorsista());
			ps.setString(3, c.getPrecedentiFormativi());
			ps.setLong(4, c.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void delete(Connection conn, Corsisti c) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSISTI);
			ps.setLong(1, c.getCodCorsista());
			ps.execute();
			conn.commit();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corsisti getId(Connection conn, long id) throws DAOException {
		Corsisti c = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSISTI_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c = new Corsisti();
				c.setCodCorsista(rs.getLong(1));
				c.setNomeCorsista(rs.getString(2));
				c.setCognomeCorsista(rs.getString(3));
				c.setPrecedentiFormativi(rs.getString(4));
			}
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return c;
	}

	@Override
	public Corsisti[] getAll(Connection conn) throws DAOException {
		Corsisti[] corsisti = null;
		try {
			Statement stmt = conn.createStatement(
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSISTI);
			rs.last();
			corsisti = new Corsisti[rs.getRow()];
			rs.beforeFirst();
			for(int i=0; rs.next(); i++) {
				Corsisti c = new Corsisti();
				c.setCodCorsista(rs.getLong(1));
				c.setNomeCorsista(rs.getString(2));
				c.setCognomeCorsista(rs.getString(3));
				c.setPrecedentiFormativi(rs.getString(4));
				corsisti[i] = c;
			}
			rs.close();
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return corsisti;
	}
}
