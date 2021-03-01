package com.dymitrmisiejuk.kozliki.reservationcontroller;

import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationAllResponse;
import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservationservice.ReservationService;
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

    @GetMapping(path = "/api/reservation/{reservationId}")
    public ReservationResponse readReservation(@PathVariable(name = "reservationId") Long reservationId) {
        return reservationService.readReservation(reservationId);
    }

    @GetMapping(path ="/api/reservations")
    public ReservationAllResponse showAllReservations(){
        return reservationService.showAllReservations();
    }

}
