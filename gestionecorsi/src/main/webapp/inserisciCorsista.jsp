<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Inserimento Corsista</title>
<link rel="stylesheet" href="/<%=application.getServletContextName()%>/css/style.css">
<script src="js/convalida.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Inserire i dati del nuovo corsista</h3>
		</div>
		<form action="/<%=application.getServletContextName()%>/salvadati"
			method="post" id="userForm" class="form-horizontal">

			<!-- --------------Nome -->
			<div class="form-group">
				<label class="col-md-1 control-label">Nome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="nomeCorsista" id="nomeCorsista" placeholder="Nome..."
							class="form-control">
					</div>

				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<!-- --------------Cognome -->
			<div class="form-group">
				<label class="col-md-1 control-label">Cognome</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="cognomeCorsista" id="cognomeCorsista"
							placeholder="Cognome..." class="form-control">
					</div>

				</div>
				<div class="col-md-7 control-label" id="infoCognome"></div>
			</div>

			<!-- --------------Precedenti Formativi -->
			<div class="form-group">
				<label class="col-md-1 control-label">Precedenti Formativi</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="precedentiFormativi" id="precedentiFormativi" placeholder=" Si/No ..."
							class="form-control" maxlength="2">
					</div>

				</div>
				<div class="col-md-7 control-label" id="infoPF"></div>
			</div>

		</form>
		
	<button type="submit" class="btn btn-primary">Inserisci Corsista
		<span class="glyphicon glyphicon-send"></span>
	</button>
	
	</div>
	

	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>