package com.itsp.supplier.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.dao.JdbcDao;
import com.itsp.supplier.entity.Vehicle;

public class VehicleControllerTest extends ItspJUnit4ClassRunner {
	
	@Autowired
	private VehicleController vehicleController;
	@Autowired
	private JdbcDao jdbcDao;

	@Test
	@Rollback
	@Transactional
	public void should_find_by_carrier_id() {
		// given
		jdbcDao.getJdbcTemplate().execute("delete from TT_ITSP_VEHICLE");
		jdbcDao.getJdbcTemplate()
				.execute("INSERT INTO TT_ITSP_VEHICLE(id,carrier_id,vehicle_number,TYPE,weight) "
						+ "VALUES(-2,888,'粤B123456',1,14)");
		//when
		List<Vehicle> vehicles = vehicleController.getVehicle(888);
		Vehicle vehicle = vehicles.get(0);
		//then
		Assert.assertEquals(1, vehicles.size());
		Assert.assertEquals(888, vehicle.getCarrierId());
		Assert.assertEquals("粤B123456", vehicle.getVehicleNumber());
		Assert.assertEquals("其他", vehicle.getType());
		Assert.assertEquals(14, vehicle.getWeight());
	}
}
