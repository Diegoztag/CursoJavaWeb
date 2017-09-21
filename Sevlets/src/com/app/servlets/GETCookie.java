package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class GETCookie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Cookie[] cookies = request.getCookies();
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		
		for( int i=0; i < cookies.length; i++) {
			String nombre = cookies[i].getName();
			String valor = cookies[i].getValue();
			out.println("Nombre: " + nombre + " - Valor: " +valor+ "<br>");
		}
	}

}
