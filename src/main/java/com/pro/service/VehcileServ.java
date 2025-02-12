package com.pro.service;

import java.util.List;

import com.pro.dto.VehicleDTO;
import com.pro.pojos.Vehicle;

public interface VehcileServ {
	
//	String AddVehicle(Vehicle vehl);
//	
//	List<Vehicle>getVehicle();
//	
//	String DeleteVehicle(Long Id);
//	
//	String UpdateVehicle(Long Id,Vehicle vehi);
//	
//	Vehicle getVehicleById(Long id);
	Vehicle addVehicle(VehicleDTO vehicleDTO);
    List<Vehicle> getAllVehicles();
    Vehicle getVehicleById(Long id);
    void deleteVehicle(Long id);
	
}
