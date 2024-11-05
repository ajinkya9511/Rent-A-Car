package com.rentacar.Rent_A_Car;

import org.springframework.stereotype.Service;

import com.rentacar.Rent_A_Car.Dto.RideDto;
import com.rentacar.Rent_A_Car.Repository.RideRepository;

@Service
public class RideService {
    private final RideRepository rideRepository;

    public RideService(RideRepository rideRepository) {
        this.rideRepository = rideRepository;
    }

    public Ride createRide(RideDto rideDto, User driver) {
        Ride ride = new Ride();
        ride.setStartLocation(rideDto.getStartLocation());
        ride.setEndLocation(rideDto.getEndLocation());
        ride.setDepartureTime(rideDto.getDepartureTime());
        ride.setAvailableSeats(rideDto.getAvailableSeats());
        ride.setPrice(rideDto.getPrice());
        ride.setDriver(driver);
        return rideRepository.save(ride);
    }
}
