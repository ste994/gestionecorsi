package com.torino.bc.idgenerator;

import java.io.IOException;

import com.torino.architecture.dao.DAOException;

public interface IdGeneratorInterface {
	long getNextId() throws ClassNotFoundException,DAOException,IOException;

}
