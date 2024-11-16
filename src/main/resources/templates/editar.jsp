<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Editar Empleado</title>
 <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
 <h1>Editar Empleado</h1>
 <form action="empresa" method="post">
  <c:set var="empleado" value="${empleado}"></c:set>
  <input type="hidden" name="modulo" value="empleados">
  <input type="hidden" name="opcion" value="editar">

  <table border="1">
   <tr>
    <td>DNI</td>
    <td><input type="text" name="dni" value="${empleado.dni}" readonly></td>
   </tr>
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50" value="${empleado.nombre}" required></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td>
     <select name="sexo" id="sexo" value="${empleado.sexo}">
      <option value="M">Masculino</option>
      <option value="F">Femenino</option>
     </select><br><br>
   </tr>
   <tr>
    <td>Categoria:</td>
    <td><input type="text" name="categoria" size="50" value="${empleado.categoria}"></td>
   </tr>
   <tr>
    <td>Años trabajados:</td>
    <td><input type="text" name="anyos" size="50" value="${empleado.anyos}"></td>
   </tr>
  </table>
  <input type="submit" value="Guardar">
  <a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
 </form>

</body>
</html>