package com.dymitrmisiejuk.kozliki.front.controller;

import java.time.LocalDate;

public class DateExceptions {

    private final LocalDate now = LocalDate.now();


    public boolean isDateValid(LocalDate localDate) {
        return localDate.isAfter(this.now) || localDate.equals(this.now);
    }

    public boolean isDateValid(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        return localDateTillWhen.isAfter(localDateFromWhen) || localDateTillWhen.equals(localDateFromWhen);
    }

}
