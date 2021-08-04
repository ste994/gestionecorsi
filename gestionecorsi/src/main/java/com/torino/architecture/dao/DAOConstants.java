package com.torino.architecture.dao;

public interface DAOConstants {
	String SELECT_CORSI = "select * from corsi";
	String SELECT_CORSI_BY_ID = "select * from corsi where codCorso= ? ";

	String INSERT_CORSI = "insert into corsi values(?,?,?,?,?,?,?)";
	String UPDATE_CORSI = "update corsi set dataInizioCorso = ?, dataFineCorso = ?, costoCorso = ?, commentiCorso = ?, aulaCorso = ? where codCorso = ?";
	String DELETE_CORSI = "delete from corsi where codCorso=?";


}
