<%
	String nome = (String) session.getAttribute("nome");
	if ( nome != null ) {
		session.invalidate();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Logout</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
</head>
<body>

<jsp:include page="nav.jsp"/>

<div class="container">
	<div class="page-header">
		<h3>Logout</h3>
	</div>
	<div class="panel panel-danger">
		<div class="panel-heading">
			<h3>Hai appena effettuato il logout</h3>
		</div>
		<div class="panel-body">
			<p>Per accedere nuovamente effettua il login:</p>
			<p><a href="login.jsp">Login</a></p>
		</div>
	</div>
</div>
<footer class="footer">
	<%@include file="footer.html"%>
</footer>
</body>
</html>
<%
	} else {
		response.sendRedirect("accessonegato.jsp");
	}
%>