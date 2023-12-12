package com.spa.projet.repository;
 


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spa.projet.model.Salon;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {}
