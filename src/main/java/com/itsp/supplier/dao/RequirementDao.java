package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.common.util.Constants;
import com.itsp.supplier.entity.RequirementData;

@Component
public class RequirementDao extends BaseDao<RequirementData> {

	public List<RequirementData> getByCarrierIdAndStatus(long carrierId, int status) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RequirementData.class);
		criteria.add(Restrictions.eq(Constants.CARRIER_ID, carrierId)).add(Restrictions.eq(Constants.STATUS, status));
		return findByCriteria(criteria);
	}
	
	public List<RequirementData> getByCarrierId(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(RequirementData.class);
		criteria.add(Restrictions.eq(Constants.CARRIER_ID, carrierId));
		return findByCriteria(criteria);
	}
}
