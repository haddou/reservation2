package com.reservation.reservation.controller;

import com.reservation.reservation.Exception.ReservationInvalideException;
import com.reservation.reservation.model.Reservation;
import com.reservation.reservation.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;


@RestController
public class ReservationController {
	@Autowired
	private ReservationService reservationService;




	@PostMapping("/reservation")
	public ResponseEntity<Reservation> reserve(@Valid @RequestBody Reservation reservation) throws ReservationInvalideException {
		final Reservation reservationterrain = reservationService.savereservation(reservation);

			System.out.println("reservation :\n" + reservation);
			return ResponseEntity.ok(reservationterrain);
		}

	@GetMapping("/getlistereservation")
	public List<Reservation> getlistereservation() {

		return reservationService.getlistreservation();
	}
}