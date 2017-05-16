package com.example;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReservationRestController {

	private ReservationRepository reservationRepository;
	
	@Autowired
	public ReservationRestController(ReservationRepository reservationRepository){
		this.reservationRepository = reservationRepository;
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/reservations")
	Collection<Reservation> reservation() {
		return this.reservationRepository.findAll();
	}
	//@GetMapping("/owners/{ownerId}")
}
