package com.pro.dto;
import com.pro.pojos.UserRole;

import lombok.Data;

@Data
public class UserDTO {
    private Long id;
    private String fname;
    private String lname;
    private String email;
    private String password;
    private UserRole role;
    private String drivingLicence;
    private String phoneNo;
    private String address;
    private String city;
    private String state;
    private String zipCode;
}
