package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("resultado")
public class indexController {

	@RequestMapping("/")
	public String showIndex(Model model)
	{
		model.addAttribute("resultado","Resultado de la Session");
		return "index";
	}
	
	@RequestMapping("/about")
	public String showAbout(SessionStatus session)
	{
		session.setComplete();
		return "about";
	}
	

}
