package com.dymitrmisiejuk.kozliki.reservation.model.dao;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate fromWhen;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
}
