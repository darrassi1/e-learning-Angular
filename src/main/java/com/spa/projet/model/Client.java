package com.spa.projet.model;

import java.time.LocalDate; 
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "Client")
public class Client {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id_Client;
	private String nom;
	private String prenom;
	private String telephone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private  Date datenaissance;
	@OneToMany(mappedBy = "client")
	  private List<Rendezvous> rendezVous;
	
	public List<Rendezvous> getRendezVous() {
		return rendezVous;
	}

	public void setRendezVous(List<Rendezvous> rendezVous) {
		this.rendezVous = rendezVous;
	}

	public Client() {

	}



	public Long getId_Client() {
		return Id_Client;
	}

	public void setId_Client(Long id_Client) {
		Id_Client = id_Client;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public Date getDatenaissance() {
		return datenaissance;
	}

	public void setDatenaissance(Date datenaissance) {
		this.datenaissance = datenaissance;
	}


}
