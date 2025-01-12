package com.zerobase.prac.service;

import com.zerobase.prac.domain.Reservation;
import com.zerobase.prac.dto.ReservationDto;
import com.zerobase.prac.repository.ReservationRepository;
import com.zerobase.prac.repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final StoreRepository storeRepository;

    public void createReservation(ReservationDto dto) {

        storeRepository.findByName(dto.getStoreName())
                .orElseThrow(() -> new RuntimeException("not found store"));

        if (reservationRepository.existsByReservationDate(dto.getReservationDate())) {
            new RuntimeException("already reserved");
        }

        reservationRepository.save(Reservation.from(dto));
    }


}
