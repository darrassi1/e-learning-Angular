package com.spa.projet.repository;
 


import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.spa.projet.model.Service1;

@Repository
public interface ServiceRepository extends JpaRepository<Service1, Long> {}
