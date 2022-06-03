package com.tomwaks.systemreservation.repository;

import com.tomwaks.systemreservation.model.Reservation;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>, JpaSpecificationExecutor<Reservation> {

    @EntityGraph(value = "reservation-entity-graph")
    List<Reservation> findAll();

    @Query(value = "SELECT COUNT(r) FROM Reservation r WHERE r.flat.id=:flatId AND :rentalFrom < r.rentalTo AND r.rentalTo < :rentalTo AND r.id !=:id")
    long countConflicts(@Param("id") Long id,
                        @Param("flatId") Long flatId,
                        @Param("rentalFrom") Date rentalFrom,
                        @Param("rentalTo") Date rentalTo);

    static Specification<Reservation> hasTenantName(String tenantName) {
        return (book, cq, cb) -> cb.equal(book.get("tenant").get("name"), tenantName);
    }
    static Specification<Reservation> hasFlatName(String flatName) {
        return (book, cq, cb) -> cb.equal(book.get("flat").get("name"), flatName);
    }
}
