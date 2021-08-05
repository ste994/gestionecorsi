package com.torino.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.CorsistiBC;
import com.torino.bc.model.Corsisti;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		Corsisti c = new Corsisti();
		try {
			c.setNomeCorsista(request.getParameter("nomeCorsista"));
			c.setCognomeCorsista(request.getParameter("cognomeCorsista"));
			c.setPrecedentiFormativi(request.getParameter("precedentiFormativi").toLowerCase());
			CorsistiBC cbc = new CorsistiBC();
			cbc.createOrUpdate(c);
			response.sendRedirect("corsisti.jsp");
		}catch(DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
