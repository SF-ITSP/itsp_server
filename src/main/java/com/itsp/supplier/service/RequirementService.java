package com.itsp.supplier.service;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.RequirementDao;
import com.itsp.supplier.entity.RequirementData;

@Component
public class RequirementService {

	@Autowired
	private RequirementDao requirementDao;

	public List<RequirementData> getByCarrierId(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RequirementData.class);
		criteria.add(Restrictions.eq("carrierId", carrierId));
		return requirementDao.findByCriteria(criteria);
	}

	public List<RequirementData> getByCarrierIdAndStatus(long carrierId, int status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RequirementData.class);
		criteria.add(Restrictions.eq("carrierId", carrierId)).add(Restrictions.eq("status", status));
		return requirementDao.findByCriteria(criteria);
	}

}
