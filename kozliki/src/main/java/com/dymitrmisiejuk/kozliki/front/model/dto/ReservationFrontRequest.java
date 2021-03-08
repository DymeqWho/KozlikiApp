package com.dymitrmisiejuk.kozliki.front.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDate;

@Data
public class ReservationFrontRequest {

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromWhen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
}
