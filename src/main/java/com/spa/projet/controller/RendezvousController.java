package com.spa.projet.controller;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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

import com.lowagie.text.DocumentException;
import com.spa.projet.model.Client;
import com.spa.projet.model.Rendezvous;
import com.spa.projet.model.Salon;
import com.spa.projet.repository.ClientRepository;
import com.spa.projet.repository.RendezvousRepository;
import com.spa.projet.repository.SalonRepository;
import com.spa.projet.service.RendezvousService;




@Controller

public class RendezvousController {

    @Autowired
    private RendezvousService rendezvousService;

    @Autowired
    private SalonRepository salonRepository;
    @Autowired
    private ClientRepository clientRepository;

   

	public RendezvousController(RendezvousService rendezvousService) {
		super();
		this.rendezvousService = rendezvousService;
	}

	@GetMapping("/rendezvous")
    public String listRendezvous(Model model) {
		model.addAttribute("rendezvous",rendezvousService.getAllRendezvous());
		return "rendezvous/rendezvous";
	}

    @GetMapping("/rendezvous/new")
	public String createStudentForm(Model model) {
    	List<Salon> salons = salonRepository.findAll();
    	model.addAttribute("salon", salons);
    	List<Client> client = clientRepository.findAll();
    	model.addAttribute("client", client);
		// create student object to hold student form data
    	Rendezvous rendezvous = new Rendezvous();
		model.addAttribute("rendezvous", rendezvous);
		return "rendezvous/create_rendezvous";
		
	}

    @PostMapping("/rendezvous")
	public String saveRendezvous(@ModelAttribute("rendezvous") Rendezvous rendezvous) {
    	rendezvousService.saveRendezvous(rendezvous);
		return "redirect:/rendezvous";
	}

    @GetMapping("/rendezvous/edit/{id}")
	public String editRendezvousForm(@PathVariable Long id, Model model) {
    	List<Salon> salons = salonRepository.findAll();
    	model.addAttribute("salon", salons);
    	List<Client> client = clientRepository.findAll();
    	model.addAttribute("client", client);
		model.addAttribute("rendezvous", rendezvousService.getRendezvousById(id));
		return "rendezvous/edit_rendezvous";
	}
    @GetMapping("/rendezvous/show/{id}")
   	public String showRendezvous(@PathVariable Long id, Model model) {
       	List<Salon> salons = salonRepository.findAll();
       	model.addAttribute("salon", salons);
       	List<Client> client = clientRepository.findAll();
       	model.addAttribute("client", client);
   		model.addAttribute("rendezvous", rendezvousService.getRendezvousById(id));
   		return "rendezvous/show_rendezvous";
   	}
    @PostMapping("/rendezvous/{id}")
	public String updateClient(@PathVariable Long id,
			@ModelAttribute("rendezvous") Rendezvous rendezvous,
			Model model) {
		
		// get student from database by id
    	Rendezvous existingRendezvous = rendezvousService.getRendezvousById(id);
    	existingRendezvous.setIdrendezvous(id);
    	existingRendezvous.setDate_rdv(rendezvous.getDate_rdv());
    	existingRendezvous.setDate_demande(rendezvous.getDate_demande());
    	existingRendezvous.setSalon(rendezvous.getSalon());
    	existingRendezvous.setClient(rendezvous.getClient());
		
		
		// save updated student object
    	rendezvousService.updateRendezvous(existingRendezvous);
		return "redirect:/rendezvous";		
	}
    @GetMapping("/rendezvous/{id}")
	public String deleteRendezvous(@PathVariable Long id) {
    	rendezvousService.deleteRendezvousById(id);
		return "redirect:/rendezvous";
	}	
    
	// generate pdf
    @GetMapping("/pdf/{id}")
	public void generatePdf(HttpServletResponse response,@PathVariable Long id) throws DocumentException, IOException {
		
		response.setContentType("application/pdf");
		DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD:HH:MM:SS");
		String currentDateTime = dateFormat.format(new Date());
		String headerkey = "Content-Disposition";
		String headervalue = "attachment; filename=pdf_" + currentDateTime + ".pdf";
		response.setHeader(headerkey, headervalue);
		

		List<Rendezvous> rendezvous = new ArrayList<>();
		rendezvous.add(rendezvousService.getRendezvousById(id));
		
		PDFGenerator generator = new PDFGenerator();
		generator.setRendezvousList(rendezvous);
		generator.generate(response);
		
	}
}

