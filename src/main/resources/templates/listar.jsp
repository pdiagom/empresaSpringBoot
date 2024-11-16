<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Listar Productos</title>
    <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
<c:if test="${empty lista}">
    <p class="error vacio">No se encontraron empleados durante la busqueda</p>
</c:if>
 <h1>Listar Empleados</h1>
 <table border="1">
  <tr>
   <td>DNI</td>
   <td>Nombre</td>
   <td>Sexo</td>
   <td>Categoria</td>
   <td>Años Trabajados</td>
   <td>Accion</td>
  </tr>
  <c:forEach var="empleado" items="${lista}">
  <tr>
    <td>

        <div class="tooltip">
            <a href="empresa?modulo=empleados&opcion=meditar&dni=<c:out value="${empleado.dni}"></c:out>"><c:out value="${empleado.dni}"></c:out></a>
            <span class="tooltiptext">Pincha para editar</span>
        </div>
    </td>
    <td><c:out value="${empleado.nombre}"></c:out></td>
    <td><c:out value="${empleado.sexo}"></c:out></td>
    <td><c:out value="${empleado.categoria}"></c:out></td>
    <td><c:out value="${empleado.anyos}"></c:out></td>
    <td>
        <a href="empresa?modulo=empleados&opcion=eliminar&dni=<c:out value="${empleado.dni}"></c:out>">Eliminar</a>
    </td>
  </tr>
  </c:forEach>
 </table>
 <a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
</body>
</html>