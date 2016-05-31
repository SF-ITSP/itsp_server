package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.supplier.entity.DriverTask;
import com.itsp.supplier.service.DriverTaskService;

@Scope("prototype")
@RestController
@RequestMapping("/driverTask")
public class DriverTaskController {
	@Autowired
	private DriverTaskService driverService;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<DriverTask> getTasks() {
		return driverService.getTasks();
	}
}