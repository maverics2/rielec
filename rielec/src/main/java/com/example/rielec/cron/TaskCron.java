package com.example.rielec.cron;

import com.example.rielec.domain.TaskState;
import com.example.rielec.service.TaskService;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class TaskCron {
    @Autowired
    private TaskService taskService;
    
    public static Logger log;

    @Scheduled(fixedDelay = 120000) // 2 minutos en milisegundos
    public void changeTaskStateToRunning(String name) {
    	taskService.updateTaskState(name, TaskState.RUNNING);
    	log.info("Ejecutamos el cambio de estado a RUNNING");
    }

    @Scheduled(fixedDelay = 480000) // 8 minutos en milisegundos
    public void changeTaskStateToDone(String name) {
        taskService.updateTaskState(name, TaskState.DONE);
        log.info("Ejecutamos el cambio de estado a DONE");
    }
    
    public void createTaskAndChangeStateRunning(String name) {
    	taskService.createTask(name);
    	changeTaskStateToRunning(name);
    	changeTaskStateToDone(name);
    }

}
