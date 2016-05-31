package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itsp.supplier.entity.Driver;
import com.itsp.supplier.service.DriverService;

@Scope("prototype")
@Controller
@RequestMapping(value = "/drivers")
public class DriverController {

	@Autowired
	private DriverService driverService;

	@RequestMapping(value = "/carrier/{carrierId}", method = RequestMethod.GET)
	public List<Driver> findByCarrierId(@PathVariable(value = "carrierId") long carrierId) {
		return driverService.getByCarrierId(carrierId);
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public Driver findByDriverId(@PathVariable(value = "id") long id) {
		return driverService.getByDriverId(id);
	}
}
