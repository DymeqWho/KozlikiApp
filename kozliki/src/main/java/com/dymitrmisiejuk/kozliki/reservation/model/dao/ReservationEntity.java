package com.dymitrmisiejuk.kozliki.reservation.model.dao;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
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
