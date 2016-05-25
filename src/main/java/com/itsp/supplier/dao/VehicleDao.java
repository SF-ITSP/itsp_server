package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.Vehicle;

@Component
public class VehicleDao extends BaseDao<Vehicle> {
	public List<Vehicle> getVehicles() {
		DetachedCriteria dc = DetachedCriteria.forClass(Vehicle.class);
//		dc.add(Restrictions.eq("id", id));
		return this.findByCriteria(dc);
	}
}
