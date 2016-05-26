package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Vehicle;
import com.itsp.supplier.entity.VehicleData;
import com.itsp.supplier.service.VehicleService;

@Component
@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;

	@RequestMapping("/vehicles")
	public List<Vehicle> getVehicle() {
		List<VehicleData> vehicleList = vehicleService.geVehicles();
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		for (VehicleData vehicle : vehicleList) {
			Vehicle newVehicle = new Vehicle();
			newVehicle.setVehicleNumber(vehicle.getVehicleNumber());
			vehicles.add(newVehicle);
		}
		return vehicles;
	}
}
