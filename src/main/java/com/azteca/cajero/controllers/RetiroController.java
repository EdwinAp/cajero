package com.azteca.cajero.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.azteca.cajero.dao.models.Caja;
import com.azteca.cajero.dao.models.pojos.IdentifyUser;
import com.azteca.cajero.dao.services.ICajaService;

@Controller
public class RetiroController {
	
	@Autowired
	private ICajaService iCajaService;
	
	@PostMapping(value = {"/retiro/", "/retiro"})
	public String retiro(Model model, @ModelAttribute("identifyUser") IdentifyUser identifyUser) {
		if (identifyUser.getAmount() <= 0) {
			model.addAttribute("identifyUser", identifyUser);
			model.addAttribute("status", "incorrectmount");
		} else if (!iCajaService.validateMount(identifyUser.getAmount())) {
			model.addAttribute("identifyUser", identifyUser);
			model.addAttribute("status", "insuficient");
		} else {
			ArrayList<Caja> retiro = iCajaService.getAllMounts(identifyUser.getAmount());
			model.addAttribute("identifyUser", identifyUser);
			model.addAttribute("status", "successfull");
			model.addAttribute("retiro", retiro);
		}
		return "retiro";
	}

}
