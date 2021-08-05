<%
	String nome = (String) session.getAttribute("nome");
	if(nome != null) {
%>
<%@page import="com.torino.bc.model.Corsi"%>
<%@page import="com.torino.bc.CorsiBC"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>Corsi</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Lista Corsi</h3>
	</div>
	<div class="table-responsive">
	<table class="table table-hover" style="width:100%;">
		<thead>
		<tr>
			<th style="width:200px;">Id</th>
			<th style="width:200px;">Nome</th>
			<th style="width:200px;">Data inizio</th>
			<th style="width:200px;">Data fine</th>
			<th style="width:200px;">Costo</th>
			<th style="width:200px;">Commento</th>
			<th style="width:200px;">Aula</th>
			<th style="width:200px;">Docente (id)</th>
		</tr>
		</thead>
		<tbody>
			<%
				CorsiBC cbc = new CorsiBC();
				Corsi[] c = cbc.getCorsi();
				for(int i = 0; i<c.length; i++){
			%>
			<tr> 
				<td><%= c[i].getCodCorso() %></td>
				<td><%= c[i].getNomeCorso() %></td>
				<td><%= (new SimpleDateFormat("dd/MM/yyyy")).format(c[i].getDataInizioCorso()) %></td>
				<td><%= (new SimpleDateFormat("dd/MM/yyyy")).format(c[i].getDataFineCorso()) %></td>
				<td><%= c[i].getCostoCorso() %></td>
				<td><%= c[i].getCommentiCorso() %></td>
				<td><%= c[i].getAulaCorso() %></td>
				<td><%= c[i].getCodDocente() %></td>
				<td>
				<form action="/<%=application.getServletContextName()%>/eliminaCorso?id=<%=c[i].getCodCorso()%>" 
				method="post">
				
				<button type="submit" class="btn btn-danger btn-sm">
					<span class="glyphicon glyphicon-trash"></span>
				</button>
				</form>		
				</td> 
			</tr>
			<%
				}
			%>
		</tbody>
	</table>
	
	<a class="btn btn-primary btn-lg" href="inserisciCorso.jsp">Inserisci nuovo
	</a>
	</div>
	<hr>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>
<%
	} else 
		response.sendRedirect("login.jsp");
%>
	
