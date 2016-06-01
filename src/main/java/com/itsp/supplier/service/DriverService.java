package com.itsp.supplier.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itsp.common.util.DateUtil;
import com.itsp.supplier.dao.DriverDao;
import com.itsp.supplier.entity.Driver;
import com.itsp.supplier.entity.DriverDataSource;

@Component
public class DriverService {

	@Resource
	private DriverDao driverDao;

	public List<Driver> getByCarrierId(long carrierId) {
		List<DriverDataSource> listDriver = driverDao.getByCarrierId(carrierId);
		
		return listDriver.stream().map(driverDataSource -> createDriver(driverDataSource)).collect(Collectors.toList());	
	}

	public Driver getByDriverId(long id) {
		DriverDataSource driverDataSource = driverDao.load(id);
		return createDriver(driverDataSource);
	}

	private Driver createDriver(DriverDataSource driverDataSource) {
		Driver driver = new Driver();
		
		driver.setAge(driverDataSource.getAge());
		driver.setCarrierId(driverDataSource.getCarrierId());
		driver.setId(driverDataSource.getId());
		driver.setDrivingLicenseType(driverDataSource.getDrivingLicenseType());
		driver.setName(driverDataSource.getName());
		driver.setDrivingExperience(DateUtil.DifferenceBetweenDate(driverDataSource.getFirstDriveDate()));
		
		return driver;
	}
}
