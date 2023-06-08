package com.kaldev.vereinsmanager.data.service;

import com.kaldev.vereinsmanager.data.entity.Booking;
import com.kaldev.vereinsmanager.data.repository.BookingRepository;
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
