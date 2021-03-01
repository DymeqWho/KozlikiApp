package com.dymitrmisiejuk.kozliki.reservationrepository;

import com.dymitrmisiejuk.kozliki.reservationmodel.dao.ReservationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {
}
