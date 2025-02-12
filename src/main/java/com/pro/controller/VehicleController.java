package com.pro.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.pro.dto.ApiResponse;
import com.pro.dto.VehicleDTO;
import com.pro.pojos.Customer;
import com.pro.pojos.Vehicle;
import com.pro.service.VehcileServ;

//@RestController
//@RequestMapping("/vehicle")
//public class VehicleController {
//	
//	@Autowired
//	private VehcileServ vServ;
//	
//
//	@PostMapping
//	public ResponseEntity<?> InsertVehilce(@RequestBody Vehicle veh) {
//		
//		return ResponseEntity.status(HttpStatus.CREATED).body(new ApiResponse(vServ.AddVehicle(veh)));
//	}
//	
//	@GetMapping
//	public ResponseEntity<?> getAllVehicles() {
//		List<Vehicle>vop=vServ.getVehicle();
//		if(vop.isEmpty())
//		{
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
//		}
//		return ResponseEntity.ok(vop);
//	}
//	
//	@DeleteMapping("/{vid}")
//	ResponseEntity<?> DeleteVehId(@PathVariable Long vid)
//	{
//		try {
//			return ResponseEntity.ok(new ApiResponse(vServ.DeleteVehicle(vid)));
//			}
//		catch(RuntimeException excep)
//		{
//		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(excep.getMessage()));
//		}
//	}
//	
//	@PutMapping("/{vid}")
//	ResponseEntity<?> UpdateVehicle(@PathVariable Long vid,@RequestBody Vehicle veh)
//	{
//		return ResponseEntity.ok(new ApiResponse(vServ.UpdateVehicle(vid, veh)));
//	}
//	
//	@GetMapping("/{vid}")
//	public ResponseEntity<?> getVehicleById(@PathVariable Long vid) {
//	
//		return ResponseEntity.ok(vServ.getVehicleById(vid));
//	}
//
//}
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/vehicles")
public class VehicleController {
    @Autowired
    private VehcileServ vehicleService;

    @PostMapping
    public Vehicle addVehicle(@RequestBody VehicleDTO vehicleDTO) {
    	System.out.println(vehicleDTO.getDailyRate());
        return vehicleService.addVehicle(vehicleDTO);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicles();
    }

    @GetMapping("/{id}")
    public Vehicle getVehicleById(@PathVariable Long id) {
        return vehicleService.getVehicleById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Long id) {
        vehicleService.deleteVehicle(id);
    }
   /* @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteVehicle(@PathVariable Long id) {
        try {
            vehicleService.deleteVehicle(id);
            return ResponseEntity.ok("Vehicle deleted successfully.");
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Failed to delete vehicle.");
        }
    }*/
}
