package com.reservation.reservation.controller;


import com.reservation.reservation.model.Joueur;
import com.reservation.reservation.model.Terrain;
import com.reservation.reservation.repository.TerrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class TerrainController {

    @Autowired
    private TerrainRepository terrainRepository;

    @GetMapping("/terrains")
    public List<Terrain> getAllterrains() {
        return terrainRepository.findAll();
    }

    @GetMapping("/terrains/{id}")
    public ResponseEntity<Terrain> getTerrainById(@PathVariable(value = "id") Long terrainId)

    {
        Terrain terrain = terrainRepository.findById(terrainId).get();

        return ResponseEntity.ok().body(terrain);
    }

    @PostMapping("/addterrain")
    public Terrain createTerrain(@Valid @RequestBody Terrain terrain) {
        return terrainRepository.save(terrain);
    }
}
