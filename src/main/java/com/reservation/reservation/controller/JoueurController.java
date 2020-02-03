
package com.reservation.reservation.controller;

import java.util.HashMap;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.reservation.reservation.repository.JoueurRepository;
import com.reservation.reservation.model.Joueur;
//import net.guides.springboot2.springboot2jpacrudexample.exception.ResourceNotFoundException;
//import net.guides.springboot2.springboot2jpacrudexample.model.Joueur;
//import net.guides.springboot2.springboot2jpacrudexample.repository.JoueurRepository;

@RestController

public class JoueurController {
    @Autowired
    private JoueurRepository joueurRepository;

    @GetMapping("/listejoueurs")
    public List<Joueur> getAllJoueurs() {
        return joueurRepository.findAll();
    }

    @GetMapping("/joueurs/{id}")
    public ResponseEntity<Joueur> getJoueurById(@PathVariable(value = "id") Long joueureId)

    {
        Joueur joueur = joueurRepository.findById(joueureId).get();

        return ResponseEntity.ok().body(joueur);
    }

    @PostMapping("/ajouterjoueur")
    public Joueur createJoueur(@Valid @RequestBody Joueur joueur) {
        return joueurRepository.save(joueur);
    }

}
