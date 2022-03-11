package com.azteca.cajero.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.azteca.cajero.dao.models.pojos.IdentifyUser;
import com.azteca.cajero.utils.RandomNumbers;

@Controller
public class HelloCajeroController {

	@GetMapping(value = {"", "/"})
	public String helloGet(Model model) {
		model.addAttribute("title","Home");
		IdentifyUser user = new IdentifyUser();
		user.setNumbertarget(RandomNumbers.numberCard());
		model.addAttribute("identifyUser", user);
		return "hello";
	}
	
	@PostMapping(value = { "/login", "/login/"})
	public String login(Model model, @ModelAttribute("identifyUser") IdentifyUser identifyUser) {
		identifyUser.setAmount(0.0);
		model.addAttribute("identifyUser", identifyUser);
		return "login";
	}
	
}
