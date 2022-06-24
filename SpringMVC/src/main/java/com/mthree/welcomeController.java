package com.mthree;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;


public class welcomeController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		
		System.out.println("Inside handleRequest of welcomeController");	
		System.out.println("Giving call to service layer");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "welcome to spring MVC");
		mav.setViewName("hello");	
		return mav;
	}

}
