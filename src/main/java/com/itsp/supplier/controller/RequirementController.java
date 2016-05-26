package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.entity.RequirementData;
import com.itsp.supplier.service.RequirementService;

@Controller
@RestController
public class RequirementController {

	@Resource
	private RequirementService requirementService;

	@RequestMapping(value = "/requirement")
	public List<Requirement> getRequirements() {
		List<RequirementData> requirementList = requirementService.getRequirements();
		List<Requirement> requirements = new ArrayList<Requirement>();

		for (RequirementData requirement : requirementList) {
			Requirement tempRequirement= new Requirement();
			tempRequirement.setStartDate(requirement.getStartDate());
			tempRequirement.setEndDate(requirement.getEndDate());
			tempRequirement.setCapacityWeight(requirement.getCapacityWeight());
			tempRequirement.setVehicleModel(requirement.getVehicleModelName());
			requirements.add(tempRequirement);
		}
		return requirements;
	}
}
