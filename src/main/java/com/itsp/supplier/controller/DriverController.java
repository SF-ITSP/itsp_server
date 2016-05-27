package com.itsp.supplier.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.common.util.DateUtil;
import com.itsp.supplier.entity.Driver;
import com.itsp.supplier.entity.DriverDataSource;
import com.itsp.supplier.service.DriverService;


@Scope("prototype")
@RestController
@RequestMapping(value = "/drivers")
public class DriverController {

	@Resource
	private DriverService driverService;

	@RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
	public List<Driver> loadByCarrierId(@PathVariable(value = "carrierId") long carrierId) {
		List<DriverDataSource> listDriver = driverService.getByCarrierId(carrierId);
		List<Driver> drivers = new ArrayList<Driver>();
		for (DriverDataSource driverDataSource : listDriver) {
			getDriverList(drivers, driverDataSource);
		}
		return drivers;
	}
	
	@RequestMapping(value = "/{carrierId}/{id}", method = RequestMethod.GET)
	public List<Driver> loadByCarrierIdAndDriverId(@PathVariable(value = "carrierId") long carrierId,@PathVariable(value = "id") long id) {
		List<DriverDataSource> listDriver = driverService.getByCarrierId(carrierId);
		List<Driver> drivers = new ArrayList<Driver>();
		for (DriverDataSource driverDataSource : listDriver) {
			getDriverList(drivers, driverDataSource);
		}
		return drivers;
	}

	private void getDriverList(List<Driver> drivers, DriverDataSource driverDataSource) {
		Driver driver = new Driver();
		driver.setAge(driverDataSource.getAge());
		driver.setCarrierId(driverDataSource.getCarrierId());
		driver.setDrivingLicenseType(driverDataSource.getDrivingLicenseType());
		driver.setName(driverDataSource.getName());
		String firstDriveDate = new SimpleDateFormat("yyyyMMdd").format(driverDataSource.getFirstDriveDate());
		String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
		driver.setDrivingExperience(DateUtil.getDateLength( firstDriveDate, currentDate));
		drivers.add(driver);
	}

}
