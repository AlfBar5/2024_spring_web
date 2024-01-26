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
		
		
<table class='table table-light'>
		
		
	<thead>
      <tr>
        <th style="text-align:center;">NOMBRE</th>
        <th style="text-align:center;">PRECIO</th>
        <th style="text-align:center;">CATEGORIA</th>
      </tr>
    </thead>
	
		 <c:forEach var="r" items="${resultados}">
	                
	        		<tr>     
	       <td style="text-align:center;">${r.nombre}</td>
	        		
	        <td style="text-align:center;">	${r.precio}</td>
	        	
	        <td style="text-align:center;">	${r.categoria}</td>
	        	
	        </tr>
	        	
	        </c:forEach>
        
        
	
		</div>

		<div class="col-md-4 order-md-2 mb-4"></div>
	
	</div>
	
<br><br>
	
	
	
	
	
<div class="row">
        <div class="col-md-2 order-md-2 mb-2" > </div>
	
		<div class="col-md-8 order-md-2 mb-8" align="center" class="table">
	
		
	
		</div>

		<div class="col-md-2 order-md-2 mb-2"></div>
	
</div>	
	
	
	
<div class="row">
        <div class="col-md-4 order-md-2 mb-4" > </div>
	
		<div class="col-md-4 order-md-2 mb-4" align="center">
	
		<a href="toMenu">VOLVER</a>
	
		</div>

		<div class="col-md-4 order-md-2 mb-4"></div>
	
</div>	

</body>
</html>