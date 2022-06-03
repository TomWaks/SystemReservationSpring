package com.tomwaks.systemreservation.controller;

import com.tomwaks.systemreservation.controller.dto.ReservationRequestDto;
import com.tomwaks.systemreservation.controller.dto.ReservationResponseDto;
import com.tomwaks.systemreservation.model.Reservation;
import com.tomwaks.systemreservation.service.impl.ReservationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.tomwaks.systemreservation.controller.mapper.ReservationRequestMapper.mapReservationRequestDtoToReservation;
import static com.tomwaks.systemreservation.controller.mapper.ReservationResponseMapper.mapReservationToReservationResponseDto;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    public static final Long EMPTY_ID = null;

    private final ReservationServiceImpl reservationServiceImpl;

    @GetMapping("/reservations")
    public ResponseEntity<List<ReservationResponseDto>> findAll(@RequestParam(value="tenant_name", required=false) String tenantName,
                                                @RequestParam(value="flat_name", required=false) String flatName) {

        return ResponseEntity.status(HttpStatus.OK)
                .body(mapReservationToReservationResponseDto(reservationServiceImpl.findAll(tenantName, flatName)));

    }

    @PostMapping("/reservations")
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequestDto reservationRequestDto) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(reservationServiceImpl.createReservation(
                        mapReservationRequestDtoToReservation(EMPTY_ID, reservationRequestDto)));
    }

    @PutMapping("/reservations/{id}")
    public ResponseEntity<Reservation> updateReservation(@PathVariable Long id, @RequestBody ReservationRequestDto reservationRequestDto) {
        return ResponseEntity.status(HttpStatus.OK)
                .body(reservationServiceImpl.updateReservation(id, mapReservationRequestDtoToReservation(id, reservationRequestDto)));
    }
}
