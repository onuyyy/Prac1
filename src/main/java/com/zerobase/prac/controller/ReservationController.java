package com.zerobase.prac.controller;

import com.zerobase.prac.dto.ReservationDto;
import com.zerobase.prac.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reservation")
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<String> createReservation(@RequestBody ReservationDto reservation) {
        reservationService.createReservation(reservation);

        return ResponseEntity.ok("Reservation successful for " + reservation.getStoreName());
    }

    @PostMapping("/check")
    public ResponseEntity<String> checkReservation(@RequestBody ReservationDto reservation) {
        return ResponseEntity.ok(reservationService.checkReservation(reservation));

    }

}
