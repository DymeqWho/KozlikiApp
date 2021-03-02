package com.dymitrmisiejuk.kozliki.reservationlogic.reservationservice;

import com.dymitrmisiejuk.kozliki.reservationlogic.reservationrepository.ReservationRepository;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class ReservationServiceTest {

    @InjectMocks
    private ReservationService reservationService;

    @Mock
    private ReservationRepository reservationRepository;


//    public ReservationResponse readReservation(Long id) {
//        ReservationResponse reservationResponse = new ReservationResponse();
//
//        reservationResponse.setFromWhen(reservationRepository.findById(id).orElseThrow().getFromWhen());
//        reservationResponse.setTillWhen(reservationRepository.findById(id).orElseThrow().getTillWhen());
//        reservationResponse.setWhat(reservationRepository.findById(id).orElseThrow().getWhat());
//        reservationResponse.setWho(reservationRepository.findById(id).orElseThrow().getWho());
//        reservationResponse.setNotes(reservationRepository.findById(id).orElseThrow().getNotes());
//
//        return reservationResponse;
//    }

//    @Test
//    void test1() {
//
//        //given
//        Long id = Mockito.mock(Long.class);
//        ReservationResponse result = reservationService.readReservation(id);
//
//        //when
//        Mockito.when(reservationRepository.findById(id)).thenReturn(
//
//                (LocalDate.of(2020, 2, 2), LocalDate.of(2020, 2, 3), "Someone", "Something", "Something");
//
//        );
//
//
//        //then
//
//
//    }

}