package com.dymitrmisiejuk.kozliki.front.model.dto;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
public class ReservationFrontRequest {


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate fromWhen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate tillWhen;
    @NotNull
    @Size(min = 2, max = 30)
    private String who;
    @Size(max = 200)
    private String what;
    @Size(max = 200)
    private String notes;
}
