<%@page import="java.util.ArrayList"%>
<%
String nome = (String) session.getAttribute("nome");
if (nome != null) {
%>
<%@page import="com.torino.bc.model.Corsisti"%>
<%@page import="com.torino.bc.CorsistiBC"%>
<%@page import="com.torino.bc.model.Corsi"%>
<%@page import="com.torino.bc.CorsiBC"%>
<%@page import="com.torino.bc.model.CorsiCorsisti"%>
<%@page import="com.torino.bc.CorsiCorsistiBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Corsisti</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Lista Corsisti</h3>
		</div>
		<div class="table-responsive">
			<table class="table table-hover" style="width: 100%;">
				<thead>
					<tr>
						<th style="width: 200px;">Id</th>
						<th style="width: 200px;">Nome</th>
						<th style="width: 200px;">Cognome</th>
						<th style="width: 200px;">Precedenti Formativi</th>
					</tr>
				</thead>
				<tbody>
					<%
					CorsistiBC cbc = new CorsistiBC();
					Corsisti[] corsisti = cbc.getCorsisti();
					for (int i = 0; i < corsisti.length; i++) {
					%>
					<tr>
						<td><%=corsisti[i].getCodCorsista()%></td>
						<td><%=corsisti[i].getNomeCorsista()%></td>
						<td><%=corsisti[i].getCognomeCorsista()%></td>
						<td><%=corsisti[i].getPrecedentiFormativi()%></td>
						<td>
							<form
								action="/<%=application.getServletContextName()%>/eliminaCorsista?id=<%=corsisti[i].getCodCorsista()%>"
								method="post">

								<button type="submit" class="btn btn-danger btn-sm">
									<span class="glyphicon glyphicon-trash"></span>
								</button>
							</form>
						</td>
						<td>
							<div class="btn-group">
								<button type="button" class="btn btn-info">Aggiungi corso</button>
								<button type="button" class="btn btn-info dropdown-toggle"
									data-toggle="dropdown" aria-haspopup="true"
									aria-expanded="false">
									<span class="caret"></span> <span class="sr-only">Toggle
										Dropdown</span>
								</button>
								<ul class="dropdown-menu">
									<%
									CorsiCorsistiBC ccbc = new CorsiCorsistiBC();
									CorsiCorsisti[] cc = ccbc.getCC();		
									ArrayList<Long> codici = new ArrayList<Long>();
									int k = 0;
									for (int j = 0; j < cc.length; j++) {
											if(cc[j].getCodcorsista() == corsisti[i].getCodCorsista()) {
												codici.add(cc[j].getCodcorso());
												k++;
											}
											
									}
									CorsiBC corsibc = new CorsiBC();
									Corsi[] corsi = corsibc.getCorsi();
									for (int q = 0; q < corsi.length; q++) {
										if(!codici.contains(corsi[q].getCodCorso())) {
									%>
									
									<li>
										
										<a href="/<%=application.getServletContextName()%>/iscrizione?codCorsista=<%=corsisti[i].getCodCorsista()%>&codCorso=<%=corsi[q].getCodCorso()%>">
										&nbsp;<%=corsi[q].getNomeCorso()%></a>
									</li>
				
									<%
										}
									}
									%>
								</ul>
							</div>
						</td>
					</tr>
					<%
					}
					%>
				</tbody>
			</table>

			<a class="btn btn-primary btn-lg" href="inserisciCorsista.jsp">Inserisci
				nuovo </a>
		</div>
		<hr>
	</div>
	<footer><%@include file="footer.html"%></footer>
</body>
</html>
<%
} else
response.sendRedirect("login.jsp");
%>

