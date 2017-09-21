package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class RecibePOST extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("Los datos enviados son: <br>");
		
		String nombre = request.getParameter("nombre");
		String apaterno = request.getParameter("apaterno");
		String amaterno = request.getParameter("amaterno");
		
		out.println("Nombre: " + nombre + "<br>");
		out.println("Apellido Paterno: " + apaterno + "<br>");
		out.println("Apellido Materno: " + amaterno + "<br>");
		out.println("<a href='enviaPOST.jsp'>Regresar</a>");
		
	}

}
