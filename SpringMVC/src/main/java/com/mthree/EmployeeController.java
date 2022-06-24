package com.mthree;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class EmployeeController {
	
	@RequestMapping(method=RequestMethod.GET, value= "/saveemp.htm")
	public String showEmpForm(Map<String, Employee>map) {
		System.out.println("Inside showEmpForm of Employee Controller");
		map.put("emp", new Employee());
		return "empForm";
	}
	
	@RequestMapping(method=RequestMethod.POST, value= "")
	public String persistEmployee(int id, String fname , String lname, Map<String, Employee> map) {
		
		
		return null;
	}
	
	@RequestMapping(method =RequestMethod.GET, value="/changeLocale.htm")
	public String selectLanguage(String lang) {
		return null;
		//SessionLocaleResolver.LOCALE_SESSION_ATTRIBUTE_NAME
		//return "redirect:saveemp.htm";

	}

}
