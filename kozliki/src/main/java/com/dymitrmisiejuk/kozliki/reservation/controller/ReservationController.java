package com.dymitrmisiejuk.kozliki.reservation.controller;

import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationAllResponse;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@Validated
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping(path = "/api/reservations")
    public void setNewReservation(@RequestBody ReservationRequest reservationRequest) {
        reservationService.createReservation(reservationRequest);
    }

    @GetMapping(path = "/api/reservations/{reservationId}")
    public ReservationResponse readReservation(@PathVariable(name = "reservationId") Long reservationId) {
        return reservationService.readReservation(reservationId);
    }

    @GetMapping(path = "/api/reservations")
    public ReservationAllResponse showAllReservations() {
        return reservationService.showAllReservations();
    }

    @PutMapping(path = "/api/reservations/{reservationId}")
    public void updateReservation(@RequestBody ReservationRequest reservationRequest, @PathVariable(name = "reservationId") Long reservationId) {
        reservationService.updateNote(reservationId, reservationRequest);
    }

    @DeleteMapping(path = "/api/reservations/{reservationId}")
    public void deleteReservation(@PathVariable(name = "reservationId") Long reservationId) {
        reservationService.deleteReservation(reservationId);
    }

}
