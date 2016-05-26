package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Task;
import com.itsp.supplier.entity.TaskDataSource;
import com.itsp.supplier.service.TaskService;

@Component
@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@RequestMapping("/tasks")
	public List<Task> getTasks() {
		List<TaskDataSource> taskDataSources = taskService.getTasks();
		List<Task> taskList = new ArrayList<Task>();

		for (TaskDataSource taskDataSource : taskDataSources) {
			Task task = new Task();
			task.setAddress(taskDataSource.getAddress());
			task.setOperation(taskDataSource.getOperationString());
			task.setArriveTime(taskDataSource.getArriveTimeString());
			task.setLatestDepartureTime(taskDataSource.getLatestDepartureTimeString());
			task.setWaitingTime(taskDataSource.getWaitingTime());

			taskList.add(task);
		}

		return taskList;
	}
}
