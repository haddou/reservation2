package com.reservation.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.reservation.reservation.model.Joueur;

@Repository
public interface JoueurRepository extends JpaRepository<Joueur, Long>{

}