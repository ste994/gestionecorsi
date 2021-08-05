<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Login</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">


</head>
<body>

<jsp:include page="nav.jsp"/>

<div class="container">
	<div class="page-header">
		<h3>Inserire i dati per effettuare il login</h3>
	</div>
	
	<form action="/<%=application.getServletContextName()%>/controlloLogin"method="post"
	id="userForm" class="form-horizontal">
		
	<!------------------------------NOMEADMIN---------------------------------->
	<div class="form-group">
		<label class="col-md-1 control-label">Nome admin</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-user"></i>
				</span>
				<input type="text" name="nome" id="nome"
				placeholder="Nome..."
				class="form-control">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoNome"></div>
	</div>
	
	<!------------------------------PASSWORD----------------------------------->
	<div class="form-group">
		<label class="col-md-1 control-label">Password</label>
		<div class="col-md-4 inputGroupContainer">
			<div class="input-group">
				<span class="input-group-addon">
					<i class="glyphicon glyphicon-lock"></i>
				</span>
				<input type="password" name="password" id="password"
				placeholder="Password..."
				class="form-control">
			</div>
		</div>
		<div class="col-md-7 control-label" id="infoPassword"></div>
	</div>
	
	<!------------------------------------------------------------------------->
	
	<div class="row">
		<div class="col-md-4 col-md-offset-1">
			<button type="submit" class="btn btn-warning">
				Login&nbsp;<span class="glyphicon glyphicon-log-in"></span>
			</button>
		</div>
	</div>
	
	</form>
</div>
<footer class="footer">
	<%@include file="footer.html"%>
</footer>
</body>
</html>