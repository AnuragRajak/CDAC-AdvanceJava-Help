package com.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller

public class ShowImageController {
	@GetMapping("/show_image/{name}")
	public String showImage(@PathVariable String name,Model map)
	{
		System.out.println("in show img "+name);
		map.addAttribute("img_name", name);
		return "show_image";
	}
}
