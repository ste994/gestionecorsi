package com.torino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.CorsiCorsistiBC;
import com.torino.bc.model.CorsiCorsisti;

@WebServlet("/iscrizione")
public class Iscrizione extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		CorsiCorsisti cc = new CorsiCorsisti();
		try {
			cc.setCodcorsista(Long.parseLong(request.getParameter("codCorsista")));
			cc.setCodcorso(Long.parseLong(request.getParameter("codCorso")));
			CorsiCorsistiBC ccbc = new CorsiCorsistiBC();
			ccbc.create(cc);
			
			response.sendRedirect("corsisti.jsp");
		}catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
