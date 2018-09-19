<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionMazos, java.util.ArrayList, entities.Mazo"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Mazos</title>
</head>
<body>

	<br />
	<a href="ControladorMazos?op=doToNuevoMazo">Nuevo Mazo</a>
	<br />
	<a href="Controlador?op=toMenu">Menu</a>

	<c:set var="mazos" value="${requestScope.mazos}" />

	<br />
	<br />
	<br />

	<c:choose>
		<c:when test="${!empty mazos}">

			<table border="1">
				<tr>
					<th>Carta 1</th>
					<th>Carta 2</th>
					<th>Carta 3</th>
					<th>Carta 4</th>
					<th>Carta 5</th>
					<th>Carta 6</th>
					<th>Carta 7</th>
					<th>Carta 8</th>
					<th></th>
				</tr>

				<c:forEach var="mazo" items="${mazos}">
					<tr>
						<td>${mazo.carta1.getNombre()}</td>
						<td>${mazo.carta2.getNombre()}</td>
						<td>${mazo.carta3.getNombre()}</td>
						<td>${mazo.carta4.getNombre()}</td>
						<td>${mazo.carta5.getNombre()}</td>
						<td>${mazo.carta6.getNombre()}</td>
						<td>${mazo.carta7.getNombre()}</td>
						<td>${mazo.carta8.getNombre()}</td>
						<td><ahref="ControladorMazos?op=doEliminarMazo&idMazo=${mazo.id}">Eliminar</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:when>
		<c:otherwise>
			<h1>No hay Mazos</h1>
		</c:otherwise>
	</c:choose>
</body>
</html>