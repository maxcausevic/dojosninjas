package com.mcausevic.dojosninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mcausevic.dojosninjas.models.Dojo;
import com.mcausevic.dojosninjas.models.Ninja;
import com.mcausevic.dojosninjas.services.DojoService;
import com.mcausevic.dojosninjas.services.NinjaService;






@Controller
public class MainController {
private final DojoService dojoService;
private final NinjaService ninjaService;
public MainController(DojoService dojoService, NinjaService ninjaService) {
	this.dojoService = dojoService;
	this.ninjaService = ninjaService;
}
	@RequestMapping("/")
	public String index() {
	return "index.jsp";
	}
	@RequestMapping("/addDojo")
	public String dojo() {
		return "NewDojo.jsp";
	}
	@RequestMapping("/addNinja")
	public String Ninja(Model model) {
		
		List<Dojo> dojos = dojoService.allDojos();
	    model.addAttribute("dojos", dojos);
	    model.addAttribute("ninja", new Ninja());
	    
		return "NewNinja.jsp";
	}
	@RequestMapping(value="/addDojo/new",method=RequestMethod.POST)
	public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}else
			dojoService.createDojo(dojo);
			
		return "redirect:/";
	}	
	@RequestMapping(value="/addNinja/new",method=RequestMethod.POST)
	public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "NewNinja.jsp";
		}else {
			ninjaService.createNinja(ninja);
		}
		return "redirect:/";
	}	
	@RequestMapping("/dojos/{id}")
	public String show(Model model, @PathVariable("id") Long id) {
	    Dojo dojo = dojoService.findDojo(id);
	    List<Ninja> ninjas= dojo.getNinjas();
	    model.addAttribute("dojo", dojo);
	    model.addAttribute("ninjas", ninjas);
	    return "show.jsp";
	}
}
