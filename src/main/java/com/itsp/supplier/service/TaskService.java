package com.itsp.supplier.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.TaskDao;
import com.itsp.supplier.entity.Task;
import com.itsp.supplier.entity.TaskDataSource;

@Component
public class TaskService {
	@Autowired
	private TaskDao taskDao;

	public List<Task> getTasks() {
		List<TaskDataSource> taskDataSources = taskDao.getTasks();
		List<Task> taskList = new ArrayList<Task>();
		for (TaskDataSource taskDataSource : taskDataSources) {
			Task task = createTask(taskDataSource);
			taskList.add(task);
		}
		return taskList;
	}

	private Task createTask(TaskDataSource taskDataSource) {
		Task task = new Task();
		task.setAddress(taskDataSource.getAddress());
		task.setOperation(taskDataSource.getOperationString());
		task.setArriveTime(taskDataSource.getArriveTimeString());
		task.setLatestDepartureTime(taskDataSource.getLatestDepartureTimeString());
		task.setWaitingTime(taskDataSource.getWaitingTime());
		return task;
	}
}
