<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionJugadores, java.util.ArrayList, entities.Jugador"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Jugadores</title>
</head>
<body>

	<br />
	<a href="ControladorJugadores?op=doToNuevoJugador">Nuevo Jugador</a>
	<br />
	<a href="Controlador?op=toMenu">Menu</a>

	<c:set var="jugadores" value="${requestScope.jugadores}" />

	<br />
	<br />
	<br />

	<c:choose>
		<c:when test="${!empty jugadores}">

			<table border="1">
				<tr>
					<th>Nombre</th>
					<th>Equipo</th>
					<th></th>
				</tr>

				<c:forEach var="jugador" items="${jugadores}">
					<tr>
						<td>${jugador.nombre}</td>
						<th>${jugador.getEquipo().getNombre()}</th>
						<td><a href="ControladorJugadores?op=doEliminarJugador&idJugador=${jugador.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay Jugadores</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>