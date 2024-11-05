package com.rentacar.Rent_A_Car.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rentacar.Rent_A_Car.Booking;

@Repository
public interface BookingRepository extends JpaRepository<Booking, Long> {
}
