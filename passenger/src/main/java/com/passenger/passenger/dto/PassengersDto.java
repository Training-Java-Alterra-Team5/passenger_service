package com.passenger.passenger.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PassengersDto {
    private Integer roleId;
    private String username;
    private String password;
    private String name;
    private String address;
    private String mobileNumber;
}
