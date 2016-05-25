package com.itsp.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.VehicleDao;
import com.itsp.supplier.entity.Vehicle;

@Component
public class VehicleService {
	@Autowired
	private VehicleDao vehicleDao;
	
	public List<Vehicle> getTasks() {
		return vehicleDao.getVehicles();
	}
	
}
