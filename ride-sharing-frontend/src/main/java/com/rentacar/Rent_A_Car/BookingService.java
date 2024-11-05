package com.rentacar.Rent_A_Car;

import java.time.LocalDateTime;

import org.springframework.stereotype.Service;

import com.rentacar.Rent_A_Car.Dto.BookingDto;
import com.rentacar.Rent_A_Car.Repository.BookingRepository;
import com.rentacar.Rent_A_Car.Repository.RideRepository;

@Service
public class BookingService {
    private final BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public Booking createBooking(BookingDto bookingDto, User rider) {
        Booking booking = new Booking();
        booking.setRide(RideRepository.findById(bookingDto.getRideId()).orElseThrow());
        booking.setRider(rider);
        booking.setBookingTime(LocalDateTime.now());
        booking.setSeatsBooked(bookingDto.getSeatsBooked());
        return bookingRepository.save(booking);
    }
}
