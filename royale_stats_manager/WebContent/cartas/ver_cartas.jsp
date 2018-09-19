<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionCartas, java.util.ArrayList, entities.Carta"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Cartas</title>
</head>
<body>

	<br />
	<a href="ControladorCartas?op=toNuevaCarta">Nueva Carta</a>
	<br />
	<a href="Controlador?op=toMenu">Menu</a>

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
</body>
</html>