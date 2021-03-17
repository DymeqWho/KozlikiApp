package com.dymitrmisiejuk.kozliki.reservation.model.dto;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationResponse {
    private LocalDate fromWhen;
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
    private LocalDateTime dateTimeOfReservation;
}
