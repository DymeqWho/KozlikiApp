package com.dymitrmisiejuk.kozliki.front.controller;

import com.dymitrmisiejuk.kozliki.reservation.model.dao.ReservationEntity;
import com.dymitrmisiejuk.kozliki.reservation.model.dto.ReservationResponse;
import com.dymitrmisiejuk.kozliki.reservation.repository.ReservationRepository;
import com.dymitrmisiejuk.kozliki.reservation.service.ReservationService;

import java.time.LocalDate;
import java.util.List;

public class DateExceptions {


    private final LocalDate now = LocalDate.now();
    private ReservationService reservationService;
    private ReservationRepository reservationRepository;


    public boolean isDateValid(LocalDate localDate) {
        return localDate.isAfter(this.now) || localDate.equals(this.now);
    }

    public boolean isDateValid(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        return localDateTillWhen.isAfter(localDateFromWhen) || localDateTillWhen.equals(localDateFromWhen);
    }

    public boolean isReservationValidTime(LocalDate localDateFromWhen, LocalDate localDateTillWhen) {
        int daysBetween = localDateTillWhen.getDayOfYear() - localDateFromWhen.getDayOfYear();
        return daysBetween <= 4 && daysBetween > -1;
    }

//    public boolean isReservationOverlapsAnotherReservation(LocalDate requestFromWhen, LocalDate requestTillWhen) throws NullPointerException {
//        boolean isOrNot = false;
//        int reservationAllResponseListLength =0;
////        List<ReservationEntity> reservationAllResponseList;
//        try {
//            List<ReservationEntity> reservationAllResponseList = reservationRepository.findAll();
//           reservationAllResponseListLength = reservationRepository.findAll().size();
//        } catch (NullPointerException nullPointerException) {
////            int reservationAllResponseListLength = 0;
////            if (!reservationAllResponseList.isEmpty()) {
////            }
//
//
//            int[] daysPretendingToBeReserved = new int[requestTillWhen.getDayOfYear() - requestFromWhen.getDayOfYear()];
//            int requestFromWhenDayInTheYearNumber = requestFromWhen.getDayOfYear();
//
//
////            if (reservationAllResponseList.isEmpty()) {
////                return false;
////            } else {
//            ReservationResponse reservationResponse;
//            for (long i = 0; i < reservationAllResponseListLength; i++) {
//                reservationResponse = reservationService.readReservation(i);
//
//
//                for (int j = 0; j < reservationAllResponseListLength; j++) {
//                    LocalDate reservationResponseFromWhen = reservationResponse.getFromWhen();
//                    LocalDate reservationResponseTillWhen = reservationResponse.getTillWhen();
//
//                    isOrNot = checkingIfDatesAreOverlapping(reservationResponseFromWhen, reservationResponseTillWhen, daysPretendingToBeReserved, requestFromWhenDayInTheYearNumber);
//                }
//            }
////            }
//        }
//        return isOrNot;
//
//    }
//
//    private boolean checkingIfDatesAreOverlapping(LocalDate fromWhen, LocalDate tillWhen, int[] daysPretendingToBeReserved, int requestFromWhenDayInTheYearNumber) {
//
//        int[] alreadyReservedDays = new int[tillWhen.getDayOfYear() - fromWhen.getDayOfYear()];
//        int lengthOfAlreadyReservedDays = alreadyReservedDays.length;
//        int lengthOfDaysPretendingToBeReserved = daysPretendingToBeReserved.length;
//        boolean trueOrFalse = false;
//
//
//        if (tillWhen != fromWhen) {
//            for (int i = 0; i < lengthOfAlreadyReservedDays; i++) {
//                alreadyReservedDays[i] = fromWhen.getDayOfYear() + i;
//            }
//
//            for (int i = 0; i < lengthOfDaysPretendingToBeReserved; i++) {
//                daysPretendingToBeReserved[i] = requestFromWhenDayInTheYearNumber + i;
//            }
//
//            for (int alreadyReservedDay : alreadyReservedDays) {
//                for (int k : daysPretendingToBeReserved) {
//                    trueOrFalse = alreadyReservedDay != k;
//                }
//            }
//        } else {
//            trueOrFalse = fromWhen.getDayOfYear() != requestFromWhenDayInTheYearNumber;
//        }
//
//        return trueOrFalse;
//    }

}
