package com.dymitrmisiejuk.kozliki.reservation.service;

import com.dymitrmisiejuk.kozliki.reservation.model.dao.ReservationEntity;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationAllResponse;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservation.repository.ReservationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void createReservation(ReservationRequest reservationRequest) {
        ReservationEntity reservationEntity = new ReservationEntity();
        settingReservationEntity(reservationRequest, reservationEntity);
    }

    public ReservationResponse readReservation(Long id) {
        ReservationResponse reservationResponse = new ReservationResponse();
        reservationResponse.setFromWhen(reservationRepository.findById(id).orElseThrow().getFromWhen());
        reservationResponse.setTillWhen(reservationRepository.findById(id).orElseThrow().getTillWhen());
        reservationResponse.setWhat(reservationRepository.findById(id).orElseThrow().getWhat());
        reservationResponse.setWho(reservationRepository.findById(id).orElseThrow().getWho());
        reservationResponse.setNotes(reservationRepository.findById(id).orElseThrow().getNotes());
        reservationResponse.setDateTimeOfReservation(reservationRepository.findById(id).orElseThrow().getDateTimeOfReservation());
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
                        .dateTimeOfReservation(reservationEntity.getDateTimeOfReservation())
                        .build())
                .collect(Collectors.toList())).build();
    }

    public void deleteReservation(Long id){
        reservationRepository.deleteById(id);
    }

    public void updateNote(Long id, ReservationRequest reservationRequestToUpdate){
        ReservationEntity reservationEntity = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("Nie ma takiego id"));

        settingReservationEntity(reservationRequestToUpdate, reservationEntity);
    }

    private void settingReservationEntity(ReservationRequest reservationRequestToUpdate, ReservationEntity reservationEntity) {
        reservationEntity.setFromWhen(reservationRequestToUpdate.getFromWhen());
        reservationEntity.setTillWhen(reservationRequestToUpdate.getTillWhen());
        reservationEntity.setWho(reservationRequestToUpdate.getWho());
        reservationEntity.setWhat(reservationRequestToUpdate.getWhat());
        reservationEntity.setNotes(reservationRequestToUpdate.getNotes());
        reservationEntity.setDateTimeOfReservation(LocalDateTime.now());

        reservationRepository.save(reservationEntity);
    }


}
