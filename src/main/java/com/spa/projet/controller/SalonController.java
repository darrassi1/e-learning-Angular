package com.spa.projet.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.spa.projet.model.Salon;
import com.spa.projet.service.SalonService;





@Controller

public class SalonController {

    @Autowired
    private SalonService salonService;

  

    public SalonController(SalonService salonService) {
		super();
		this.salonService = salonService;
	}

	@GetMapping("/salon")
    public String listStudents(Model model) {
		model.addAttribute("salon", salonService.getAllSalon());
		return "salon/salon";
	}

    @GetMapping("/salon/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
    	Salon salon = new Salon();
		model.addAttribute("salon", salon);
		return "salon/create_salon";
		
	}

    @PostMapping("/salon")
	public String saveClients(@ModelAttribute("salon") Salon salon) {
    	salonService.saveSalon(salon);
		return "redirect:/salon";
	}

    @GetMapping("/salon/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("salon", salonService.getSalonById(id));
		return "salon/edit_salon";
	}
    @PostMapping("/salon/{id}")
	public String updateSalon(@PathVariable Long id,
			@ModelAttribute("salon") Salon salon,
			Model model) {
		
		// get student from database by id
    	Salon existingSalon = salonService.getSalonById(id);
    	existingSalon.setId_Salon(id);
    	existingSalon.setNom(salon.getNom());
    	existingSalon.setAdresse(salon.getAdresse());
		
		
		
		// save updated student object
		salonService.updateSalon(existingSalon);
		return "redirect:/salon";		
	}
    @GetMapping("/salon/{id}")
	public String deleteSalon(@PathVariable Long id) {
		salonService.deleteSalonById(id);
		return "redirect:/salon";
	}	
}
