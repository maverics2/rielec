package com.example.rielec.service;

import com.example.rielec.domain.Task;
import com.example.rielec.domain.TaskState;
import com.example.rielec.repository.TaskRepository;
import com.example.rielec.cron.TaskCron;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {

	@Autowired
	public TaskRepository taskRepository;

	public Task createTask(String name) {
		Task task = new Task();
		task.setName(name);
		task.setState(TaskState.CREATED);
		return taskRepository.save(task);
	}

	public List<Task> listAllTasks() {
		return taskRepository.findAll();
	}

	public Task updateTaskState(String name, TaskState newState) {
		Task task = taskRepository.findByName(name);

		task.setState(newState);
		return taskRepository.save(task);
	}

	public void deleteTask(String name) {
		taskRepository.deleteById(name);
	}

    public void cronMethod(String name) {
    	TaskCron cron = new TaskCron();
    	cron.createTaskAndChangeStateRunning(name);
    }
}
