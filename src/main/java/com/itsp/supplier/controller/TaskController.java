package com.itsp.supplier.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.itsp.supplier.entity.Task;
import com.itsp.supplier.entity.TaskForShow;
import com.itsp.supplier.service.TaskService;

@Component
@RequestMapping("/task")
public class TaskController {
	@Autowired
	private TaskService taskService;
	
	@RequestMapping(value = "/{id}")
	public List<TaskForShow> getTasks(@PathVariable("id") int id) {
		List<Task> tasks = taskService.getTasks(id);
		List<TaskForShow> taskList = new ArrayList<TaskForShow>();
		
		for(int i = 0; i < tasks.size(); i++) {
			TaskForShow task = new TaskForShow();
			task.setAddress(tasks.get(i).getAddress());
			task.setOperationString(tasks.get(i).getOperationString());
			task.setArriveTimeString(tasks.get(i).getArriveTimeString());
			task.setLatestDepartureTimeString(tasks.get(i).getLatestDepartureTimeString());
			task.setWaitingTime(tasks.get(i).getWaitingTime());
			
			taskList.add(task);
		}
		
		return taskList;
	}
}
