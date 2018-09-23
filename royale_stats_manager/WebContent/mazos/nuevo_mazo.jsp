<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="model.GestionCartas, java.util.ArrayList, entities.Carta"%>

<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>Nuevo Mazo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
</head>
<body>
	
	<c:set var="cartas" value="${requestScope.cartas}" />
	
	<form action="ControladorMazos?op=doAltaMazo" method="post" onsubmit="return comprobar();">
	Nombre:<input id="nombre" type="text" name="nombre" /> <br /> 
		<c:choose>
			<c:when test="${!empty cartas}">
				<table border="1">
					<tr>
						<th></th>
						<th>Nombre</th>
						<th>Coste</th>
					</tr>
					<% int i = -1; %>
					<c:forEach var="carta" items="${cartas}">
						<tr>
							<td>      
								<input type="checkbox" id="${carta.id}" name="${carta.id}" value="true" />
	        					<label for="incluirCarta">Incluir</label> 
        					</td>
							<td>${carta.nombre}</td>
							<td>${carta.coste}</td>
						</tr>
					</c:forEach>
				</table>
			</c:when>
			<c:otherwise>
				<h1>No hay Cartas</h1>
			</c:otherwise>
		</c:choose>
		<input type="submit" value="Guardar" />
	</form>
</body>
</html>