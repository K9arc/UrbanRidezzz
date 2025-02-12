package com.pro.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(callSuper =true,exclude="custPass")
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Customers")
public class Customer extends BaseEntity {

	
	@Column(name="FirstName",length=30,nullable=false)
	private String Fname;

	@Column(name="LastName",length=30,nullable=false)
	private String Lname;
	
	@Column(name="Address",length=50)
	private String Address;

	@Column(name="City",length=30)
	private String city;

	@Column(name="state",length=30)
	private String State;
	
	@Column(name="Zip_Code",length=30)
	private String zipCode;
	
	@Column(name="email",unique=true)
	private String email;
	
	@Column(name="Customer_Password",nullable=false)
	private String password;
	
	@Column(name="PhoneNo.",length=30,nullable=false)
	private String PhoneNo;

	@Column(name="DL",length=50,unique=true,nullable=false)
	private String DrivingLicence;
}
