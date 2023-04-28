package com.kaldev.vereinsmanager.service;

import com.kaldev.vereinsmanager.entity.Booking;
import com.kaldev.vereinsmanager.entity.Field;
import com.kaldev.vereinsmanager.repository.BookingRepository;
import com.kaldev.vereinsmanager.repository.FieldRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class BookingService {
    @Autowired
    private BookingRepository bookingRepository;

    public List<Booking> listAllFields() {
        return bookingRepository.findAll();
    }


    public void saveBooking(Booking booking) {
        bookingRepository.save(booking);
    }

    public Booking getBooking(Integer id) {
        return bookingRepository.findById(id).get();
    }

    public void deleteBooking(Integer id) {
        bookingRepository.deleteById(id);
    }
}
