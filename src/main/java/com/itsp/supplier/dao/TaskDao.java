package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.Task;

@Component
public class TaskDao extends BaseDao<Task> {
	public List<Task> getTask(int id) {
		DetachedCriteria dc = DetachedCriteria.forClass(Task.class);
		dc.add(Restrictions.eq("id", id));
		return this.findByCriteria(dc);
	}
}
