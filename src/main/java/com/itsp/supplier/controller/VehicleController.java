package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itsp.supplier.entity.Vehicle;
import com.itsp.supplier.service.VehicleService;

@Component
@Controller
@RequestMapping("/vehicles")
public class VehicleController {
	@Autowired
	private VehicleService vehicleService;
	
	@RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
	public List<Vehicle> getVehicle(@PathVariable(value = "carrierId") long carrierId) {
		return vehicleService.geVehicles(carrierId);
	}
}
