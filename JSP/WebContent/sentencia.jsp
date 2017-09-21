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
	<c:set var="sueldo" value="${2000*2}" />
	<c:if test ="${sueldo > 2000}">
		<p>Sueldo: <c:out value="${sueldo}"/> </p>
	</c:if>
	
	<hr>
	
<form action="" method="POST">
	Status:
	<select name="status">
		<option value="1">Activo</option>
		<option value="2">Inactivo</option>
	</select>
	<input type="submit" value="Enviar">
</form>

<c:if test="${pageContext.request.method == 'POST'}">
	Formulario enviado <br>
	<c:choose>
		<c:when test="${param.status == 1}">
			Transaccion Activa
		</c:when>
		<c:otherwise>
			Otra opcion
		</c:otherwise>
	</c:choose>
</c:if>
	
</body>
</html>