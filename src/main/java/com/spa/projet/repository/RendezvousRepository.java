 package com.spa.projet.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.spa.projet.model.Rendezvous;

@Repository
public interface RendezvousRepository extends JpaRepository<Rendezvous, Long> {







}