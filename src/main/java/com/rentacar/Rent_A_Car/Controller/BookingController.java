package com.rentacar.Rent_A_Car.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.Rent_A_Car.Booking;
import com.rentacar.Rent_A_Car.BookingService;
import com.rentacar.Rent_A_Car.User;
import com.rentacar.Rent_A_Car.Dto.BookingDto;

@RestController
@RequestMapping("/api/bookings")
public class BookingController {
    private final BookingService bookingService;

    public BookingController(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @PostMapping("/create")
    public ResponseEntity<Booking> createBooking(@RequestBody BookingDto bookingDto,
            @AuthenticationPrincipal User rider) {
        Booking booking = bookingService.createBooking(bookingDto, rider);
        return ResponseEntity.ok(booking);
    }
}
