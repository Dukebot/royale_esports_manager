<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionEquipos, java.util.ArrayList, entities.Equipo"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>Nuevo Jugador</title>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript">
	
	function comprobar() {
		if (document.getElementById("nombre").value == "") {
			alert("faltan datos");
			return false;
		} else {
			return true;
		}
	}
</script>
</head>
<body>

	<c:set var="equipos" value="${requestScope.equipos}" />

	<form action="ControladorJugadores?op=doAltaJugador" method="post" onsubmit="return comprobar();">
		Nombre:<input id="nombre" type="text" name="nombre" /> <br />  
		Equipo:
		<select name="seleccionEquipo">
			<c:forEach var="equipo" items="${equipos}">
				<option value="${equipo.id}">"${equipo.nombre}"</option> <br />
			</c:forEach>
		</select>
		<input type="submit" value="Guardar" />
	</form>
</body>
</html>
