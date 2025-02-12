package com.pro.pojos;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString(callSuper = true)
@Table(name="Vehicles")
public class Vehicle extends BaseEntity {

	
//	@Column(name ="Model",nullable=false)
//	private int ModelNo;
//	
//	@Column(name="Mileage")
//	private double Mileage;
//	
//	@Column(name="Vehicle No",length = 30,unique=true,nullable=false)
//	private String VehicleNo;
//	
//	@Column(name="Rent/Day",nullable=false)
//	private double rent;
//	
//	@Column(name="Remarks",length = 50,nullable=false)
//	private String remarks;
//	
//	@Column(name="Vehicle type",length = 30,nullable=false)
//	private VehicleType Vtype;
//	
//	@Column(name="Number of wheels",nullable=false)
//	private int NumberOfWheels;
	private String make;
    private String model;
    private int year;
    private String color;
    private double dailyRate;
    private boolean available;

   
		

}
