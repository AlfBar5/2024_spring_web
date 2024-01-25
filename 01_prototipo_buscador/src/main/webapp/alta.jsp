<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Agregar nuevo Resultado</title>

<!-- Bootstrap core CSS -->
    <link href="https://getbootstrap.com/docs/4.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body class="bg-light">

<br><br>
	
	<div class="row">
	
        <div class="col-md-4 order-md-2 mb-4"> </div>
	
	<div class="col-md-4 order-md-2 mb-4">
	
	<!-- Le ponemos buscar por que lo hemos definido en el controller @GetMapping(value="buscar") -->
	<form action="doNuevoResultado" method="POST">
	
	Introduce URL: 
	<input type="text" name="url" class="form-control">
	<br>
	
	Introduce temática: 
	<input type="text" name="tematica" class="form-control">
	<br>
	Introduce Descripción: 
	<input type="text" name="descripcion" class="form-control">
	<br>
	
	<br>
	<button class="btn btn-primary btn-lg btn-block" type="submit"> AÑADIR RESULTADO </button>
	
	</form>
</div>

<div class="col-md-4 order-md-2 mb-4"></div>

</body>
</html>