package com.torino.architecture.dao;

import java.sql.Connection;


public abstract class AdapterDAO<T> implements GenericDAO<T> {
	
	@Override
	public void create(Connection conn, T entity) throws DAOException{
	}
	
	@Override
	public void update(Connection conn, T entity) throws DAOException{
	}
	
	@Override
	public void delete(Connection conn, T entity) throws DAOException{
	}
	
	@Override
	public T getId(Connection conn, long id) throws DAOException{
		return null;
	}
	
	@Override
	public T[] getAll(Connection conn) throws DAOException{
		return null;
	}

		
}
