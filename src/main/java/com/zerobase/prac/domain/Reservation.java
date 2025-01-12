package com.zerobase.prac.domain;

import com.zerobase.prac.dto.ReservationDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String userName;
    private LocalDateTime reservationDate;
    private String storeId;
    private boolean comeCheck;

    public static Reservation from(ReservationDto form) {
        return Reservation.builder()
                .userName(form.getUserName())
                .reservationDate(form.getReservationDate())
                .storeId(form.getStoreName())
                .build();
    }
}
