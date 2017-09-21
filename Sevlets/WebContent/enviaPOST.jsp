<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	
 <form action="RecibeePOST" method="POST">
 	<table>
 		<tr>
 			<td align="right">Nombre</td>
 			<td><input type="text" name="nombre"></td>
 		</tr>

 		<tr>
 			<td align="right">Apellido Materno</td>
 			<td><input type="text" name="amaterno"></td>
 		</tr>

 		 <tr>
 			<td colspan="2" align="center"></td>
 			<td><input type="submit" value="Enviar"></td>
 		</tr>
 	</table>
 </form>
 
</body>
</html>