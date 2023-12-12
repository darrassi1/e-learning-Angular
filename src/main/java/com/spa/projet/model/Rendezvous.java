package com.spa.projet.model;

import java.util.Date; 

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;
@Entity
@Table(name = "Rendezvous")
public class Rendezvous {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idrendezvous;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date_rdv;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date Date_demande;
	private Long salon_id;
	private Long client_id;

	



	
	public Long getSalon_id() {
		return salon_id;
	}
	public void setSalon_id(Long salon_id) {
		this.salon_id = salon_id;
	}
	public Long getClient_id() {
		return client_id;
	}
	public void setClient_id(Long client_id) {
		this.client_id = client_id;
	}
	public Long getIdrendezvous() {
		return idrendezvous;
	}
	public void setIdrendezvous(Long idrendezvous) {
		this.idrendezvous = idrendezvous;
	}
	@ManyToOne
	@JoinColumn(name = "salon_id", insertable = false, updatable = false)
	  private Salon salon;
	@ManyToOne
	@JoinColumn(name = "client_id", insertable = false, updatable = false)
	  private Client client;

	public Date getDate_rdv() {
		return Date_rdv;
	}
	public void setDate_rdv(Date date_rdv) {
		Date_rdv = date_rdv;
	}
	public Date getDate_demande() {
		return Date_demande;
	}
	public void setDate_demande(Date date_demande) {
		Date_demande = date_demande;
	}
	public Salon getSalon() {
		return salon;
	}
	public void setSalon(Salon salon) {
		this.salon = salon;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}

}
