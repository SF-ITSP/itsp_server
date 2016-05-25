package com.itsp.supplier.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itsp.supplier.entity.Requirement;
import com.itsp.supplier.service.RequirementService;

@Controller
@Scope("prototype")
@RestController
@RequestMapping(value="/requirement")
public class RequirementController {

	@Resource
	private RequirementService requirementService;

	@RequestMapping(value = "/", method = RequestMethod.GET, produces = "application/json")
	public List<Requirement> getRequirements() {
		return requirementService.getRequirements();
	}

}
