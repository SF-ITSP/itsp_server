package com.itsp.supplier.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Task;
import com.itsp.supplier.service.TaskService;

@Component
@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@RequestMapping("/tasks")
	public List<Task> getTasks() {
		return taskService.getTasks();
	}
}
