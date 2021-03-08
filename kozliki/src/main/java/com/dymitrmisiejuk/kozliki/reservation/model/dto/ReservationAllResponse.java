package com.dymitrmisiejuk.kozliki.reservation.model.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class ReservationAllResponse {

    private final List<ReservationResponse> reservationEntityList;
}
