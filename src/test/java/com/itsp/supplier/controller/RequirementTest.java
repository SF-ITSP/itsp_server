package com.itsp.supplier.controller;

import java.text.SimpleDateFormat;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.dao.JdbcDao;
import com.itsp.supplier.entity.Requirement;

public class RequirementTest extends ItspJUnit4ClassRunner {

	@Resource
	private JdbcDao jdbcDao;
	@Resource
	private RequirementController requirementController;

	@Test
	@Rollback
	@Transactional
	public void should_load_by_carrier_Id_And_Status() {
		// given
		jdbcDao.getJdbcTemplate().execute("delete from TT_ITSP_REQUIREMENT");
		jdbcDao.getJdbcTemplate()
				.execute("INSERT INTO TT_ITSP_REQUIREMENT(id,start_date,vehicle_type,capacity_weight,end_date,carrier_id, STATUS) "
						+ "VALUES (-1, TIMESTAMP'2013-01-01 10:12',1, 14, TIMESTAMP'2016-01-01 12:12',888,1)");
		//when
		List<Requirement> requirements = requirementController.loadByCarrierIdAndStatus(888, 1);
		Requirement requirement = requirements.get(0);
		//then
		Assert.assertEquals(1, requirements.size());
		Assert.assertEquals(14, requirement.getCapacityWeight());
		Assert.assertEquals("其他", requirement.getVehicleType());
		Assert.assertEquals("2013-01-01", new SimpleDateFormat("yyyy-MM-dd").format(requirement.getStartDate()));
		Assert.assertEquals("2016-01-01", new SimpleDateFormat("yyyy-MM-dd").format(requirement.getEndDate()));
	}
}
