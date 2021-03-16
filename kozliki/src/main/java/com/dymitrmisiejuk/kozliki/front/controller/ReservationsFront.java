package com.dymitrmisiejuk.kozliki.front.controller;

import com.dymitrmisiejuk.kozliki.front.model.dto.ReservationFrontRequest;
import com.dymitrmisiejuk.kozliki.reservation.model.dao.ReservationEntity;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservation.repository.ReservationRepository;
import com.dymitrmisiejuk.kozliki.reservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.validation.Valid;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequiredArgsConstructor
public class ReservationsFront implements WebMvcConfigurer {
    private final ReservationRepository reservationRepository;
    private final ReservationService reservationService;

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/reservations").setViewName("reservations");
    }

    @GetMapping("/reservations")
    public String getAllReservations(Model model) {
        Comparator<ReservationEntity> byTillWhen = Comparator.comparing(ReservationEntity::getTillWhen);
        List<ReservationEntity> list = reservationRepository.findAll()
                .stream()
                .sorted(byTillWhen)
                .collect(Collectors.toList());
        model.addAttribute("reservations", list);
        model.addAttribute("newReservation", new ReservationFrontRequest());
        return "reservations";
    }

    @PostMapping(path = "/reservations")
        public String addReservation(@ModelAttribute("newReservation") @Valid ReservationFrontRequest reservationFrontRequest, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "reservations";
        }
        reservationService.createReservation(ReservationRequest.builder()
                .fromWhen(reservationFrontRequest.getFromWhen())
                .tillWhen(reservationFrontRequest.getTillWhen())
                .who(reservationFrontRequest.getWho())
                .what(reservationFrontRequest.getWhat())
                .notes(reservationFrontRequest.getNotes())
                .build());
        return "redirect:/reservations";
    }

    @GetMapping("/reservations/update/{id}")
    public String getReservationForm(@PathVariable("id") Long id, Model model) {
        ReservationEntity reservationEntity = reservationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Niepoprawny id rezerwacji: " + id));

        model.addAttribute("reservationEntity", reservationEntity);
        return "update";
    }

    @PostMapping("/reservations/update/{id}")
    public String updateReservation(@PathVariable("id") Long id, @Valid ReservationFrontRequest reservationFrontRequest, BindingResult result, Model model) {
        if (result.hasErrors()) {
            ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Niepoprawny id rezerwacji: " + id));
            reservationEntity.setId(id);
            return "reservations";
        }

        ReservationRequest reservationRequest = new ReservationRequest(reservationFrontRequest.getFromWhen(), reservationFrontRequest.getTillWhen(), reservationFrontRequest.getWho(), reservationFrontRequest.getWhat(), reservationFrontRequest.getNotes());
        reservationService.updateNote(id, reservationRequest);
        return "redirect:/reservations";
    }

    @PostMapping("reservations/delete/{id}")
    public String deleteNote(@PathVariable("id") Long id) {
        reservationService.deleteReservation(id);
        return "redirect:/reservations";
    }

}
