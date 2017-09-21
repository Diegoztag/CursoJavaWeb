package com.app.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class AltaUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		String usuario = request.getParameter("usuario");
		String pass = request.getParameter("pass");
		
		if (nombre != null && usuario != null && pass != null) {
			Usuario usr = new Usuario();
			usr.setNombre(nombre);
			usr.setUsuario(usuario);
			usr.setPassword(pass);
			UsuarioImpl obj = new UsuarioImpl();
			int res = obj.insertaUsuario(usr);
			String resval = "";
			RequestDispatcher desp = request.getRequestDispatcher("alta_usuario.jsp");
			
			if (res == 1) {
				resval = "Registro OK";
			}
			else
			{
				resval = "Registro Fail";
			}
			request.setAttribute("resp", resval);
			desp.forward(request, response);
		}
		
	}

}
