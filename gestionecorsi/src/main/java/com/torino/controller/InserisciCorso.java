package com.torino.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.CorsiBC;
import com.torino.bc.model.Corsi;
import com.torino.bc.validator.CorsoValidator;

@WebServlet("/inserisciCorso")
public class InserisciCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();
		String errore = " errore inserimento parametri";
		Corsi c = new Corsi();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		try {
			if (CorsoValidator.validate(request.getParameter("nomeCorso"), request.getParameter("dataInizio"),
					request.getParameter("dataFine"), request.getParameter("commentiCorso"),
					request.getParameter("aulaCorso"))) {
				c.setNomeCorso(request.getParameter("nomeCorso"));
				c.setDataInizioCorso(formato.parse(request.getParameter("dataInizio")));
				c.setDataFineCorso(formato.parse(request.getParameter("dataFine")));
				c.setCostoCorso(Double.parseDouble(request.getParameter("costoCorso")));
				c.setCommentiCorso(request.getParameter("commentiCorso"));
				c.setAulaCorso(Integer.parseInt(request.getParameter("aulaCorso")));
				c.setCodDocente(Integer.parseInt(request.getParameter("docenteCorso")));
				CorsiBC cbc = new CorsiBC();
				cbc.createOrUpdate(c);
				response.sendRedirect("corsi.jsp");
			}else {
				session.setAttribute("errore", errore);
				response.sendRedirect("inserisciCorso.jsp");
			}
		} catch (DAOException | ClassNotFoundException | ParseException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
