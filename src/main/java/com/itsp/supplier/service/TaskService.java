package com.itsp.supplier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.itsp.supplier.dao.TaskDao;
import com.itsp.supplier.entity.TaskData;

@Component
public class TaskService {
	@Autowired
	private TaskDao taskDao;
	
	public List<TaskData> getTasks() {
		return taskDao.getTask();
	}
}
