package com.itsp.supplier.controller;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.StatementCallback;

import com.itsp.common.ItspJUnit4ClassRunner;
import com.itsp.common.dao.JdbcDao;
import com.itsp.supplier.entity.Requirement;

import junit.framework.Assert;

public class RequirementTest extends ItspJUnit4ClassRunner {

	@Resource
	private JdbcDao jdbcDao;

	@Resource
	private RequirementController requirementController;

	@Test
	public void should_load_all_requirement() {
		String sql = "select count(*) from db_dev.TT_ITSP_REQUIREMENT";
		Integer selectCount = jdbcDao.getJdbcTemplate().execute(new StatementCallback<Integer>() {

			@Override
			public Integer doInStatement(Statement statement) throws SQLException, DataAccessException {
				ResultSet resultSet = statement.executeQuery(sql);
				resultSet.next();
				return resultSet.getInt(1);
			}
		});

		List<Requirement> requirements = requirementController.getRequirements();
		
		Assert.assertEquals(selectCount.intValue(), requirements.size());
	}

}
