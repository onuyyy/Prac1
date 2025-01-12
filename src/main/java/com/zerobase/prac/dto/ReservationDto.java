package com.zerobase.prac.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ReservationDto {

    private String userName;
    private LocalDateTime reservationDate;
    private String storeName;
    private boolean comeCheck;
}
