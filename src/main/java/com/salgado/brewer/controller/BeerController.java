package com.salgado.brewer.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.salgado.brewer.model.Beer;

@Controller
public class BeerController {
	
	@RequestMapping("/cervejas/novo")
	public String newBeer() {
		return "beer/register-beer";
	}
	
	@RequestMapping(value = "/cervejas/novo", method = RequestMethod.POST)
	public String register(@Valid Beer beer, BindingResult result, Model model, RedirectAttributes attributes) {
		
		if(result.hasErrors()) {
			model.addAttribute("message", "erro no formulário");
			return "beer/register-beer";
		}
		attributes.addFlashAttribute("message", "salvo com sucesso");
		return "redirect:/cervejas/novo";
	}

}
