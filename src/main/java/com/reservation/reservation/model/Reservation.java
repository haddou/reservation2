package com.reservation.reservation.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 3190322008036232647L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@OneToMany(mappedBy = "reservation")
	private List<Joueur> listeDesJoueurs = new ArrayList<>();
	
	@OneToOne
	private Terrain terrain;
	
	private int creneau;  // nbre d'heures
	
	private Date dateReservation;
	
	private double prix;


}