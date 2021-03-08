package com.dymitrmisiejuk.kozliki.reservation.repository;

import com.dymitrmisiejuk.kozliki.reservation.model.dao.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
