package com.dymitrmisiejuk.kozliki.reservation.service;

import com.dymitrmisiejuk.kozliki.reservation.model.dao.ReservationEntity;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationAllResponse;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void createReservation(ReservationRequest reservationRequest) {
        ReservationEntity reservationEntity = new ReservationEntity();
        reservationEntity.setFromWhen(reservationRequest.getFromWhen());
        reservationEntity.setTillWhen(reservationRequest.getTillWhen());
        reservationEntity.setWho(reservationRequest.getWho());
        reservationEntity.setWhat(reservationRequest.getWhat());
        reservationEntity.setNotes(reservationRequest.getNotes());
        reservationRepository.save(reservationEntity);
    }

    public ReservationResponse readReservation(Long id) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setFromWhen(reservationRepository.findById(id).orElseThrow().getFromWhen());
        reservationResponse.setTillWhen(reservationRepository.findById(id).orElseThrow().getTillWhen());
        reservationResponse.setWhat(reservationRepository.findById(id).orElseThrow().getWhat());
        reservationResponse.setWho(reservationRepository.findById(id).orElseThrow().getWho());
        reservationResponse.setNotes(reservationRepository.findById(id).orElseThrow().getNotes());
        return reservationResponse;
    }

    public ReservationAllResponse showAllReservations() {
        return ReservationAllResponse.builder()
                .reservationEntityList(reservationRepository.findAll().stream()
                .map(reservationEntity -> ReservationResponse.builder()
                        .fromWhen(reservationEntity.getFromWhen())
                        .tillWhen(reservationEntity.getTillWhen())
                        .what(reservationEntity.getWhat())
                        .who(reservationEntity.getWho())
                        .notes(reservationEntity.getNotes())
                        .build())
                .collect(Collectors.toList())).build();
    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public void updateNote(Long id, ReservationRequest reservationRequestToUpdate){
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego id"));

        reservationEntity.setFromWhen(reservationRequestToUpdate.getFromWhen());
        reservationEntity.setTillWhen(reservationRequestToUpdate.getTillWhen());
        reservationEntity.setWho(reservationRequestToUpdate.getWho());
        reservationEntity.setWhat(reservationRequestToUpdate.getWhat());
        reservationEntity.setNotes(reservationRequestToUpdate.getNotes());

        reservationRepository.save(reservationEntity);
    }


}
