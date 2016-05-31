package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.common.util.Constants;
import com.itsp.supplier.entity.DriverDataSource;

@Component
public class DriverDao extends BaseDao<DriverDataSource> {
	
	public List<DriverDataSource> getByCarrierId(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DriverDataSource.class);
		criteria.add(Restrictions.eq(Constants.CARRIER_ID, carrierId));
		return findByCriteria(criteria);
	}
}
