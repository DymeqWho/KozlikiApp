package com.dymitrmisiejuk.kozliki.front.controller;

import com.dymitrmisiejuk.kozliki.reservation.repository.ReservationRepository;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;

public class DateExceptions {

    private final LocalDate now = LocalDate.now();

    public boolean isDateValid(LocalDate localDate) {
        return localDate.isAfter(this.now) || localDate.equals(this.now);
    }

    public boolean isDateValid(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        return localDateTillWhen.isAfter(localDateFromWhen) || localDateTillWhen.equals(localDateFromWhen);
    }

    public boolean isReservationValidTime(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        int daysBetween = localDateTillWhen.getDayOfYear() - localDateFromWhen.getDayOfYear();
        return daysBetween <= 3 && daysBetween > -1;
    }

    public boolean isReservationValid(ReservationRepository reservationRepository, LocalDate fromWhen, LocalDate tillWhen) {

        int dayFromWhen = fromWhen.getDayOfYear();
        int dayTillWhen = tillWhen.getDayOfYear();

        if(dayFromWhen > dayTillWhen)
            return false;

        int[] bookedDays = new int[dayTillWhen - dayFromWhen + 1];
        for (int i = 0; i < bookedDays.length; i++) {
            bookedDays[i] = dayTillWhen - i;
        }

        int howLongIsRepo;

        try {
            howLongIsRepo = reservationRepository.findAll().size();
        } catch (NullPointerException exception) {
            howLongIsRepo = 0;
        }

        if (howLongIsRepo == 0) {
            return true;
        } else {
            LocalDate localDateFromWhen;
            LocalDate localDateTilLWhen;
            int localDayFromWhen;
            int localDayTillWhen;
            int[] localDayArr;


            for (int i = 0; i < howLongIsRepo; i++) {
                try {
                    localDateFromWhen = reservationRepository.getOne((long) i + 1).getFromWhen();
                    localDateTilLWhen = reservationRepository.getOne((long) i + 1).getTillWhen();
                }catch (EntityNotFoundException exe){
                    continue;
                }
                localDayFromWhen = localDateFromWhen.getDayOfYear();
                localDayTillWhen = localDateTilLWhen.getDayOfYear();
                localDayArr = new int[localDayTillWhen - localDayFromWhen + 1];

                for (int j = 0; j < localDayArr.length; j++) {
                    localDayArr[j] = localDayTillWhen - j;
                }

                for (int k = 0; k < localDayArr.length; k++) {
                    int queryDayNumber = localDayArr[k];
                    for (int l = 0; l < bookedDays.length; l++) {
                        int requestDay = bookedDays[l];
                        if (queryDayNumber == requestDay) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }

}
