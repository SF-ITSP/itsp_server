package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.TaskDataSource;

@Component
public class TaskDao extends BaseDao<TaskDataSource> {
	public List<TaskDataSource> getTasks() {
		DetachedCriteria dc = DetachedCriteria.forClass(TaskDataSource.class);
		return this.findByCriteria(dc);
	}
}
