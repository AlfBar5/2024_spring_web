<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar nuevo producto</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<br><br>
	
	<div class="row">
	
        <div class="col-md-4 order-md-2 mb-4"> </div>
	
	<div class="col-md-4 order-md-2 mb-4">
	
	<!-- Le ponemos buscar por que lo hemos definido en el controller @GetMapping(value="buscar") -->
	<form action="alta" method="POST">
	
	NOMBRE PRODUCTO: 
	<input type="text" name="nombre" class="form-control">
	<br>
	
	PRECIO PRODUCTO: 
	<input type="text" name="precio" class="form-control">
	<br>
	CATEGORÍA: 
	<input type="text" name="categoria" class="form-control">
	<br>
	
	<br>
	<button class="btn btn-primary btn-lg btn-block" type="submit"> AÑADIR PRODUCTO </button>
	
	</form>
</div>

<div class="col-md-4 order-md-2 mb-4"></div>

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