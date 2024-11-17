<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
  <meta charset="UTF-8">
  <title>Mostrar Sueldo de Empleado</title>
  <link rel="stylesheet" type="text/css" href="../static/CSS/styles.css">
</head>
<body>
<h1>Resultado de la Búsqueda de Sueldo</h1>

<div th:if="${sueldo != null}">
  <p>El sueldo del empleado es: <strong th:text="'$' + ${sueldo}"></strong></p>
</div>
<div th:if="${error != null}">
  <p style="color: red;"><strong>Error:</strong> <span th:text="${error}"></span></p>
</div>
<div th:if="${sueldo == null and error == null}">
  <p>No se ha podido encontrar el sueldo. Por favor, intente de nuevo.</p>
</div>

<a class="volver" th:href="@{/empresa/empleado/buscarSueldo}">Buscar otro sueldo</a>
<a class="volver" th:href="@{/}">Volver al Menú</a>
</body>
</html>
