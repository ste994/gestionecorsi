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
	
	//DOCENTI
	String SELECT_DOCENTI = "select * from docenti";
	String SELECT_DOCENTI_BY_ID = "select * from docenti where coddocente = ?";
	
	//CORSI CORSISTI
	String SELECT_CORSI_CORSISTI = "select * from corsi_corsisti";
	
	//AMMINISTRATORI
	String SELECT_ADMINPASS = "select password from amministratori where nomeAdmin = ?";
	//SEQUENZE
	String SELECT_CORSISEQ ="select corsi_seq.nextval from dual";
	String SELECT_CORSISTISEQ ="select corsisti_seq.nextval from dual";
	String SELECT_CORSICORSISTISEQ ="select corsi_corsisti_seq.nextval from dual";
	
	
	//QUERY STATISTICHE
	String SELECT_NUMEROCORSISTI = "select COUNT(*) from corsisti GROUP BY codCorsista";
	String SELECT_NOME_MAXFREQ = "select nomecorso from corsi where codcorso = (select codcorso from corsi_corsisti group by codcorso having count(*) = (select max(count(*)) from corsi_corsisti group by codcorso))";
	String SELECT_DATA_ULTIMO_CORSO ="select MAX(dataIniziocorso) as ultimoCorso from corsi";
	String SELECT_AVG_DURATA = "";
	String SELECT_NUM_COMMENTI = "select Count(commenticorso) from corsi";
	String SELECT_ELENCO_CORSISTI = "select * from corsisti";
	String SELECT_DOCENTE_MULTI = "select nomedocente, cognomedocente from docenti where coddocente in (select coddocente from corsi group by coddocente having count(*) = (select max(count(*)) from corsi group by coddocente))";
	String SELECT_CORSI_DISP = "select * from corsi where codCorso in (select codCorso from corsi_corsisti group by codCorso having COUNT(*) < 12)";
	
	
	
}
