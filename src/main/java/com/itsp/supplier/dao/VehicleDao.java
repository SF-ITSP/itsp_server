package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.common.util.Constants;
import com.itsp.supplier.entity.VehicleData;

@Component
public class VehicleDao extends BaseDao<VehicleData> {
	
	public List<VehicleData> getVehicle(long carrierId) {
		DetachedCriteria criteria = DetachedCriteria.forClass(VehicleData.class);
		criteria.add(Restrictions.eq(Constants.CARRIER_ID, carrierId));
		return this.findByCriteria(criteria);
	}
}
