package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itsp.supplier.entity.Vehicle;
import com.itsp.supplier.entity.VehicleData;
import com.itsp.supplier.service.VehicleService;

@Component
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
	public List<Vehicle> getVehicle(@PathVariable(value = "carrierId") long carrierId) {
		List<VehicleData> vehicleList = vehicleService.geVehicles(carrierId);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();

		for (VehicleData vehicle : vehicleList) {
			Vehicle newVehicle = new Vehicle();
			newVehicle.setVehicleNumber(vehicle.getVehicleNumber());
			newVehicle.setType(vehicle.getTypeName());
			newVehicle.setWeight(vehicle.getWeight());
			newVehicle.setCarrierId(vehicle.getCarrierId());
			vehicles.add(newVehicle);
		}
		return vehicles;
	}
}
