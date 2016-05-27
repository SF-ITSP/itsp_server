package com.itsp.supplier.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
	public List<Driver> loadByCarrierIdAndStatus(@PathVariable(value = "carrierId") long carrierId) {
		List<DriverDataSource> listDriver = driverService.getByCarrierId(carrierId);
		List<Driver> drivers = new ArrayList<Driver>();
		for (DriverDataSource driverDataSource : listDriver) {
			Driver driver = new Driver();
			driver.setAge(driverDataSource.getAge());
			driver.setCarrierId(driverDataSource.getCarrierId());
			driver.setDrivingLicenseType(driverDataSource.getDrivingLicenseType());
			driver.setName(driverDataSource.getName());
			String firstDriveDate = new SimpleDateFormat("yyyyMMdd").format(driverDataSource.getFirstDriveDate());
			String currentDate = new SimpleDateFormat("yyyyMMdd").format(new Date());
			driver.setDrivingExperience(getDateLength( firstDriveDate, currentDate)[0]);
			drivers.add(driver);
		}
		return drivers;
	}
	
	static  int[]  getDateLength(String  fromDate, String  toDate)  { 
	     Calendar  c1  =  getCal(fromDate); 
	     Calendar  c2  =  getCal(toDate); 
	     int[]  p1  =  {  c1.get(Calendar.YEAR), c1.get(Calendar.MONTH), c1.get(Calendar.DAY_OF_MONTH)  }; 
	     int[]  p2  =  {  c2.get(Calendar.YEAR), c2.get(Calendar.MONTH), c2.get(Calendar.DAY_OF_MONTH)  }; 
	     return  new  int[]  {  p2[0]  -  p1[0]  }; 
	  } 
	  
	  static  Calendar  getCal(String  date)  { 
	     Calendar  cal  =  Calendar.getInstance(); 
	     cal.clear(); 
	     cal.set(Integer.parseInt(date.substring(0, 4)), Integer.parseInt(date.substring(4, 6))  -  1, Integer.parseInt(date.substring(6, 8))); 
	     return  cal; 
	  } 
	
	
}
