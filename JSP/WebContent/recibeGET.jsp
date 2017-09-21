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
	<h2>Escoje tu color preferido</h2>
	<a href="<c:out value="${pageContext.request.requestURI}" />?color=1">Rojo</a>
	<a href="<c:out value="${pageContext.request.requestURI}" />?color=2">Amarillo</a>
	<a href="<c:out value="${pageContext.request.requestURI}" />?color=3">Verde</a>
	
	Tu color favorito es: <b> ${param.color}</b>
</body>
</html>