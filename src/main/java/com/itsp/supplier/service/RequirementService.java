package com.itsp.supplier.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.RequirementDao;
import com.itsp.supplier.entity.RequirementData;

@Component
public class RequirementService {

	@Resource
	private RequirementDao requirementDao;

	public List<RequirementData> getRequirements() {
		return requirementDao.getRequirements();
	}

}
