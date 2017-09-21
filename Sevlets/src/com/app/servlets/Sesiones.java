package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Sesiones extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession sess = request.getSession(true);
		Integer counter = (Integer) sess.getAttribute("contador");
		
		if (counter == null) {
			counter = 1;
		}
		else 
		{
			counter += 1;
		}
		sess.setAttribute("contador", counter);
		out.println("Tus visitas al sitio: " + counter);
		
		Date fecha_acceso = new Date(sess.getLastAccessedTime());
		out.print("<br> Ultimo Acceso: " + fecha_acceso);
		
		Date fecha_crea = new Date(sess.getCreationTime());
		out.print("<br> Fecha de creacion: " + fecha_crea);
		
		out.print("<br> Tiempo de timeout: " + sess.getMaxInactiveInterval());
		
	}

}
