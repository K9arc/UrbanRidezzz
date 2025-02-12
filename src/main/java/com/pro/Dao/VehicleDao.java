package com.pro.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pro.pojos.Vehicle;

public interface VehicleDao extends JpaRepository<Vehicle, Long> {

}
