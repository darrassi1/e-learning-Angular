package com.spa.projet.service;
import java.util.List;  

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spa.projet.model.Service1;
import com.spa.projet.repository.ServiceRepository;

@Service
public class Service1Service {

    @Autowired
    private ServiceRepository serviceRepository;
    

    public Service1Service(ServiceRepository serviceRepository) {
		super();
		this.serviceRepository = serviceRepository;
	}

	public Service1 updateService(Service1 service) {
    	 return serviceRepository.save(service);

    }

    public Service1 getServiceById(Long id) {
        return serviceRepository.findById(id).get();
    }

    public Service1 saveService(Service1 service) {
        return serviceRepository.save(service);
    }

    public List<Service1> getAllServices() {
        return serviceRepository.findAll();
    }

    public void deleteServiceById(Long id) {
        serviceRepository.deleteById(id);
    }
}
