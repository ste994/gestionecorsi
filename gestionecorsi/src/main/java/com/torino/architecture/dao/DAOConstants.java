package com.torino.architecture.dao;

public interface DAOConstants {
	//CORSI
	String SELECT_CORSI = "select * from corsi";
	String SELECT_CORSI_BY_ID = "select * from corsi where codCorso = ?";
	String INSERT_CORSI = "insert into corsi values(?,?,?,?,?,?,?)";
	String UPDATE_CORSI = "update corsi set dataInizioCorso = ?, dataFineCorso = ?, "
			+ "costoCorso = ?, commentiCorso = ?, aulaCorso = ? where codCorso = ?";
	String DELETE_CORSI = "delete from corsi where codCorso = ?";

	//CORSISTI
	String SELECT_CORSISTI = "select * from corsisti";
	String SELECT_CORSISTI_BY_ID = "select * from corsisti where codCorsista = ? ";
	String INSERT_CORSISTI = "insert into corsisti values(?,?,?)";
	String UPDATE_CORSISTI = "update corsisti set nomeCorsista = ?, cognomeCorsista = ?, "
			+ "precedentiFormativi = ? where codCorsista = ?";
	String DELETE_CORSISTI = "delete from corsisti where codCorsista = ?";
}
