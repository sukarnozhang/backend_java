package com.cinema_package.cinema_project;

import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/booking")
public class BookingController {
    
    private BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    //CREATE
    @PostMapping("")
    public ResponseEntity<Booking> createBooking (@RequestBody Booking booking) {
        Booking newBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(newBooking, HttpStatus.CREATED);
    }

    //READ
    @GetMapping("")
    public ResponseEntity<List<Booking>> getBooking () {
        List<Booking> getBooking = bookingService.getBooking();
        return new ResponseEntity<>(getBooking, HttpStatus.OK);
    }
}
