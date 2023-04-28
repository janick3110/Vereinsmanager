package com.kaldev.vereinsmanager.repository;

import com.kaldev.vereinsmanager.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
