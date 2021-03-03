package com.dymitrmisiejuk.kozliki.front.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class ReservationFrontRequest {
    private LocalDate fromWhen;
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
}
