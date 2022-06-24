package com.mthree.BootWebDemo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping(value="/hello", method=RequestMethod.GET)
	public ModelAndView sayHello() {
		System.out.println("Invoking business layer..");
		ModelAndView mav = new ModelAndView();
		mav.addObject("msg", "Welcome to spring boot MVC");
		mav.setViewName("hello");
		return mav;
				
	}
}
