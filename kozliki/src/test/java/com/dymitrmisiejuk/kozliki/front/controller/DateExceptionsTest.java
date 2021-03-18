package com.dymitrmisiejuk.kozliki.front.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateExceptionsTest {

    @Test
    @DisplayName("Should be true if days between are from 0 to 4 in the same year")
    void test(){
        //given
        DateExceptions dateExceptions = new DateExceptions();
        LocalDate localDateStart = LocalDate.of(2021, 3, 18);

        LocalDate localDateEnd2 = LocalDate.of(2021, 3, 18);
        LocalDate localDateEnd3 = LocalDate.of(2021, 3, 19);
        LocalDate localDateEnd4 = LocalDate.of(2021, 3, 20);
        LocalDate localDateEnd5 = LocalDate.of(2021, 3, 21);


        //when && then

        assertTrue(dateExceptions.isReservationValidTime(localDateStart, localDateEnd2));
        assertTrue(dateExceptions.isReservationValidTime(localDateStart, localDateEnd3));
        assertTrue(dateExceptions.isReservationValidTime(localDateStart, localDateEnd4));
        assertTrue(dateExceptions.isReservationValidTime(localDateStart, localDateEnd5));

    }

    @Test
    @DisplayName("Should be false if days are not between 0-4 in the same year")
    void test2(){
        //given
        DateExceptions dateExceptions = new DateExceptions();
        LocalDate localDateStart = LocalDate.of(2021, 3, 18);
        LocalDate localDateEnd1 = LocalDate.of(2021, 3, 17);
        LocalDate localDateEnd6 = LocalDate.of(2021, 5, 18);

        //when && then
        assertFalse(dateExceptions.isReservationValidTime(localDateStart, localDateEnd1));
        assertFalse(dateExceptions.isReservationValidTime(localDateStart, localDateEnd6));
    }

}