package com.mthree;
import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;
public class HelloTag extends SimpleTagSupport {
	private String name;
	private PageContext pageContext = null;
	
	public HelloTag() {
		System.out.println("Inside HelloTag Constructor");
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
		System.out.println("Inside SetName of HelloTag");
	}
	@Override
	public void doTag() throws JspException, IOException {
		System.out.println("Inside doTag of HelloTag");
		pageContext = (PageContext) getJspContext();
		JspWriter out = pageContext.getOut();
		out.println("Welcome to custom tag " + this.name);
	}
	
	
}





//could I get a copy of HelloTag.java contents please?