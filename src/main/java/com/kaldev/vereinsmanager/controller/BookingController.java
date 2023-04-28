package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Booking;
import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.repository.BookingRepository;
import com.kaldev.vereinsmanager.service.BookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;

    public BookingController(BookingRepository repository) {
        this.bookingRepository = repository;
    }

    @GetMapping("")
    public List<Booking> playerList(){
        return bookingRepository.findAll();
    }
}
