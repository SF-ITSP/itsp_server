package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.service.RequirementService;


@Scope("prototype")
@Controller
@RequestMapping(value = "/requirement")
public class RequirementController {

	@Autowired
	private RequirementService requirementService;

	@RequestMapping(value = "/{carrierId}/{status}", method = RequestMethod.GET)
	public List<Requirement> loadByCarrierIdAndStatus(@PathVariable(value = "carrierId") long carrierId, @PathVariable(value = "status") int status) {
		return requirementService.getByCarrierIdAndStatus(carrierId, status);
	}
}
