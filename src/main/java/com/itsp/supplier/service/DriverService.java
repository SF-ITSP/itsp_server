package com.itsp.supplier.service;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.DriverDao;
import com.itsp.supplier.entity.DriverDataSource;

@Component
public class DriverService {

	@Resource
	private DriverDao driverDao;

	public List<DriverDataSource> getByCarrierId(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(DriverDataSource.class);
		criteria.add(Restrictions.eq("carrierId", carrierId));
		return driverDao.findByCriteria(criteria);
	}
}
