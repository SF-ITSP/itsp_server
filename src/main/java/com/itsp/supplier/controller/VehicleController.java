package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Vehicle;
import com.itsp.supplier.service.VehicleService;

@Component
@Controller
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping("/vehicle")
	public List<Vehicle> getVehicles() {
		List<Vehicle> vehicleList = vehicleService.getVehicles();
		return vehicleList;
	}
	
}
