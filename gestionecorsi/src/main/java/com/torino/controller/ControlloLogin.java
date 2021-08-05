package com.torino.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.torino.architecture.dao.DAOException;
import com.torino.bc.utilities.Login;
import com.torino.security.AlgoritmoMD5;

@WebServlet("/controlloLogin")
public class ControlloLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String nome = request.getParameter("nome");
		String password = AlgoritmoMD5.converti(request.getParameter("password"));

		HttpSession session = request.getSession();
		String adminpass;

		if (nome != null && password != null) {
			try {
				Login lu = new Login();
				adminpass = lu.getAdminPass(nome);
				int tentativi;
				if ((Integer) session.getAttribute("tentativi") != null) {
					tentativi = (Integer) session.getAttribute("tentativi");
				} else {
					tentativi = 5;
				}

				if (adminpass != null) {
					if (adminpass.equals(password)) {
						session.setAttribute("nome", nome);
						response.sendRedirect("corsisti.jsp");
					} else {
						tentativi--;
						session.setAttribute("tentativi", tentativi);
						response.sendRedirect("accessonegato.jsp");
					}
				} else {
					tentativi--;
					session.setAttribute("tentativi", tentativi);
					response.sendRedirect("accessonegato.jsp");
				}

			} catch (ClassNotFoundException | DAOException exc) {
				exc.printStackTrace();
				throw new ServletException(exc.getMessage());
			}
		}
	}
}
