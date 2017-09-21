<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.app.usuarios.UsuarioImpl"%>
<%@page import="java.util.List"%>
<%@page import="com.app.usuarios.Usuario"%>
<%

UsuarioImpl obj = new UsuarioImpl();
List<Usuario> lista = obj.getUsuarios();
pageContext.setAttribute("listap", lista);
%>

<p>${msg}</p>
<table border="1">
	<tr>
		<th>nombre</th>
		<th>Usuario</th>
		<th>password</th>
		<th>Editar</th>
		<th>Eliminar</th>
	</tr>
	<c:forEach var="usr" items="${listap}">
		<tr>
			<td>${usr.nombre}</td>
			<td>${usr.usuario}</td>
			<td>${usr.password}</td>
			<td>
				<a href="qry_usuarios.jsp?id= ${usr.id}">Editar</a>
			</td>
			<td>
				<a href="EliminaUsuario?id= ${usr.id}" onclick="return confirm('Esta seguro que desea eliminar?')">Eliminar</a>
			</td>
		</tr>	
	</c:forEach>
</table>

<c:if test="${param.id != null}">
<h3>${msgEdita}</h3>
<%
	Usuario usr = obj.getUsuarioByID(request.getParameter("id"));
%>
	<form action = "EditaUsuario" method="POST">
		<table>
			<tr>
				<td>Nombre</td>
				<td><input type="text" name="nombre" value="<%=usr.getNombre()%>"></td>
			</tr>
	
			<tr>
				<td>Usuario</td>
				<td><input type="text" name="usuario" value="<%=usr.getUsuario()%>"></td>
			</tr>
			
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" value="<%=usr.getPassword()%>"></td>
			</tr>
			
			<tr>
				<td></td>
				<td>
					<input type="submit" value="Guardar">
					<input type="hidden" name="id" value="<%=usr.getId()%>">
				</td>
			</tr>
		</table>
	</form>
</c:if>

