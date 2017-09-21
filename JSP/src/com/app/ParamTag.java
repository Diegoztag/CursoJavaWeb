package com.app;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class ParamTag extends SimpleTagSupport {
	
	private String mensaje;
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	@Override
	public void doTag() throws JspException, IOException {
		
		JspWriter out = getJspContext().getOut();
		out.print("Mensaje del atributo desde la clase: " + this.mensaje);
		
		System.out.println("Valor del atributo: " + this.mensaje);
		
		
	}
		
}
