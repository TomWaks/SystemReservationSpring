package com.tomwaks.systemreservation.service.impl;

import com.tomwaks.systemreservation.controller.dto.ReservationRequestDto;
import com.tomwaks.systemreservation.exception.ResourceConflictDates;
import com.tomwaks.systemreservation.exception.ResourceNotFoundException;
import com.tomwaks.systemreservation.model.Flat;
import com.tomwaks.systemreservation.model.Person;
import com.tomwaks.systemreservation.model.Reservation;
import com.tomwaks.systemreservation.repository.FlatRepository;
import com.tomwaks.systemreservation.repository.PersonRepository;
import com.tomwaks.systemreservation.repository.ReservationRepository;
import com.tomwaks.systemreservation.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

import static com.tomwaks.systemreservation.repository.ReservationRepository.*;

@Service
@RequiredArgsConstructor
public class ReservationServiceImpl implements ReservationService {

    private final ReservationRepository reservationRepository;
    private final PersonRepository personRepository;
    private final FlatRepository flatRepository;
    @Override
    public List<Reservation> findAll(String tenantName,String flatName){
        if(tenantName != null && flatName != null) {
            return reservationRepository.findAll(hasFlatName(flatName).and(hasTenantName(tenantName)));
        }

        if(tenantName == null && flatName != null) {
            return reservationRepository.findAll(hasFlatName(flatName));
        }

        if(tenantName != null) {
            return reservationRepository.findAll(hasTenantName(tenantName));
        }
        return reservationRepository.findAll();
    }

    @Transactional
    @Override
    public Reservation createReservation(Reservation reservation){

        long flatId = reservation.getFlat().getId();
        long tenantId = reservation.getTenant().getId();
        long hostId = reservation.getHost().getId();

        Flat f = flatRepository.findById(reservation.getFlat().getId()).orElseThrow(() -> new ResourceNotFoundException("Flat", "id", flatId));
        Person t = personRepository.findById(reservation.getTenant().getId()).orElseThrow(() -> new ResourceNotFoundException("Person", "id", tenantId));
        Person h = personRepository.findById(reservation.getHost().getId()).orElseThrow(() -> new ResourceNotFoundException("Person", "id", hostId));

        reservation.setFlat(f);
        reservation.setTenant(t);
        reservation.setHost(h);

        Date rentalFrom = reservation.getRentalFrom();
        Date rentalTo = reservation.getRentalTo();

        reservation.setTotalCost();

        if(reservationRepository.countConflicts(0L, flatId, rentalFrom, rentalTo) == 0){
            return reservationRepository.save(reservation);
        }else{
            throw new ResourceConflictDates();
        }
    }

    @Transactional
    @Override
    public Reservation updateReservation(Long id, Reservation reservation) {

        reservationRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Reservation", "id", id));

        long flatId = reservation.getFlat().getId();
        Date rentalFrom = reservation.getRentalFrom();
        Date rentalTo = reservation.getRentalTo();

        if(reservationRepository.countConflicts(id, flatId, rentalFrom, rentalTo) == 0){
            return reservationRepository.save(reservation);
        }else{
            throw new ResourceConflictDates();
        }
    }
}
