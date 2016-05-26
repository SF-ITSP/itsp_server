package com.itsp.supplier.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.service.RequirementService;

@Scope("prototype")
@RestController
@RequestMapping(value = "/requirement")
public class RequirementController {

	@Resource
	private RequirementService requirementService;

	@RequestMapping(value = "/{carrierId}", method = RequestMethod.GET)
	public List<Requirement> loadByCarrierId(@PathVariable(value = "carrierId") long carrierId) {
		return requirementService.getByCarrierId(carrierId);
	}

	@RequestMapping(value = "/{carrierId}/{status}", method = RequestMethod.GET)
	public List<Requirement> loadByCarrierIdAndStatus(@PathVariable(value = "carrierId") long carrierId, @PathVariable(value = "status") int status) {
		return requirementService.getByCarrierIdAndStatus(carrierId, status);
	}

}
