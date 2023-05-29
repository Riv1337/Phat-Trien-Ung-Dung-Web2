<%@ page language="java" contentType="text/html; charset=UTF-8"   pageEncoding="UTF-8"%>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/tainguyen/css/bootstrap4/bootstrap.min.css">
<!-- My CSS -->
<link rel="stylesheet" href="${pageContext.request.contextPath}/tainguyen/css/my.css">
 
<title>Website ABC</title>
</head>
<body>
<!-- Dau trang -->
<div class="container-fluid" style="background-color: red; height: 80px "> 
	<div class="container"> 
	<img alt="" style="min-height: 80px" src="${pageContext.request.contextPath}/tainguyen/images/logo.png"> 
	</div> 
</div>
<div id=menu-wrap class="container-fluid" style="background-color: #55db11;">
	
<div class="container">
	<!-- Menu -->		
	<nav class="navbar navbar-expand-lg navbar-light bg-light" style="background-color: #55db11 !important">
	  
	  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
	    <span class="navbar-toggler-icon"></span>
	  </button>
	  <div class="collapse navbar-collapse" id="navbarNav">
	    <ul class="navbar-nav">
	      <li class="nav-item active">
	        <a class="nav-link" href="${pageContext.request.contextPath}/home.html">Home <span class="sr-only">(current)</span></a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/about.html">About</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/en.html">English</a>
	      </li>
	      <li class="nav-item">
	        <a class="nav-link" href="${pageContext.request.contextPath}/vi.html">Vietnamese</a>
	      </li>
	    </ul>
	  </div>
	</nav>
 </div>
</div>

<div class="container" style="min-height: 500px;">
	<div class="row">
  		<div class="col-8">   	
  				<jsp:include page="${param.view}"/> 
  		</div>
  		<div class="col-4" style ="background-color: gray; min-height: 500px;">SIDE BAR Ở ĐÂY</div>
	</div>
</div>

<div class="container-fluid">
	<div class="row" style="background-color: green;">
  		 CHÂN TRANG Ở ĐÂY
	</div>
</div>


		
		
		
		
<!-- Javascript file -->		
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>

<script src="${pageContext.request.contextPath}/tainguyen/js/bootstrap4/bootstrap.min.js"></script>  
</body>
</html>