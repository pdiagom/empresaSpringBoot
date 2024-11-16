<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Crear Empleado</title>
 <link rel="stylesheet" type="text/css" href="../empresa/CSS/styles.css">
</head>
<body>
 <h1>Crear Empleado</h1>
 <form action="empresa" method="post">
  <input type="hidden" name="modulo" value="empleados">
  <input type="hidden" name="opcion" value="guardar">
  <table border="1">
   <tr>
    <td>DNI:</td>
    <td><input type="text" name="dni" size="9" required></td>
   </tr>
   <tr>
   <tr>
    <td>Nombre:</td>
    <td><input type="text" name="nombre" size="50" required></td>
   </tr>
   <tr>
    <td>Sexo:</td>
    <td><select name="sexo" id="sexo" required>
     <option value="M">Masculino</option>
     <option value="F">Femenino</option>
    </select><br><br></td>
   </tr>
   <tr>
    <td>Categoria:</td>
    <td><input type="text" name="categoria" size="50" ></td>
   </tr>
   <tr>
    <td>Años trabajados:</td>
    <td><input type="text" name="anyos" size="50"></td>
   </tr>
  </table>
  <input type="submit" value="Guardar">
  <a class="volver" href="../empresa/index.jsp">Volver al Menú</a>
 </form>
</body>
</html>