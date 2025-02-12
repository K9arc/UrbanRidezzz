package com.pro.pojos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@ToString(callSuper = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="Employees")
public class Employee extends BaseEntity {

@Column(name="FirstName",length = 30,nullable=false)
private String Fname;

@Column(name="LastName",length = 30,nullable=false)
private String Lname;

@Column(name="Address",length = 50)
private String Address;

@Column(name="City",length = 30)
private String City;

@Column(name="state",length = 30)
private String State;

@Column(name="Zip_Code",length=30)
private String zipCode;

@Column(name="email",length=30,unique=true,nullable=false)
private String email;

@Column(name="Employee_Password",nullable=false)
private String password;

@Column(name="Phone_No",length=15,nullable=false)
private String phoneNo;

@Column(name="Salary")
private double Salary;

@Column(name="JoinDate")
private LocalDate JoinedDate;

@Enumerated(EnumType.STRING)
@Column(name="Position",length = 30)
private Position Ptype;



}
