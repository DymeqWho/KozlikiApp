package com.dymitrmisiejuk.kozliki.reservationmodel.dto;

import lombok.*;

import java.time.LocalDate;

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
}
