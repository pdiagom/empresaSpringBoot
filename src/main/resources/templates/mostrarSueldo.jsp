<%--
  Created by IntelliJ IDEA.
  User: usuario
  Date: 17/10/2024
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Mostrar Sueldo de Empleado</title>
  <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
<h1>Resultado de la Búsqueda de Sueldo</h1>

<c:choose>
  <c:when test="${not empty sueldo}">
    <p>El sueldo del empleado es: <strong>$<c:out value="${sueldo}"/></strong></p>
  </c:when>
  <c:when test="${not empty error}">
    <p style="color: red;"><strong>Error:</strong> <c:out value="${error}"/></p>
  </c:when>
  <c:otherwise>
    <p>No se ha podido encontrar el sueldo. Por favor, intente de nuevo.</p>
  </c:otherwise>
</c:choose>

<a class="volver" href="empresa?modulo=nominas&opcion=buscarSueldo">Buscar otro sueldo</a>


<a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
</body>
</html>
