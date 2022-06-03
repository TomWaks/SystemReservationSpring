package com.tomwaks.systemreservation.service;
import com.tomwaks.systemreservation.model.Reservation;
import java.util.List;
public interface ReservationService {
    List<Reservation> findAll(String tenantName, String flatName) ;
    Reservation createReservation(Reservation reservation);
    Reservation updateReservation(Long id, Reservation reservation);
}
