package com.dymitrmisiejuk.kozliki.front.frontcontroller;

import com.dymitrmisiejuk.kozliki.front.dto.ReservationFrontRequest;
import com.dymitrmisiejuk.kozliki.reservationlogic.reservationmodel.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservationlogic.reservationrepository.ReservationRepository;
import com.dymitrmisiejuk.kozliki.reservationlogic.reservationservice.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
@RequiredArgsConstructor
public class ReservationsFrontController {
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @GetMapping("/reservations")
    public String getAllReservations(Model model) {
        model.addAttribute("reservations", reservationRepository.findAll());
        model.addAttribute("newReservation", new ReservationFrontRequest());
        return "reservations";
    }

    @PostMapping(path = "/reservations")
    public String addReservation(@ModelAttribute("newReservation") ReservationFrontRequest reservationFrontRequest, Errors errors) {
        if (errors.hasErrors()) {
            return "reservations";
        }
        reservationService.createReservation(ReservationRequest.builder()
                .fromWhen(reservationFrontRequest.getFromWhen())
                .tillWhen(reservationFrontRequest.getTillWhen())
                .who(reservationFrontRequest.getWho())
                .what(reservationFrontRequest.getWhat())
                .notes(reservationFrontRequest.getNotes())
                .build());
        return "redirect:reservations";
    }
}
