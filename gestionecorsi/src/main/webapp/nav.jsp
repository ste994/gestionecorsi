<nav class="navbar navbar-inverse">
	<%-- "inverse" è blu scuro, "default" grigio chiaro --%>
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target="#menu">
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="home.jsp">Home</a>
		</div>

		<div class="collapse navbar-collapse" id="menu">
			<%
			String nome = (String) session.getAttribute("nome");
			if (nome == null) {
			%>

			<ul class="nav navbar-nav navbar-right">
				<!--
				<li>
					<a href="login.jsp">
					<span class="glyphicon glyphicon-log-in"></span>  Login</a>
				</li>
			-->
				<li><a href="#" data-toggle="modal" data-target="#LoginModal">
						<span class="glyphicon glyphicon-log-in"></span> Login
				</a> <!-- Modal -->
					<div class="modal fade" id="LoginModal" role="dialog">
						<div class="modal-dialog modal-md">
							<form
								action="/<%=application.getServletContextName()%>/controlloLogin"
								method="post" id="userForm" class="form-horizontal">
								<div class="modal-content">
									<div class="modal-header">
										<button type="button" class="close" data-dismiss="modal"></button>
										<h4 class="modal-title">Inserisci nome e password</h4>
									</div>
									<div class="modal-body">

										<!------------------------------NOMEADMIN----------------------------------->
										<div class="form-group">
											<label class="col-md-4 control-label">Nome</label>
											<div class="col-md-6 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-user"></i>
													</span> <input type="text" name="nome" id="nome"
														placeholder="Nome..." class="form-control">
												</div>
											</div>
										</div>

										<!------------------------------PASSWORD----------------------------------->
										<div class="form-group">
											<label class="col-md-4 control-label">Password</label>
											<div class="col-md-6 inputGroupContainer">
												<div class="input-group">
													<span class="input-group-addon"> <i
														class="glyphicon glyphicon-lock"></i>
													</span> <input type="password" name="password" id="password"
														placeholder="Password..." class="form-control">
												</div>
											</div>
										</div>

									</div>
									<div class="modal-footer">
										<button type="button" class="btn btn-default"
											data-dismiss="modal">Annulla</button>
										<button type="submit" class="btn btn-success btn-1">Accedi</button>
									</div>
								</div>
								<!-- /.modal-content -->
							</form>
						</div>
						<!-- /.modal-dialog -->
					</div>
					<!-- /.modal --></li>
			</ul>

			<%
			} else {
			%>

			<ul class="nav navbar-nav">
				<li><a href="corsi.jsp">Lista corsi</a></li>
				<li><a href="corsisti.jsp">Lista corsisti</a></li>
				<li><a href="statistiche.jsp">Statistiche</a></li>
			</ul>

			<ul class="nav navbar-nav navbar-right">
				
				<li>
					<a href="#">
						<span class="glyphicon glyphicon-user"></span>  <%=nome%>
					</a>
				</li>

				<li>
					<a href="logout.jsp"> <span
						class="glyphicon glyphicon-log-out"></span> Logout
					</a>
				</li>
			</ul>

			<%
			}
			%>
		</div>
	</div>
</nav>