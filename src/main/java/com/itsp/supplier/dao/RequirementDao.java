package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.RequirementData;

@Component
public class RequirementDao extends BaseDao<RequirementData> {

	public List<RequirementData> getRequirements() {
		DetachedCriteria dc = DetachedCriteria.forClass(RequirementData.class);
		return this.findByCriteria(dc);
	}
}
