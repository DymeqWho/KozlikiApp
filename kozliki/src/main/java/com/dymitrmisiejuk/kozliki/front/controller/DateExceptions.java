package com.dymitrmisiejuk.kozliki.front.controller;

import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationAllResponse;

import java.time.LocalDate;

public class DateExceptions {

    private final LocalDate now = LocalDate.now();


    public boolean isDateValid(LocalDate localDate) {
        return localDate.isAfter(this.now) || localDate.equals(this.now);
    }

    public boolean isDateValid(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        return localDateTillWhen.isAfter(localDateFromWhen) || localDateTillWhen.equals(localDateFromWhen);
    }

    public boolean isReservationValidTime(LocalDate localDateFromWhen, LocalDate localDateTillWhen){
        int daysBetween = localDateTillWhen.getDayOfYear() - localDateFromWhen.getDayOfYear();
        return daysBetween <= 4 && daysBetween > -1;
    }

}
