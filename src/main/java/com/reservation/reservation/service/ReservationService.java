package com.reservation.reservation.service;
import com.reservation.reservation.Exception.ReservationInvalideException;
import com.reservation.reservation.model.Reservation;

import java.util.List;


public interface ReservationService {


    Reservation savereservation(Reservation reservation) throws ReservationInvalideException;
    List<Reservation> getlistreservation() ;
}
