package com.tomwaks.systemreservation.controller.mapper;

import com.tomwaks.systemreservation.controller.dto.ReservationRequestDto;
import com.tomwaks.systemreservation.model.Flat;
import com.tomwaks.systemreservation.model.Person;
import com.tomwaks.systemreservation.model.Reservation;
import lombok.NoArgsConstructor;

@NoArgsConstructor
public class ReservationRequestMapper {


    public static Reservation mapReservationRequestDtoToReservation(Long id, ReservationRequestDto reservationRequestDto) {
        return Reservation.ReservationBuilder.aReservation()
                .withId(id)
                .withRentalFrom(reservationRequestDto.getRentalFrom())
                .withRentalTo(reservationRequestDto.getRentalTo())
                .withHost(mapHostRequestToDtos(reservationRequestDto))
                .withTenant(mapTenantRequestToDtos(reservationRequestDto))
                .withFlat(mapFlatRequestToDtos(reservationRequestDto))
                .build();
    }

    private static Person mapHostRequestToDtos(ReservationRequestDto reservationRequestDto) {
        return Person.PersonBuilder.aPerson()
                .withId(reservationRequestDto.getHostId())
                .build();
    }

    private static Person mapTenantRequestToDtos(ReservationRequestDto reservationRequestDto) {
        return Person.PersonBuilder.aPerson()
                .withId(reservationRequestDto.getTenantId())
                .build();
    }

    private static Flat mapFlatRequestToDtos(ReservationRequestDto reservationRequestDto) {
        return Flat.FlatBuilder.aFlat()
                .withId(reservationRequestDto.getFlatId())
                .build();
    }
}
