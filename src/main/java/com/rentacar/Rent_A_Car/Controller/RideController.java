package com.rentacar.Rent_A_Car.Controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rentacar.Rent_A_Car.Ride;
import com.rentacar.Rent_A_Car.RideService;
import com.rentacar.Rent_A_Car.User;
import com.rentacar.Rent_A_Car.Dto.RideDto;

@RestController
@RequestMapping("/api/rides")
public class RideController {
    private final RideService rideService;

    public RideController(RideService rideService) {
        this.rideService = rideService;
    }

    @PostMapping("/create")
    public ResponseEntity<Ride> createRide(@RequestBody RideDto rideDto, @AuthenticationPrincipal User driver) {
        Ride ride = rideService.createRide(rideDto, driver);
        return ResponseEntity.ok(ride);
    }
}
