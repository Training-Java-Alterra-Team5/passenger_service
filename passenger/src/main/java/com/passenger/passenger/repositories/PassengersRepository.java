package com.passenger.passenger.repositories;

import com.passenger.passenger.models.Passengers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengersRepository extends JpaRepository<Passengers, Long> {
    Passengers findPassengersById(Integer passengerId);
    Passengers findPassengersByUsername(String userName);
    Passengers findPassengersByName(String passengerName);
}
