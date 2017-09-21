<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form action="" method="POST">
		Nombre: <input type="text" name="nombre" id="">
		<br>
		Apellido: <input type="text" name="apellidos" id="">
		<br>
		<input type="submit" value="Enviar">
	</form>
	
	<h2>Datos recibidos</h2>
	
	Nombre: <c:out value="${param.nombre}" /><br>
	Apellidos: <c:out value="${param.apellidos}" /><br>
</body>
</html>