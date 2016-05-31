package driver.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.dao.JdbcDao;
import com.itsp.supplier.controller.DriverController;
import com.itsp.supplier.entity.Driver;

public class DriverControllerTest extends ItspJUnit4ClassRunner {
	@Autowired
	private DriverController driverController;

	@Autowired
	private JdbcDao jdbcDao;

	@Test
	@Rollback
	@Transactional
	public void should_be_found_by_carrier_id() {
		// give
		jdbcDao.getJdbcTemplate().execute("delete from TT_DRIVER  where carrier_id =888");
		jdbcDao.getJdbcTemplate().execute(
				"INSERT INTO TT_DRIVER(id,carrier_id,driving_license_Type,DATE_BIRTH,first_drive_date,age,name,code)"
						+ "values(-2,888,'C1',date'2016-01-01',date'2016-01-01',30,'王五','330356')");
		// when
		List<Driver> drivers = driverController.findByCarrierId(888);
		// then
		Driver driver = drivers.get(0);
		Assert.assertEquals(1, drivers.size());
		Assert.assertEquals(888, driver.getCarrierId());
		Assert.assertEquals("C1", driver.getDrivingLicenseType());
		Assert.assertEquals(0, driver.getDrivingExperience());
		Assert.assertEquals(30, driver.getAge());
		Assert.assertEquals("王五", driver.getName());
	}

	@Test
	@Rollback
	@Transactional
	public void should_be_found_by_driver_id() {
		// give
		jdbcDao.getJdbcTemplate().execute("delete from TT_DRIVER  where id =-2");
		jdbcDao.getJdbcTemplate().execute(
				"INSERT INTO TT_DRIVER(id,carrier_id,driving_license_Type,DATE_BIRTH,first_drive_date,age,name,code)"
						+ "values(-2,888,'C1',date'2016-01-01',date'2016-01-01',30,'王五','330356')");
		// when
		Driver driver = driverController.findByDriverId(-2);
		Assert.assertNotNull(driver);
		Assert.assertEquals(888, driver.getCarrierId());
		Assert.assertEquals("C1", driver.getDrivingLicenseType());
		Assert.assertEquals(0, driver.getDrivingExperience());
		Assert.assertEquals(30, driver.getAge());
		Assert.assertEquals("王五", driver.getName());

	}

}
