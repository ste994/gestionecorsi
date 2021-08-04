package com.torino.bc.utilities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.torino.architecture.dao.DAOConstants;
import com.torino.architecture.dao.DAOException;
import com.torino.architecture.dbaccess.DBAccess;

public class Login implements DAOConstants {
	private Connection conn;
	
	public Login() throws DAOException, ClassNotFoundException, IOException {
		conn = DBAccess.getConnection();
	}
	
	public String getAdminPass (long id) throws DAOException {
		try {
			PreparedStatement ps = conn.prepareStatement(SELECT_ADMINPASS);
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if(rs.next())
				return rs.getString(1);
			return null;
		} catch(SQLException sql) {
			throw new DAOException(sql);
		}
	}
}
