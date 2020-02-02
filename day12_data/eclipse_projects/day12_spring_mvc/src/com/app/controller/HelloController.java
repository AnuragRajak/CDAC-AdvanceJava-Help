package com.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //mandatory
//singleton n eager
public class HelloController {
	public HelloController() {
		System.out.println("in constr of " + getClass().getName());
	}
	//mandatory
	@RequestMapping("/hello")
	public String sayHello()
	{
		System.out.println("in say hello");
		return "/welcome";
	}
	
	

}
