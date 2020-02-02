package com.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.app.dao.IVoterDao;
import com.app.pojos.Voter;

@Controller //mandatory
@RequestMapping("/voter") //optional
public class VoterController {
	//dependency
	@Autowired 
	private IVoterDao dao;
	
	public VoterController() {
		System.out.println("in voter controller constr "+dao);
	}
	//request handling method to show login form
	@GetMapping("/login") //=@RequestMapping + method=get
	public String showLoginForm()
	{
		System.out.println("in show login form");
		return "/voter/login";
	}
	//request handling method to process login form
	@PostMapping("/login")
	public String processLoginForm(@RequestParam String email,
			@RequestParam String password,Model map)
	{
		System.out.println("in process login form "+email+" "+password+" "+map);
		try {
		Voter v=dao.authenticateVoter(email, password);
		} catch (RuntimeException e) {
			//invalid login --forward clnt to login form
			//add err mesg in model map -- request scope
			map.addAttribute("mesg", "Invalid login , pls retry...");
			return "/voter/login";
		}
		//login success
		map.addAttribute("mesg", "Login Successful");
		return "/candidate/list";
	}

}
