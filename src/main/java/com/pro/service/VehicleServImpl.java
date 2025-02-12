package com.pro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pro.Dao.VehicleDao;
import com.pro.Exception.ResourceNotFoundException;
import com.pro.dto.VehicleDTO;
import com.pro.pojos.Vehicle;
import java.util.ArrayList;
import jakarta.transaction.Transactional;

@Service
@Transactional
public class VehicleServImpl implements VehcileServ {

	@Autowired
	private VehicleDao vDao;

//	@Override
//	public String AddVehicle(Vehicle vehl) {
//		Vehicle vs=vDao.save(vehl);
//		return "Added vehicle!!"+vs;
//	}
//
//	@Override
//	public List<Vehicle> getVehicle() {
//		List<Vehicle> vp=vDao.findAll();
//		return vp;
//	}
//
//	@Override
//	public String DeleteVehicle(Long Id) {
//		if(vDao.existsById(Id))
//		{
//			vDao.deleteById(Id);
//			return "Deleted succesfully!!";
//		}
//		throw new ResourceNotFoundException("Invalid Id!! ");
//	}
//
//	@Override
//	public String UpdateVehicle(Long Id, Vehicle vehi) {
//		if(vDao.existsById(Id))
//		{
//			Vehicle vp=vDao.save(vehi);
//			return "Updated Details!!"+vp;
//		}
//		throw new ResourceNotFoundException("Invalid Id!! ");
//	}

	@Override
	public Vehicle getVehicleById(Long id) {
		return vDao.findById(id).orElseThrow(()->new ResourceNotFoundException("Invalid Id!"));
	}

	 private List<Vehicle> vehicles = new ArrayList<>();
	    private Long nextId = 1L;

	    @Override
	    public Vehicle addVehicle(VehicleDTO vehicleDTO) {
	        Vehicle vehicle = new Vehicle();
	        vehicle.setId(nextId++);
	        vehicle.setMake(vehicleDTO.getMake());
	        vehicle.setModel(vehicleDTO.getModel());
	        vehicle.setYear(vehicleDTO.getYear());
	        vehicle.setColor(vehicleDTO.getColor());
	        vehicle.setDailyRate(vehicleDTO.getDailyRate());
	        vehicle.setAvailable(vehicleDTO.isAvailable());
//	        vehicles.add(vehicle);
	        vDao.save(vehicle);
	        return vehicle;
	    }

	    @Override
	    public List<Vehicle> getAllVehicles() {
	        return vDao.findAll();
	    }

	    @Override
	    public void deleteVehicle(Long id) {
	        vehicles.removeIf(vehicle -> vehicle.getId().equals(id));
	    }
	   /* @Override
	    public void deleteVehicle(Long id) {
        if (!vDao.existsById(id)) {
            throw new IllegalArgumentException("Vehicle with ID " + id + " does not exist.");
        }
        vDao.deleteById(id);
    }*/
}
