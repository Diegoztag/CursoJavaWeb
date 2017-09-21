package com.app.servlets.samples;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginUsr extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		PrintWriter out = response.getWriter();
		RequestDispatcher desp = request.getRequestDispatcher("main.jsp");
		
		if (request.getParameter("usuario") != null && request.getParameter("pass") != null) {
						
			UsuarioImpl obj = new UsuarioImpl();
			String usuario = request.getParameter("usuario");
			String password = request.getParameter("pass");
			Usuario usr = obj.getUsuarios(usuario, password);
			
			
			if (usr != null) {
				desp.forward(request, response);
				String username = usr.getNombre();
				request.setAttribute("username", username);
			}
			else
			{
				out.print("Usuario invalido");
			}
		}
	}
}