package com.app.alumnos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("id") != "") {
			AlumnosImpl obj = new AlumnosImpl();
			Alumnos al = new Alumnos();
			al.setId(request.getParameter("id"));
			al.setNombre(request.getParameter("nombre"));
			al.setApaterno(request.getParameter("apaterno"));
			al.setAmaterno(request.getParameter("amaterno"));
			al.setMatricula(request.getParameter("matricula"));
			int res = obj.editaAlumno(al);
			RequestDispatcher disp = request.getRequestDispatcher("qry_alumnos.jsp");
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
