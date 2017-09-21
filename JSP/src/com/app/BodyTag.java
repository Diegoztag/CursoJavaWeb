package com.app;

import java.io.IOException;
import java.io.StringWriter;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class BodyTag extends SimpleTagSupport {
	
	StringWriter sw = new StringWriter();

	@Override
	public void doTag() throws JspException, IOException {
		getJspBody().invoke(sw);
		System.out.println("Contenido del body: ");
		
		System.out.println(sw.toString());
	}
}
