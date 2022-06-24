package com.mthree;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value ="/hello")
public class HelloController {

	@RequestMapping(method= RequestMethod.GET, value ="/abc.htm")
	public String sayHello() {
		System.out.println("Inside sayHello1 of HelloController");
		System.out.println("Invoking service / business layer 1 ...");
		return "hello";
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/pqr.htm")
	public String sayHello2(Model model) {
		System.out.println("Inside sayHello2 of HelloController");
		System.out.println("Invoking service / business layer 2 ...");
		model.addAttribute("msg", "welcome to spring MVC annotations");
		return "hello";
		
	}
	
	@RequestMapping(method= RequestMethod.GET, value ="/xyz.htm")
	public String sayHello3(Map<String,String> map) {
		System.out.println("Inside sayHello3 of HelloController");
		System.out.println("Invoking service / business layer 3 ...");
		map.put("msg", "Welcome to spring MVC Annotations");
		return "hello";
		
	}
	
}
