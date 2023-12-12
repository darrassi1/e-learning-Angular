package com.spa.projet.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Salon")
public class Salon {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Salon;
	private String Nom;
	private String Adresse;
	@OneToMany(mappedBy = "salon")
	  private List<Service1> service;
	
	public List<Service1> getService() {
		return service;
	}
	public void setService(List<Service1> service) {
		this.service = service;
	}
	@OneToMany(mappedBy = "salon")
	  private List<Rendezvous> rendezVous;
	
	public List<Rendezvous> getRendezVous() {
		return rendezVous;
	}
	public void setRendezVous(List<Rendezvous> rendezVous) {
		this.rendezVous = rendezVous;
	}
	public Salon() {
	
	}
	public Long getId_Salon() {
		return Id_Salon;
	}
	public void setId_Salon(Long id_Salon) {
		Id_Salon = id_Salon;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public String getAdresse() {
		return Adresse;
	}
	public void setAdresse(String adresse) {
		Adresse = adresse;
	}


}
