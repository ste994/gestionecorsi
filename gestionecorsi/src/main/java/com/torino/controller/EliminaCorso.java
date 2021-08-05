package com.torino.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.CorsiBC;
import com.torino.bc.model.Corsi;


@WebServlet("/eliminaCorso")
public class EliminaCorso extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Corsi c = new Corsi();
			
		try {
			CorsiBC cbc = new CorsiBC();
			c = cbc.getById(Long.parseLong(request.getParameter("id")));
			
			if(c != null) {
				cbc.delete(c);
			}
			
			response.sendRedirect("corsi.jsp");
			
		} catch(ClassNotFoundException | DAOException exc) {
			exc.printStackTrace();
			throw new ServletException(exc.getMessage());
		}
	}
}
