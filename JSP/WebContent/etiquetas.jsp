<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="WEB-INF/tdls/custom.tld" prefix="ct" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 	<h2>Etiqueta Personalizada</h2>
 	<ct:hola_mundo/>
 	<br>
 	<hr>
 	<ct:hola_param mensaje="Desde el JSP"/>
	<br>
 	<hr>
 	<ct:holaBody>
 		Corria el año de 1985 cuando ocurrio el temblor..
 	</ct:holaBody>
</body>
</html>