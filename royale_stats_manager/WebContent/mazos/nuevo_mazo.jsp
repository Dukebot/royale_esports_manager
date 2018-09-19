<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Nuevo Mazo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<!-- recuperamos la lista de cartas del servlet que nos ha traido aquí -->
	<c:set var="cartas" value="${requestScope.cartas}" />
	
	<!-- Miramos si hay alguna carta en la variable cartas -->
	<c:choose>
		<c:when test="${!empty cartas}">
		
			<!-- tabla donde se muestra la lista de cartas para seleccionar las que queremos incluir en el mazo -->
			<table border="1">
				<tr>
					<th></th>
					<th>Nombre</th>
					<th>Coste</th>
				</tr>
				<c:forEach var="carta" items="${cartas}">
					<tr>
						<td> Aquí va un checkbox para seleccionar la carta... </td>
						<td>${carta.nombre}</td>
						<td>${carta.coste}</td>
					</tr>
				</c:forEach>
			</table>
			
		</c:when>
		
		<!-- Si la lista recuperada no contiene cartas, entonces mostramos un mensaje -->
		<c:otherwise>
			<h1>No hay Cartas</h1>
		</c:otherwise>
	</c:choose>
	
	
	<!--
		Pendiente!!!!!
		Seguramente el choose anterior se deberá meter dentro del formulario, ya que tendremos en cuenta las cartas que han sido seleccionadas!
		Es una idea, ya veremos como lo haremos
	-->
	
	<form action="ControladorMazos?op=doAltaMazo" method="post" onsubmit="return comprobar();">
		Nombre:<input id="nombre" type="text" name="nombre" /> <br /> 
		Coste:<input id="coste" type="text" name="coste" /> <br /> 
		<input type="submit" value="Guardar" />
	</form>
</body>
</html>
