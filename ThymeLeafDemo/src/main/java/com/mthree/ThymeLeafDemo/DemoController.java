package com.mthree.ThymeLeafDemo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DemoController {

	@GetMapping(value = "/thyme")
	public String getTemplate(@RequestParam(name="name",required=false,
	defaultValue="world") String name, Model model) {
		System.out.println("Inside getTemplate() " + name);
		System.out.println("Invoking service layer ");
		model.addAttribute("name", name);
		return  "thymetemplate";
	}
}
