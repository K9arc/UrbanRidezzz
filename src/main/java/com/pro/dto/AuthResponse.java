package com.pro.dto;

import java.time.LocalDate;

import com.pro.pojos.BaseEntity;
import com.pro.pojos.UserRole;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class AuthResponse extends BaseEntity {
	
	private String fname;
	private String lname;
	private String email;
	private LocalDate dob;
	private UserRole role;

	
}
