<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp" %>
<title>Error 404</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp"/>
<div class="container">
	<div class="page-header">
		<h3>Pagina non trovata</h3>
	</div>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Impossibile caricare la pagina richiesta</h3>
		</div>
		<div class="panel-body">
			<p>Siamo spiacenti</p>
			<p>Per malfunzionamenti contattare l'amministratore:</p>
			<p><a href="mailto:admin@site.com">admin@site.com</a></p>
			<p>Oppure torna alla pagina precedente</p>
			<p><input type="button" class="btn btn-default"
			value="Indietro" onclick="window.history.back()"></p>
		</div>
	</div>
</div>
<footer><%@include file="footer.html" %></footer>
</body>
</html>