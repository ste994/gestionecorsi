<%
	String nome = (String) session.getAttribute("nome");
	if(nome != null) {
%>
<%@page import="com.torino.bc.model.Corsisti"%>
<%@page import="com.torino.bc.CorsistiBC"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>Corsisti</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Lista Corsisti</h3>
	</div>
	<div class="table-responsive">
	<table class="table table-hover" style="width:100%;">
		<thead>
		<tr>
			<th style="width:200px;">Id</th>
			<th style="width:200px;">Nome</th>
			<th style="width:200px;">Cognome</th>
			<th style="width:200px;">Precedenti Formativi</th>
		</tr>
		</thead>
		<tbody>
			<%
				CorsistiBC cbc = new CorsistiBC();
				Corsisti[] c = cbc.getCorsisti();
				for(int i = 0; i<c.length; i++){
			%>
			<tr> 
				<td><%= c[i].getCodCorsista() %></td>
				<td><%= c[i].getNomeCorsista() %></td>
				<td><%= c[i].getCognomeCorsista() %></td>
				<td><%= c[i].getPrecedentiFormativi() %></td>
				<td>
				<form action="/<%=application.getServletContextName()%>/eliminaCorsista?id=<%=c[i].getCodCorsista()%>" 
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
	
	<a class="btn btn-primary btn-lg" href="inserisciCorsista.jsp">Inserisci nuovo
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
	
