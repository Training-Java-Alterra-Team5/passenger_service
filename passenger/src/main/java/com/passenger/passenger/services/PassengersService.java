package com.passenger.passenger.services;

import com.passenger.passenger.dto.PassengersDto;
import com.passenger.passenger.models.Passengers;
import com.passenger.passenger.models.Roles;
import com.passenger.passenger.repositories.PassengersRepository;
import com.passenger.passenger.repositories.RolesRepository;
import io.swagger.annotations.ApiOperation;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional(rollbackOn = Exception.class)
public class PassengersService {

    @Autowired
    private PassengersRepository passengersRepository;

    @Autowired
    private RolesRepository rolesRepository;

    @SneakyThrows(Exception.class)
    @ApiOperation("Add new passenger")
    public ResponseEntity<Object> addPassenger(PassengersDto passengerReq){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Passengers passengers = new Passengers();
        passengers.setUsername(passengerReq.getUsername());
        passengers.setPassword(passengerReq.getPassword());
        passengers.setName(passengerReq.getName());
        passengers.setAddress(passengerReq.getAddress());
        passengers.setMobileNumber(passengerReq.getMobileNumber());

        Roles theRole = new Roles();
        theRole = rolesRepository.findRolesById(passengerReq.getRoleId());

        passengers.setRoles(theRole);

        passengersRepository.save(passengers);

        return  ResponseEntity.status(HttpStatus.OK).headers(headers).body(passengerReq);
    }

    @SneakyThrows(Exception.class)
    @ApiOperation("Get all passengers")
    public ResponseEntity<Object> getPassengers(){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        List<Passengers> resp = passengersRepository.findAll();

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(resp);
    }

    @SneakyThrows(Exception.class)
    @ApiOperation("Get passenger by Id")
    public ResponseEntity<Object> getPassengerById(Integer passengerId){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Passengers passengers = passengersRepository.findPassengersById(passengerId);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(passengers);
    }

    @SneakyThrows(Exception.class)
    @ApiOperation("Get passenger by name")
    public ResponseEntity<Object> getPassengerByName(String passengerName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Passengers passengers = passengersRepository.findPassengersByName(passengerName);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(passengers);
    }

    @SneakyThrows(Exception.class)
    @ApiOperation("Get passenger by username")
    public ResponseEntity<Object> getPassengerByUsername(String userName){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Passengers passengers = passengersRepository.findPassengersByUsername(userName);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(passengers);
    }

    @SneakyThrows(Exception.class)
    @ApiOperation("Update data passenger")
    public ResponseEntity<Object> updatePassengerById(Integer passengerId, PassengersDto passengerReq){
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Passengers passengers = passengersRepository.findPassengersById(passengerId);
        if(passengerReq.getUsername() != null)
            passengers.setUsername(passengerReq.getUsername());
        if(passengerReq.getPassword() != null && passengerReq.getPassword() != "")
            passengers.setAddress(passengerReq.getPassword());
        if(passengerReq.getName() != null && passengerReq.getName() != "")
            passengers.setName(passengerReq.getName());
        if(passengerReq.getAddress() != null && passengerReq.getAddress() != "")
            passengers.setAddress(passengerReq.getAddress());
        if(passengerReq.getRoleId() != null){
            Roles roles = new Roles();
            roles.setId(passengerReq.getRoleId());
            passengers.setRoles(roles);
        }

        passengersRepository.save(passengers);

        return ResponseEntity.status(HttpStatus.OK).headers(headers).body(passengerReq);
    }
}
