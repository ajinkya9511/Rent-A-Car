package com.rentacar.Rent_A_Car.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.Rent_A_Car.Ride;

@Repository
public interface RideRepository extends JpaRepository<Ride, Long> {
    List<Ride> findByStartLocationAndEndLocation(String startLocation, String endLocation);
}
