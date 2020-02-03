package com.reservation.reservation.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.reservation.reservation.model.Reservation;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RestResource

public interface ReservationRepository extends JpaRepository<Reservation, Long>{

}