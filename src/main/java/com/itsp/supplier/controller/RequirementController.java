package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.entity.RequirementData;
import com.itsp.supplier.service.RequirementService;


@Scope("prototype")
@RestController
@RequestMapping(value = "/requirement")
public class RequirementController {

	@Autowired
	private RequirementService requirementService;

	@RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
	public List<RequirementData> loadByCarrierId(@PathVariable(value = "carrierId") long carrierId) {
		return requirementService.getByCarrierId(carrierId);
	}

	@RequestMapping(value = "/{carrierId}/{status}", method = RequestMethod.GET)
	public List<Requirement> loadByCarrierIdAndStatus(@PathVariable(value = "carrierId") long carrierId, @PathVariable(value = "status") int status) {
		List<RequirementData> requirementList = requirementService.getByCarrierIdAndStatus(carrierId, status);
		List<Requirement> requirements = new ArrayList<Requirement>();

		for (RequirementData requirement : requirementList) {
			Requirement tempRequirement= new Requirement();
			tempRequirement.setStartDate(requirement.getStartDate());
			tempRequirement.setEndDate(requirement.getEndDate());
			tempRequirement.setCapacityWeight(requirement.getCapacityWeight());
			tempRequirement.setVehicleType(requirement.getVehicleTypeName());
			requirements.add(tempRequirement);
		}
		return requirements;
	}
}
