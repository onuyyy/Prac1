package com.zerobase.prac.service;

import com.zerobase.prac.domain.Reservation;
import com.zerobase.prac.dto.ReservationDto;
import com.zerobase.prac.repository.ReservationRepository;
import com.zerobase.prac.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final StoreRepository storeRepository;

    public void createReservation(ReservationDto dto) {

        storeRepository.findByName(dto.getStoreName())
                .orElseThrow(() -> new RuntimeException("not found store"));

        if (reservationRepository.existsByReservationDate(dto.getReservationDate())) {
            throw new RuntimeException("already reserved");
        }

        reservationRepository.save(Reservation.from(dto));
    }


    public String checkReservation(ReservationDto dto) {

        List<Reservation> reservations = reservationRepository.findByUserName(dto.getUserName());

        Optional<Reservation> reservationOptional = reservations.stream()
                .filter(reservation -> reservation.getReservationDate().equals(dto.getReservationDate()))
                .findFirst();

        if (reservationOptional.isPresent()) {
            Reservation reservation = reservationOptional.get();

            reservation.setComeCheck(true);
            reservationRepository.save(reservation);

            return dto.getUserName() + " reservation check completed";
        } else {
            throw new RuntimeException("not found reservation");
        }

    }
}
