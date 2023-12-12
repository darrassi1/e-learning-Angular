package com.spa.projet.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Service")
public class Service1 {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Service;
	
	private String Nom;
	private float Prix;
	private Long salon_id;

	public Long getSalon_id() {
	    return salon_id;
	}

	public void setSalon_id(Long salon_id) {
	    this.salon_id = salon_id;
	}
	
	@ManyToOne
	@JoinColumn(name = "salon_id", insertable = false, updatable = false)
	  private Salon salon;
	
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public Service1() {
	
	}
	public Long getId_Service() {
		return Id_Service;
	}
	public void setId_Service(Long id_Service) {
		Id_Service = id_Service;
	}
	public String getNom() {
		return Nom;
	}
	public void setNom(String nom) {
		Nom = nom;
	}
	public float getPrix() {
		return Prix;
	}
	public void setPrix(float prix) {
		Prix = prix;
	}
	
	
}
