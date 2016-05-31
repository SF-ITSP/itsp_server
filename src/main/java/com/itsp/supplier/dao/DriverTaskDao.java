package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.DriverTask;

@Component
public class DriverTaskDao extends BaseDao<DriverTask> {
	public List<DriverTask> getTasks() {
		DetachedCriteria criteria = DetachedCriteria.forClass(DriverTask.class);
		return findByCriteria(criteria);
	}
}
