package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RecibeGET extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		String color = request.getParameter("color");
		out.print("Tu color favorito es: <br><br>");
		
		if (color.equals("1")) {
			out.print("Azul");
		}
		else if (color.equals("2")) {
			out.print("Verde");
		}
		else if (color.equals("3")) {
			out.print("Rojo");
		}
		else if (color.equals("4")) {
			out.print("Amarillo");
		}
		
		
		out.print("<br><br><a href='enviaGET.jsp'>Regresar al archivo JSP</a><br>");
	}

}
