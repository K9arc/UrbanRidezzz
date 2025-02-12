package com.pro.dto;

import lombok.Data;

@Data
public class VehicleDTO {
	    private Long id;
	    private String make;
	    private String model;
	    private int year;
	    private String color;
	    private double dailyRate;
	    private boolean available;
}
