package com.app.usuarios;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EliminaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		UsuarioImpl obj = new UsuarioImpl();
		String id = request.getParameter("id");
		int res = obj.eliminaUsuario(id);
		RequestDispatcher disp = request.getRequestDispatcher("qry_usuarios.jsp");
		String msg;
		
		if (res == 1) {
			msg = "Registro eliminado OK";
		}
		else
		{
			msg = "No se elimino el registro";
		}
		request.setAttribute("msg", msg);
		disp.forward(request, response);
		
	}


}
