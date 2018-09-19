<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Nuevo Mazo</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	
	function comprobar() {
		if (document.getElementById("nombre").value == ""
				|| document.getElementById("coste").value == "" {
			alert("faltan datos");
			return false;
		} else {
			return true;
		}
	}
	
	function comprobarCoste() {
		if (isNaN(document.getElementById("coste").value)) {
			alert("Coste debe ser numérico");
			document.getElementById("coste").value = "";
		}
	}
</script>
</head>
<body>
	<c:set var="cartas" value="${requestScope.cartas}" />

	<br />
	<br />
	<br />

	<c:choose>
		<c:when test="${!empty cartas}">

			<table border="1">
				<tr>
					<th>Nombre</th>
					<th>Coste</th>
					<th></th>
				</tr>

				<c:forEach var="carta" items="${cartas}">
					<tr>
						<td>${carta.nombre}</td>
						<td>${carta.coste}</td>
						<td><a
							href="ControladorCartas?op=doEliminarCarta&idCarta=${carta.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay Cartas</h1>
		</c:otherwise>
	</c:choose>
	<form action="ControladorMazos?op=doAltaMazo" method="post" onsubmit="return comprobar();">
		Nombre:<input id="nombre" type="text" name="nombre" /> <br /> 
		Coste:<input id="coste" type="text" name="coste" /> <br /> 
		<input type="submit" value="Guardar" />
	</form>
</body>
</html>