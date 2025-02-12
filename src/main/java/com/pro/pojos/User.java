package com.pro.pojos;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@NoArgsConstructor
@Getter
@Setter
@ToString(callSuper=true)

public class User extends BaseEntity {
        
	@Column(name="First_Name",length=30)
		private String fname;
	
	@Column(name="Last_Name",length=30)
		private String lname;
	
	@Column(name="Email",length=50,unique = true)
		private String email;
	
	@Column(length=20,nullable=false)
		private String password;
	
		private UserRole role; // Roles: ADMIN, CUSTOMER
		private String drivingLicence;
		private String phoneNo;
		private String address;
		private String city;
		private String state;
		private String zipCode;
		
	

	public User(String fname, String lname, String email, String password, LocalDate dob, UserRole role) {
		super();
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.password = password;
		this.role = role;
		
		
	}
	
	
		
}
