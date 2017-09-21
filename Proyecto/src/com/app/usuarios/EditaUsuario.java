package com.app.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != "") {
			UsuarioImpl obj = new UsuarioImpl();
			Usuario usr = new Usuario();
			usr.setId(request.getParameter("id"));
			usr.setNombre(request.getParameter("nombre"));
			usr.setUsuario(request.getParameter("usuario"));
			usr.setPassword(request.getParameter("password"));
			int res = obj.editaUsuario(usr);
			RequestDispatcher disp = request.getRequestDispatcher("qry_usuarios.jsp");
			String msgEdita = "";
			
			if (res == 1) {
				msgEdita = "Registro editado OK";
			}
			else
			{
				msgEdita = "Registro no se pudo editar";
			}
			request.setAttribute("msgEdita", msgEdita);
			disp.forward(request, response);
		}
	}

}
