package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.TaskData;

@Component
public class TaskDao extends BaseDao<TaskData> {
	public List<TaskData> getTask() {
		DetachedCriteria dc = DetachedCriteria.forClass(TaskData.class);
//		dc.add(Restrictions.eq("id", id));
		return this.findByCriteria(dc);
	}
}
