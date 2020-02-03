package com.reservation.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.reservation.reservation.model.Terrain;
import org.springframework.stereotype.Repository;

@Repository
public interface TerrainRepository extends JpaRepository<Terrain, Long>{

}