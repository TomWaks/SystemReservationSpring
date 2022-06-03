package com.tomwaks.systemreservation.repository;

import com.tomwaks.systemreservation.model.Flat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlatRepository extends JpaRepository<Flat, Long> {}
