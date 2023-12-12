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
import com.spa.projet.model.Service1;
import com.spa.projet.repository.SalonRepository;
import com.spa.projet.service.SalonService;
import com.spa.projet.service.Service1Service;


@Controller

public class ServiceController {

    @Autowired
    private Service1Service serviceService;
    @Autowired
    private SalonRepository salonRepository;

    public ServiceController(Service1Service serviceService) {
		super();
		this.serviceService = serviceService;
	}

    @GetMapping("/services")
    public String listServices(Model model) {
		model.addAttribute("services", serviceService.getAllServices());
		return "services/services";
	}
  
    @GetMapping("/services/new")
	public String createServiceForm(Model model) {
    	
  
    	
    	List<Salon> salons = salonRepository.findAll();
    	model.addAttribute("salon", salons);
		// create student object to hold student form data
		Service1 services = new Service1();
		model.addAttribute("service", services);
		
		return "services/create_service";
		
	}

    @PostMapping("/services")
	public String saveServices(@ModelAttribute("service") Service1 service) {
		serviceService.saveService(service);
		return "redirect:/services";
	}

    @GetMapping("/services/edit/{id}")
	public String editServiceForm(@PathVariable Long id, Model model) {
    	List<Salon> salons = salonRepository.findAll();
    	model.addAttribute("salon", salons);
		model.addAttribute("service", serviceService.getServiceById(id));
		return "services/edit_service";
	}
    @PostMapping("/services/{id}")
	public String updateService(@PathVariable Long id,
			@ModelAttribute("service") Service1 service,
			Model model) {
		
		// get student from database by id
		Service1 existingService = serviceService.getServiceById(id);
		existingService.setId_Service(id);
		existingService.setNom(service.getNom());
		existingService.setPrix(service.getPrix());
		existingService.setSalon(service.getSalon());
		
		
		
		// save updated student object
		serviceService.updateService(existingService);
		return "redirect:/services";		
	}
    @GetMapping("/services/{id}")
	public String deleteService(@PathVariable Long id) {
		serviceService.deleteServiceById(id);
		return "redirect:/services";
	}	
}
