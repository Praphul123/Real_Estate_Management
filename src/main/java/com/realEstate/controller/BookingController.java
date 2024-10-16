package com.realEstate.controller;

import com.realEstate.dto.BookingRequest;
import com.realEstate.entity.Booking;
import com.realEstate.service.BookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {

    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping
    public ResponseEntity<Booking> scheduleViewing(@RequestBody BookingRequest bookingRequest) {
        Booking booking = bookingService.scheduleViewing(
                bookingRequest.getPropertyId(),
                bookingRequest.getAgentId(),
                bookingRequest.getClientId(),
                bookingRequest.getViewingTime());
        return ResponseEntity.ok(booking);
    }

    @GetMapping
    public ResponseEntity<List<Booking>> getAllBookings() {
        return ResponseEntity.ok(bookingService.getAllBookings());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Booking> getBookingById(@PathVariable Long id) {
        return ResponseEntity.ok(bookingService.getBookingById(id));
    }
}
