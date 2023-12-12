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
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spa.projet.model.Client;
import com.spa.projet.service.ClientService;

@Controller

public class ClientController {

    @Autowired
    private ClientService clientService;

    public ClientController(ClientService clientService) {
		super();
		this.clientService = clientService;
	}

    @GetMapping("/clients")
    public String listStudents(Model model) {
		model.addAttribute("clients", clientService.getAllClients());
		return "clients/clients";
	}

    @GetMapping("/clients/new")
	public String createStudentForm(Model model) {
		
		// create student object to hold student form data
		Client clients = new Client();
		model.addAttribute("client", clients);
		return "clients/create_client";
		
	}

    @PostMapping("/clients")
	public String saveClients(@ModelAttribute("client") Client client) {
		clientService.saveClient(client);
		return "redirect:/clients";
	}

    @GetMapping("/clients/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model) {
		model.addAttribute("client", clientService.getClientById(id));
		return "clients/edit_client";
	}
    @PostMapping("/clients/{id}")
	public String updateClient(@PathVariable Long id,
			@ModelAttribute("client") Client client,
			Model model) {
		
		// get student from database by id
		Client existingClient = clientService.getClientById(id);
		existingClient.setId_Client(id);
		existingClient.setNom(client.getNom());
		existingClient.setPrenom(client.getPrenom());
		existingClient.setTelephone(client.getTelephone());
		existingClient.setDatenaissance(client.getDatenaissance());
		
		
		// save updated student object
		clientService.updateClient(existingClient);
		return "redirect:/clients";		
	}
    @GetMapping("/clients/{id}")
	public String deleteClient(@PathVariable Long id) {
		clientService.deleteClientById(id);
		return "redirect:/clients";
	}	
}
