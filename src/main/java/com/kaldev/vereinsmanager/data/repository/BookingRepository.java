package com.kaldev.vereinsmanager.data.repository;

import com.kaldev.vereinsmanager.data.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking,Integer> {
}
