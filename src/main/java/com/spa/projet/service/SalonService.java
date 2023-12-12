package com.spa.projet.service;
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spa.projet.model.Salon;
import com.spa.projet.repository.SalonRepository;




@Service
public class SalonService {

    @Autowired
    private SalonRepository salonRepository;
    

  

	public SalonService() {
		super();
	}

	public SalonService(SalonRepository salonRepository) {
		super();
		this.salonRepository = salonRepository;
	}

	public Salon updateSalon(Salon salon) {
    	 return salonRepository.save(salon);

    }

    public Salon getSalonById(Long id) {
        return salonRepository.findById(id).get();
    }

    public Salon saveSalon(Salon salon) {
        return salonRepository.save(salon);
    }

    public List<Salon> getAllSalon() {
        return salonRepository.findAll();
    }

    public void deleteSalonById(Long id) {
       salonRepository.deleteById(id);
    }
}
