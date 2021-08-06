<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<%@include file="head.jsp"%>
<title>Inserimento Corso</title>
<link rel="stylesheet"
	href="/<%=application.getServletContextName()%>/css/style.css">
<script src="js/convalida.js"></script>
</head>
<body>
	<jsp:include page="nav.jsp" />
	<div class="container">
		<div class="page-header">
			<h3>Inserire i dati del corso</h3>
		</div>
		<form
			action="/<%=application.getServletContextName()%>/inserisciCorso"
			method="post" id="userForm" class="form-horizontal">

			<!-- --------------Nome Corso-->
			<div class="form-group">
				<label class="col-md-1 control-label">Nome corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="nomeCorso" id="nomeCorso"
							placeholder="Nome..." class="form-control">
					</div>

				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>

			<!-- --------------DataInizioCorso  -->
			<div class="form-group">
				<label class="col-md-1 control-label">Data Inizio</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dpi">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-calendar"></i>
						</span> <input type="text" name="dataInizio" id="dataInizio"
							placeholder="DD/MM/YYYY..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDataInizio"></div>
			</div>
			<script>
				$(function() {
					$('#dpi').datepicker({
						format : 'dd/mm/yyyy',
						autoclose : true,
						startDate : '01/01/1900'
					}).on(
							'changeDate',
							function(e) {
								$('#userForm').bootstrapValidator(
										'revalidateField', 'nascita');

							});
				});
			</script>

			<!-- --------------DataFineCorso  -->
			<div class="form-group">
				<label class="col-md-1 control-label">Data Fine</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group date" id="dpf">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-calendar"></i>
						</span> <input type="text" name="dataFine" id="dataFine"
							placeholder="DD/MM/YYYY..." class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDataFine"></div>
			</div>
			<script>
				$(function() {
					$('#dpf').datepicker({
						format : 'dd/mm/yyyy',
						autoclose : true,
						startDate : '01/01/1900'
					}).on(
							'changeDate',
							function(e) {
								$('#userForm').bootstrapValidator(
										'revalidateField', 'nascita');

							});
				});
			</script>

			<!-- --------------Costo Corso -->
			<div class="form-group">
				<label class="col-md-1 control-label">Costo Corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" name="costoCorso" id="costoCorso" placeholder="Costo..."
							class="form-control" maxlength="7">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoCosto"></div>
			</div>
			<!-- --------------Commenti corso -->
			
			<div class="form-group">
				<label class="col-md-1 control-label">Commenti</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-user"></i>
						</span> <input type="text" name="commentiCorso" id="commentiCorso"
							placeholder="Commento... " class="form-control" maxlength="200">
					</div>

				</div>
				<div class="col-md-7 control-label" id="infoNome"></div>
			</div>
			
			<!-- --------------Aula Corso -->
			
			<div class="form-group">
				<label class="col-md-1 control-label">Aula corso</label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" name="aulaCorso" id="aulaCorso" placeholder="Aula Corso ..."
							class="form-control">
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoAula"></div>
			</div>
			
			<!-- --------------coddocente  -->
			
			<div class="form-group">
				<label class="col-md-1 control-label">Docente </label>
				<div class="col-md-4 inputGroupContainer">
					<div class="input-group">
						<span class="input-group-addon"> <i
							class="glyphicon glyphicon-home"></i>
						</span> <input type="text" name="docenteCorso" id="docenteCorso" placeholder="Docente ..."
							class="form-control" >
					</div>
				</div>
				<div class="col-md-7 control-label" id="infoDocente"></div>
			</div>
			

			<button type="submit" class="btn btn-primary">
				Inserisci corso <span class="glyphicon glyphicon-send"></span>
			</button>

		</form>

	</div>

	<footer>
		<%@include file="footer.html"%>
	</footer>
</body>
</html>