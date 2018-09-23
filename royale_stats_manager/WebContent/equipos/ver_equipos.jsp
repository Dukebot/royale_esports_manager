<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionEquipos, java.util.ArrayList, entities.Equipo"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Equipos</title>
</head>
<body>

	<br />
	<a href="ControladorEquipos?op=toNuevoEquipo">Nuevo Equipo</a>
	<br />
	<a href="Controlador?op=toMenu">Menu</a>

	<c:set var="equipos" value="${requestScope.equipos}" />

	<br />
	<br />
	<br />

	<c:choose>
		<c:when test="${!empty equipos}">

			<table border="1">
				<tr>
					<th>Nombre</th>
					<th></th>
				</tr>

				<c:forEach var="equipo" items="${equipos}">
					<tr>
						<td>${equipo.nombre}</td>
						<td><a href="ControladorEquipos?op=doEliminarEquipo&idEquipo=${equipo.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay Equipos</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>