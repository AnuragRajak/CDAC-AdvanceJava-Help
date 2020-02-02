package com.app.controller;

import java.time.LocalDateTime;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller // mandatory
@RequestMapping("/test") // optional BUT reco.
public class TestController {
	public TestController() {
		System.out.println("in constr of " + getClass().getName());
	}

	@GetMapping("/test1")
	public String sayHello() {
		System.out.println("in say hello");
		return "/welcome";
	}

	@GetMapping("/test2")
	public ModelAndView sayHello2() {
		System.out.println("in say hello2");
		return new ModelAndView("/welcome", "num_list", Arrays.asList(1, 2, 3, 4, 5));
	}
//key /test/test3:requeestMethod=get 
	//value : com.app.controller.TestController.sayHello3(map)
	@GetMapping("/test3")
	public String sayHello3(Model map) {
		System.out.println("in say hello3 " + map);
		map.addAttribute("num_list", Arrays.asList(11, 21, 31, 41, 51));
		map.addAttribute("server_date_tm", LocalDateTime.now());
		System.out.println("map again "+map);
		return "/welcome";
	}

}
