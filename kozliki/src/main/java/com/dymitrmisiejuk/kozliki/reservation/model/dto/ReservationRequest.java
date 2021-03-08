package com.dymitrmisiejuk.kozliki.reservation.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReservationRequest {

    private LocalDate fromWhen;
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
}
