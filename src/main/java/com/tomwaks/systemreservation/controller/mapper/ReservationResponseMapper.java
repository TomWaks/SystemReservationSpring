package com.tomwaks.systemreservation.controller.mapper;

import com.tomwaks.systemreservation.controller.dto.ReservationResponseDto;
import com.tomwaks.systemreservation.model.Reservation;

import java.util.List;
import java.util.stream.Collectors;

public class ReservationResponseMapper {


    public static List<ReservationResponseDto> mapReservationsToReservationResponseDtos(List<Reservation> reservations){
        return reservations.stream()
                .map(ReservationResponseMapper::mapReservationToReservationResponseDto)
                .collect(Collectors.toList());
    }

    public static ReservationResponseDto mapReservationToReservationResponseDto(Reservation reservation){
        return  ReservationResponseDto.ReservationResponseDtoBuilder
            .aReservationResponseDto()
            .withId(reservation.getId())
            .withRentalFrom(reservation.getRentalFrom())
            .withRentalTo(reservation.getRentalTo())
            .withHostId(reservation.getHost().getId())
            .withHostName(reservation.getHost().getName())
            .withTenantId(reservation.getTenant().getId())
            .withTenantName(reservation.getTenant().getName())
            .withFlatId(reservation.getFlat().getId())
            .withFlatName(reservation.getFlat().getName())
            .withFlatPrice(reservation.getFlat().getPrice())
            .withFlatArea(reservation.getFlat().getArea())
            .withFlatDescription(reservation.getFlat().getDescription())
            .build();
    }
}
