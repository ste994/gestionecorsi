package com.torino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.CorsistiBC;
import com.torino.bc.model.Corsisti;
import com.torino.bc.validator.CorsistaValidator;

@WebServlet("/inserisciCorsista")
public class InserisciCorsista extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Corsisti c = new Corsisti();
		String errore="errore inserimento campi";
		
		try {
			if (CorsistaValidator.validate(request.getParameter("nomeCorsista"),
					request.getParameter("cognomeCorsista")) == true) {
				c.setNomeCorsista(request.getParameter("nomeCorsista"));
				c.setCognomeCorsista(request.getParameter("cognomeCorsista"));
				c.setPrecedentiFormativi(request.getParameter("precedentiFormativi").toLowerCase());
				CorsistiBC cbc = new CorsistiBC();
				cbc.createOrUpdate(c);
				response.sendRedirect("corsisti.jsp");
			} else {

				session.setAttribute("errore", errore);
				//request.getRequestDispatcher("inserisciCorsista.jsp").forward(request, response);
				response.sendRedirect("inserisciCorsista.jsp");
			}
		} catch (DAOException | ClassNotFoundException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
