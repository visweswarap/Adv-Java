package com.fita.vishwebtut.jstl;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.BodyTagSupport;

public class MessageTag extends BodyTagSupport  {

	@Override
	public int doEndTag() throws JspException {
		
		try {
			JspWriter writer = pageContext.getOut();
			writer.print("Hai... Came from JSTL");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 9;
	}
}
