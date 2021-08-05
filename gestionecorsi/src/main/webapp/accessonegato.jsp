<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Errore</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>

<jsp:include page="nav.jsp"/>

<div class="container">
	<div class="page-header">
		<h3>Non è possibile accedere alla pagina</h3>
	</div>
	
	<% 
	int tentativi = (Integer) session.getAttribute("tentativi");
	if(tentativi>0) {
		session.setAttribute("tentativi", tentativi);
	%>
	
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Credenziali errate: <%=tentativi%> tentativi rimasti</h3>
		</div>
		<div class="panel-body">
			<h4>Riprova:</h4>
			<p><a href="login.jsp">Login</a></p>
		</div>
	</div>
	
	<%
	} else {
	%>
	
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Tentativi esauriti!</h3>
		</div>
		<div class="panel-body">
			<h4>Contatta la direzione</h4>
		</div>
	</div>
	
	<%
	}
	%>
	
</div>
<footer class="footer">
	<%@include file="footer.html"%>
</footer>
</body>
</html>