package com.zerobase.prac.repository;

import com.zerobase.prac.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    boolean existsByReservationDate(LocalDateTime reservationDate);
}
