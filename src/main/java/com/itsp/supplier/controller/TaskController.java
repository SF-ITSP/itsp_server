package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Task;
import com.itsp.supplier.entity.TaskData;
import com.itsp.supplier.service.TaskService;

@Component
@Controller
public class TaskController {
	@Autowired
	private TaskService taskService;

	@RequestMapping("/tasks")
	public List<Task> getTasks() {
		List<TaskData> tasks = taskService.getTasks();
		List<Task> taskList = new ArrayList<Task>();

		for (int i = 0; i < tasks.size(); i++) {
			Task task = new Task();
			task.setAddress(tasks.get(i).getAddress());
			task.setOperation(tasks.get(i).getOperationString());
			task.setArriveTime(tasks.get(i).getArriveTimeString());
			task.setLatestDepartureTime(tasks.get(i).getLatestDepartureTimeString());
			task.setWaitingTime(tasks.get(i).getWaitingTime());

			taskList.add(task);
		}

		return taskList;
	}
}
