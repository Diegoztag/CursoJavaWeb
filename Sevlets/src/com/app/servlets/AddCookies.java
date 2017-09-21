package com.app.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddCookies extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Cookie cookie1 = new Cookie("genero", "masculino");
		response.addCookie(cookie1);
		
		Cookie cookie2 = new Cookie("edad", "22");
		response.addCookie(cookie2);
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("Cookies almacenadas de forma correcta");
	}

}
