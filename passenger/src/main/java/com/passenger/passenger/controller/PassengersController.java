package com.passenger.passenger.controller;

import com.passenger.passenger.dto.PassengersDto;
import com.passenger.passenger.services.PassengersService;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@Slf4j
public class PassengersController {

    @Autowired
    private PassengersService passengerssService;

    @SneakyThrows(Exception.class)
    @PostMapping(path = "/passenger", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> newPassenger(@RequestBody PassengersDto passengerRequest){
        log.info("api POST /api/v1/passenger is hit.");
        return passengerssService.addPassenger(passengerRequest);
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/passenger", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getAllPassenger(){
        log.info("api GET /api/v1/passenger is hit.");
        return passengerssService.getPassengers();
    }

    @SneakyThrows(Exception.class)
    @GetMapping(path = "/passenger/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> getPassengerById(@PathVariable Integer id){
        log.info("api GET /api/v1/passenger/{id} is hit.");
        return passengerssService.getPassengerById(id);
    }

    @SneakyThrows(Exception.class)
    @PutMapping(path = "/passenger/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Object> updatePassengerById(@PathVariable Integer id, @RequestBody PassengersDto passengerReq){
        log.info("api PUT /api/v1/passenger/{id} is hit.");
        return passengerssService.updatePassengerById(id, passengerReq);
    }
}
