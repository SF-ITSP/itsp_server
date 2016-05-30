package com.itsp.supplier.controller;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.dao.JdbcDao;
import com.itsp.supplier.entity.Task;

public class TaskControllerTest extends ItspJUnit4ClassRunner {
	@Autowired
	private TaskController taskController;
	@Autowired
	private JdbcDao jdbcDao;

	@Test
	@Rollback
	@Transactional
	public void should_find_all() {

		// give
		jdbcDao.getJdbcTemplate().execute("delete from TT_ITSP_TASK");
		jdbcDao.getJdbcTemplate()
				.execute("insert into TT_ITSP_TASK(id,address,operation,arrive_time,latest_departure_time,waiting_time)"
						+ "values (-1,'广州中转场','1',timestamp'2016-01-01 12:13',timestamp'2016-01-01 09:56',20)");
		//when
		List<Task> tasks = taskController.getTasks();
		Task task = tasks.get(0);
		//then
		Assert.assertEquals(1, tasks.size());
		Assert.assertEquals("广州中转场", task.getAddress());
		Assert.assertEquals("卸车", task.getOperation());
		Assert.assertEquals("12:13", task.getArriveTime());
		Assert.assertEquals("09:56", task.getLatestDepartureTime());
		Assert.assertEquals(20, task.getWaitingTime());

	}

}
