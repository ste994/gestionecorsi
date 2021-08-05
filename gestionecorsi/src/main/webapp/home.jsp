<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="head.jsp"%>
<title>Home page</title>
<link rel="stylesheet" href="css/style.css">
</head>
<body>
<jsp:include page="nav.jsp" />
	<div class="container">
	<div class="well" style="background-coor:#111">
	<h3 style="color: #FFF"> Corso on-line</h3>
	</div>
		<div class="page-header">
			<h3>Corsi disponibili</h3>
		</div>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
  <!-- Indicators -->
  <ol class="carousel-indicators">
    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    <li data-target="#myCarousel" data-slide-to="1"></li>
    <li data-target="#myCarousel" data-slide-to="2"></li>
  </ol>

  <!-- Wrapper for slides -->
  <div class="carousel-inner">
    <div class="item active">
      <img src="img/airpods.png" alt="Airpods">
    </div>

    <div class="item">
      <img src="img/iphone.png" alt="iPhone">
    </div>

    <div class="item">
      <img src="img/s20.png" alt="Samsung">
    </div>
  </div>

  <!-- Left and right controls -->
  <a class="left carousel-control" href="#myCarousel" data-slide="prev">
    <span class="glyphicon glyphicon-chevron-left"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="right carousel-control" href="#myCarousel" data-slide="next">
    <span class="glyphicon glyphicon-chevron-right"></span>
    <span class="sr-only">Next</span>
  </a>
</div>
</div>
<footer><%@include file="footer.html"%></footer>
</body>
</html>