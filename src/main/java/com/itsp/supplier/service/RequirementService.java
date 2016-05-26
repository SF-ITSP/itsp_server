package com.itsp.supplier.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.RequirementDao;
import com.itsp.supplier.entity.Requirement;

@Component
public class RequirementService {

	@Resource
	private RequirementDao requirementDao;

	public List<Requirement> getByCarrierId(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Requirement.class);
		criteria.add(Restrictions.eq("carrierId", carrierId));
		return requirementDao.findByCriteria(criteria);
	}

	public List<Requirement> getByCarrierIdAndStatus(long carrierId, int status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Requirement.class);
		criteria.add(Restrictions.eq("carrierId", carrierId)).add(Restrictions.eq("status", status));
		return requirementDao.findByCriteria(criteria);
	}

}
