package com.dymitrmisiejuk.kozliki.reservationlogic.reservationrepository;

import com.dymitrmisiejuk.kozliki.reservationlogic.reservationmodel.dao.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
