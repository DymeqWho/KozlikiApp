package com.dymitrmisiejuk.kozliki.reservationservice;

import com.dymitrmisiejuk.kozliki.reservationmodel.dao.ReservationEntity;
import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationAllResponse;
import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationRequest;
import com.dymitrmisiejuk.kozliki.reservationmodel.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservationrepository.ReservationRepository;
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
}
