package com.tomwaks.systemreservation.controller;

import com.tomwaks.systemreservation.controller.dto.ReservationRequestDto;
import com.tomwaks.systemreservation.controller.dto.ReservationResponseDto;
import com.tomwaks.systemreservation.model.Flat;
import com.tomwaks.systemreservation.model.Person;
import com.tomwaks.systemreservation.model.Reservation;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.tomwaks.systemreservation.controller.mapper.ReservationRequestMapper.mapReservationRequestDtoToReservation;
import static com.tomwaks.systemreservation.controller.mapper.ReservationResponseMapper.mapReservationsToReservationResponseDtos;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class ReservationControllerTests {


    @Test
    public void should_get_list_of_reservation(){
        ReservationController reservationController = mock(ReservationController.class);
        given(reservationController.findAll(null, null)).willReturn(prepareMockListOfReservations());

        ResponseEntity<List<ReservationResponseDto>> res = reservationController.findAll(null, null);

        assertThat(res.getBody(), Matchers.hasSize(3));
    }

    @Test
    void should_create_reservation() {
        ReservationController reservationController = mock(ReservationController.class);
        given(reservationController.createReservation(any(ReservationRequestDto.class))).willReturn(prepareMockNewReservation());

        ResponseEntity<ReservationResponseDto> res = reservationController.createReservation(new ReservationRequestDto());

        assertEquals(res.getBody().getFlatName(), "Flat3");
        assertEquals(res.getBody().getHostName(), "Katarzyna");
        assertEquals(res.getBody().getTenantName(), "Karol");
    }

    @Test
    void should_update_reservation() {
        ReservationController reservationController = mock(ReservationController.class);
        given(reservationController.updateReservation(any(Long.class), any(ReservationRequestDto.class))).willReturn(prepareMockNewReservation());

        ResponseEntity<ReservationResponseDto> res = reservationController.updateReservation(1L, new ReservationRequestDto());

        assertEquals(res.getBody().getFlatName(), "Flat3");
        assertEquals(res.getBody().getHostName(), "Katarzyna");
        assertEquals(res.getBody().getTenantName(), "Karol");
    }

    private ResponseEntity<List<ReservationResponseDto>> prepareMockListOfReservations(){
        List<ReservationResponseDto> reservationResponseDtos = new ArrayList<ReservationResponseDto>();

        ReservationResponseDto reservationResponseDto1 = new ReservationResponseDto(
                1L,
                new Date(1),
                new Date(2),
                0.0f,
                1L,
                "Monika",
                2L,
                "Izabela",
                1L,
                "Flat1",
                99,
                50.9f,
                "-"
        );

        ReservationResponseDto reservationResponseDto2 = new ReservationResponseDto(
                2L,
                new Date(3),
                new Date(4),
                0.0f,
                3L,
                "Katarzyna",
                4L,
                "Karol",
                2L,
                "Flat2",
                999,
                500.9f,
                "-"
        );

        ReservationResponseDto reservationResponseDto3 = new ReservationResponseDto(
                3L,
                new Date(5),
                new Date(6),
                0.0f,
                6L,
                "Katarzyna",
                7L,
                "Karol",
                3L,
                "Flat3",
                566,
                233.9f,
                "-"
        );


//        Flat flat1 = new Flat(1L, "Flat1", 199, 105.1f, "test1");
//        Flat flat2 = new Flat(2L, "Flat2", 299, 210.1f, "test2");
//        Flat flat3 = new Flat(3L, "Flat3", 499, 301.1f, "test3");
//
//        Person person1 = new Person(1L, "Tomasz");
//        Person person2 = new Person(2L, "Karol");
//        Person person3 = new Person(3L, "Monika");
//        Person person4 = new Person(4L, "Przemek");
//        Person person5 = new Person(5L, "Piotr");
//        Person person6 = new Person(6L, "Robert");
//
//        Reservation reservation1 = new Reservation(1L, new Date(1609459200000L), new Date(1609804800000L), 0.0f, person1, person2, flat1);
//        Reservation reservation2 = new Reservation(2L, new Date(1609459200000L), new Date(1610236800000L), 0.0f, person3, person4, flat2);
//        Reservation reservation3 = new Reservation(3L, new Date(1609459200000L), new Date(1610755200000L), 0.0f, person5, person6, flat3);
//
//        reservations.add(reservation1);
//        reservations.add(reservation2);
//        reservations.add(reservation3);

        reservationResponseDtos.add(reservationResponseDto1);
        reservationResponseDtos.add(reservationResponseDto2);
        reservationResponseDtos.add(reservationResponseDto3);

        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationResponseDtos);
    }

    private ResponseEntity<ReservationResponseDto> prepareMockNewReservation() {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(
                        new ReservationResponseDto(
                                3L,
                                new Date(5),
                                new Date(6),
                                0.0f,
                                6L,
                                "Katarzyna",
                                7L,
                                "Karol",
                                3L,
                                "Flat3",
                                566,
                                233.9f,
                                "-"
                        )
                );

    }
}
