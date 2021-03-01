package com.dymitrmisiejuk.kozliki.reservationmodel.dao;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@Table(name = "reservation")
public class ReservationEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate fromWhen;
    private LocalDate tillWhen;
    private String who;
    private String what;
    private String notes;
}
