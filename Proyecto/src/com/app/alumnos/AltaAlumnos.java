package com.app.alumnos;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AltaAlumnos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String nombre = request.getParameter("nombre");
		String apaterno = request.getParameter("apaterno");
		String amaterno = request.getParameter("amaterno");
		String matricula = request.getParameter("matricula");
		
		if (nombre != null && apaterno != null && amaterno != null && matricula != null) {
			Alumnos al = new Alumnos();
			al.setNombre(nombre);
			al.setApaterno(apaterno);
			al.setAmaterno(amaterno);
			al.setMatricula(matricula);
			AlumnosImpl obj = new AlumnosImpl();
			int res = obj.insertAlumno(al);
			String resval = "";
			RequestDispatcher desp = request.getRequestDispatcher("qry_alumnos.jsp");
			
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
