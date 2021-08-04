package com.torino.architecture.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.rowset.CachedRowSet;

import com.torino.bc.model.Corsi;

public class CorsiDAO extends AdapterDAO<Corsi> implements DAOConstants {
	private CachedRowSet rowSet;
	
	public static CorsiDAO getFactory() throws DAOException {
		return new CorsiDAO();
	}
	
	
	@Override
	public void create(Connection conn, Corsi c) throws DAOException {
		try {
			rowSet.setCommand(INSERT_CORSI);
			rowSet.execute(conn);
			rowSet.moveToInsertRow();
			rowSet.updateLong(1,c.getCodCorso());
			rowSet.updateString(2,c.getNomeCorso());
			rowSet.updateDate(3,new java.sql.Date(c.getDataInizioCorso().getTime()));
			rowSet.updateDate(4,new java.sql.Date(c.getDataFineCorso().getTime()));
			rowSet.updateDouble(5,c.getCostoCorso());
			rowSet.updateString(6,c.getCommentiCorso());
			rowSet.updateInt(7, c.getAulaCorso());
			rowSet.updateInt(8, c.getCodDocente());
			rowSet.insertRow();
			rowSet.moveToCurrentRow();
			rowSet.acceptChanges();
			
			
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public void update(Connection conn, Corsi c) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(UPDATE_CORSI);
			ps.setDate(1,new java.sql.Date(c.getDataInizioCorso().getTime()));
			ps.setDate(2,new java.sql.Date(c.getDataFineCorso().getTime()));
			ps.setDouble(3,c.getCostoCorso());
			ps.setString(4,c.getCommentiCorso());
			ps.setInt(5,c.getAulaCorso());
			ps.setLong(6,c.getCodCorso());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		
	}

	@Override
	public void delete(Connection conn, Corsi c) throws DAOException {
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(DELETE_CORSI);
			ps.setLong(1, c.getCodCorso());
			ps.execute();
			conn.commit();
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}

	@Override
	public Corsi getId(Connection conn, long id) throws DAOException {
		Corsi c = null;
		PreparedStatement ps;
		try {
			ps = conn.prepareStatement(SELECT_CORSI_BY_ID);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				c = new Corsi();
				c.setCodCorso(rs.getLong(1));
				c.setNomeCorso(rs.getString(2));
				c.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				c.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				c.setCostoCorso(rs.getDouble(5));
				c.setCommentiCorso(rs.getString(6));
				c.setAulaCorso(rs.getInt(7));
				c.setCodDocente(rs.getInt(8));
				
			}
		}catch(SQLException sql) {
			throw new DAOException(sql);
		}
		return c;
	}

	@Override
	public Corsi[] getAll(Connection conn) throws DAOException {
		Corsi[] corsi = null;
		try {
			Statement stmt = conn.createStatement(
				ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery(SELECT_CORSI);
			rs.last();
			
			corsi = new Corsi[rs.getRow()];
			rs.beforeFirst();
			for(int i = 0; rs.next(); i++) {
				Corsi c = new Corsi();
				c.setCodCorso(rs.getLong(1));
				c.setNomeCorso(rs.getString(2));
				c.setDataInizioCorso(new java.util.Date(rs.getDate(3).getTime()));
				c.setDataFineCorso(new java.util.Date(rs.getDate(4).getTime()));
				c.setCostoCorso(rs.getDouble(5));
				c.setCommentiCorso(rs.getString(6));
				c.setAulaCorso(rs.getInt(7));
				c.setCodDocente(rs.getInt(8));
				corsi[i] = c;
				
			}
			rs.close();
		}catch (SQLException sql) {
			throw new DAOException(sql);
		}
		return corsi;
	}
	
	

}
