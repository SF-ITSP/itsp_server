package com.itsp.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.DriverTaskDao;
import com.itsp.supplier.entity.DriverTask;

@Component
public class DriverTaskService {
	@Autowired
	private DriverTaskDao driverTaskDao;

	public List<DriverTask> getTasks() {
		return driverTaskDao.getTasks();
	}
}
