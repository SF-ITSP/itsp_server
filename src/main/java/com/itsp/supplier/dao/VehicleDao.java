package com.itsp.supplier.dao;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.stereotype.Component;

import com.itsp.common.dao.BaseDao;
import com.itsp.supplier.entity.VehicleData;

@Component
public class VehicleDao extends BaseDao<VehicleData> {
	public List<VehicleData> getVehicle() {
		DetachedCriteria dc = DetachedCriteria.forClass(VehicleData.class);
		return this.findByCriteria(dc);
	}
}
