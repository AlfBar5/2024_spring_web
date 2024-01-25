<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>RESULTADOS BUSCADOR</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>

<body class="bg-light">

<br><br>
	
	<div class="row">
        <div class="col-md-4 order-md-2 mb-4" > </div>
	
		<div class="col-md-4 order-md-2 mb-4" align="center">
	
		 <c:forEach var="r" items="${resultados}">
	                
	        	<h6><a href="${r.url}">${r.url}</a></h6>
	        		
	        	<h5>${r.descripcion}</h4>
	        	<hr>
	        </c:forEach>
        
        
	
		</div>

		<div class="col-md-4 order-md-2 mb-4"></div>
	
	</div>
	
<br><br>
	
	
	
<div class="row">
        <div class="col-md-4 order-md-2 mb-4" > </div>
	
		<div class="col-md-4 order-md-2 mb-4" align="center">
	
		<a href="toMenu">VOLVER</a>
	
		</div>

		<div class="col-md-4 order-md-2 mb-4"></div>
	
</div>	

</body>
</html>