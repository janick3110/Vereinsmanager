package com.kaldev.vereinsmanager.controller;

import com.kaldev.vereinsmanager.entity.Booking;
import com.kaldev.vereinsmanager.entity.Field;
import com.kaldev.vereinsmanager.entity.Jersey;
import com.kaldev.vereinsmanager.repository.BookingRepository;
import com.kaldev.vereinsmanager.service.BookingService;
import com.kaldev.vereinsmanager.service.FieldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.DatabaseMetaData;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/bookings")
public class BookingController {
    private BookingRepository bookingRepository;

    @Autowired
    private BookingService bookingService;
    @Autowired
    private FieldService fieldService;

    public BookingController(BookingRepository repository) {
        this.bookingRepository = repository;
    }

    @GetMapping("")
    public List<Booking> bookingList(){
        return bookingRepository.findAll();
    }

    @PostMapping(path="/add")
    public ResponseEntity<Void> addNewBooking (
            @RequestParam String description,
            @RequestParam int idOfActivity,
            @RequestParam int idOfField,
            @RequestParam String amountSegmentsOfField,
            @RequestParam String startTime,
            @RequestParam String endTime
    ) {

        try {

            Booking booking = new Booking();

            booking.setDescription(description);
            booking.setIdOfField(idOfField);
            booking.setIdOfGroup(idOfActivity);
            booking.setAmountSegmentsOfField(Integer.parseInt(amountSegmentsOfField));
            booking.setStartTime(ConvertStringToDate(startTime));
            booking.setEndTime(ConvertStringToDate(endTime));

            bookingRepository.save(booking);

            return ResponseEntity.ok().build();

        } catch (Exception e){
            System.out.println("An error has occured:" + e.getStackTrace());
            return ResponseEntity.badRequest().build();
        }

    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteBooking(@PathVariable int id) {
        try {
            bookingRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (EmptyResultDataAccessException e) {
            return ResponseEntity.notFound().build();
        }
    }

    Date ConvertStringToDate(String date){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, formatter);
        Instant instant = dateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
