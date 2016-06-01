package com.itsp.supplier.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.RequirementDao;
import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.entity.RequirementData;

@Component
public class RequirementService {

	@Autowired
	private RequirementDao requirementDao;

	public List<RequirementData> getByCarrierId(long carrierId) {
		return requirementDao.getByCarrierId(carrierId);
	}

	public List<Requirement> getByCarrierIdAndStatus(long carrierId, int status) {
		List<RequirementData> requirementList = requirementDao.getByCarrierIdAndStatus(carrierId, status);
		
		return requirementList.stream().map(requirement -> createRequirement(requirement)).collect(Collectors.toList());	
	}

	private Requirement createRequirement(RequirementData requirement) {
		Requirement tempRequirement= new Requirement();
		
		tempRequirement.setStartDate(requirement.getStartDate());
		tempRequirement.setEndDate(requirement.getEndDate());
		tempRequirement.setCapacityWeight(requirement.getCapacityWeight());
		tempRequirement.setVehicleType(requirement.getVehicleTypeName());
		
		return tempRequirement;
	}
}
