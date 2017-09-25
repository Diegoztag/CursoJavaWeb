<%@page import="com.app.alumnos.Alumnos"%>
<%@page import="com.app.alumnos.AlumnosImpl"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.app.usuarios.Usuario"%>
<%@taglib uri="/WEB-INF/tlds/custom" prefix="ct" %>
<%

AlumnosImpl obj = new AlumnosImpl();
List<Alumnos> lista = obj.getAlumnos();
pageContext.setAttribute("listap", lista);
%>

<p>${msg}</p>
<table border="1">
	<tr>
		<th>Nombre</th>
		<th>Apellido paterno</th>
		<th>Apellido materno</th>
		<th>Matricula</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach var="al" items="${listap}">
		<tr>
			<td>${al.nombre}</td>
			<td>${al.apaterno}</td>
			<td>${al.amaterno}</td>
			<td>${al.matricula}</td>
			<td>
				<a href="qry_alumnos.jsp?id= ${al.id}">Editar</a>
			</td>
			<td>
				<a href="EliminaAlumno?id= ${al.id}" onclick="return confirm('Esta seguro que desea eliminar?')">Eliminar</a>
			</td>
		</tr>	
	</c:forEach>
</table>

<c:if test="${param.id != null}">
<h3>${msgEdita}</h3>
<%
	Alumnos al = obj.getAlumnoByID(request.getParameter("id"));
%>
	<form action = "EditaAlumno" method="POST">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="<%=al.getNombre()%>"></td>
			</tr>
	
			<tr>
				<td>Apellido paterno</td>
				<td><input type="text" name="apaterno" value="<%=al.getApaterno()%>"></td>
			</tr>
			
			<tr>
				<td>Apellido materno</td>
				<td><input type="text" name="amaterno" value="<%=al.getAmaterno()%>"></td>
			</tr>
			
			<tr>
				<td>Matricula</td>
				<td><input type="text" name="matricula" value="<%=al.getMatricula()%>"></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Guardar">
					<input type="hidden" name="id" value="<%=al.getId()%>">
				</td>
			</tr>
		</table>
	</form>
</c:if>