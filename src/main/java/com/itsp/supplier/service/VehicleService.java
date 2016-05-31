package com.itsp.supplier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.VehicleDao;
import com.itsp.supplier.entity.Vehicle;
import com.itsp.supplier.entity.VehicleData;

@Component
public class VehicleService {
	@Autowired
	private VehicleDao vehicleDao;
	
	public List<Vehicle> geVehicles(long carrierId) {
		List<VehicleData> vehicleList = vehicleDao.getVehicle(carrierId);
		List<Vehicle> vehicles = new ArrayList<Vehicle>();
		for (VehicleData vehicle : vehicleList) {
			createVehicle(vehicles, vehicle);
		}
		return vehicles;
	}
	
	private void createVehicle(List<Vehicle> vehicles, VehicleData vehicle) {
		Vehicle newVehicle = new Vehicle();
		newVehicle.setVehicleNumber(vehicle.getVehicleNumber());
		newVehicle.setType(vehicle.getTypeName());
		newVehicle.setWeight(vehicle.getWeight());
		newVehicle.setCarrierId(vehicle.getCarrierId());
		vehicles.add(newVehicle);
	}
}
