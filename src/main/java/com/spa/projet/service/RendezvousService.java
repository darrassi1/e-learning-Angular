package com.spa.projet.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spa.projet.model.Client;
import com.spa.projet.model.Rendezvous;
import com.spa.projet.repository.ClientRepository;
import com.spa.projet.repository.RendezvousRepository;

@Service
public class RendezvousService {
	@Autowired
	private RendezvousRepository rendezvousRepository;

	public RendezvousService(RendezvousRepository rendezvousRepository) {
		super();
		this.rendezvousRepository = rendezvousRepository;
	}

	public Rendezvous updateRendezvous(Rendezvous rendezvous) {
		return rendezvousRepository.save(rendezvous);

	}

	public Rendezvous getRendezvousById(Long id) {
		return rendezvousRepository.findById(id).get();
	}

	public Rendezvous saveRendezvous(Rendezvous rendezvous) {
		return rendezvousRepository.save(rendezvous);
	}

	public List<Rendezvous> getAllRendezvous() {
		return rendezvousRepository.findAll();
	}

public void deleteRendezvousById(Long id) {
    rendezvousRepository.deleteById(id);
}}