package com.example.rielec.controller;

import com.example.rielec.domain.Task;
import com.example.rielec.domain.TaskState;
import com.example.rielec.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    @PostMapping
    public Task createTask(@RequestBody String name) {
        return taskService.createTask(name);
    }

    @GetMapping
    public List<Task> listTasks() {
        return taskService.listAllTasks();
    }

    @PutMapping("/{name}/state")
    public Task updateTaskState(@PathVariable String name, @RequestBody TaskState newState) {
        return taskService.updateTaskState(name, newState);
    }
    
    @PutMapping("/{name}/cron")
    public Task cronTaskState(@PathVariable String name) {
    	return taskService.createTask(name);
    }

    @DeleteMapping("/{name}")
    public void deleteTask(@PathVariable String name) {
        taskService.deleteTask(name);
    }
}
