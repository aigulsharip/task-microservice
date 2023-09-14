package kz.middle.taskservice.service;

import kz.middle.taskservice.dto.TaskDto;
import org.springframework.stereotype.Service;

import java.util.List;


public interface TaskService {
    List<TaskDto> getTasks();
    TaskDto getTask(Long id);
    TaskDto addTask(TaskDto task);
    TaskDto updateTask(TaskDto task);
    void deleteTask(Long id);
}
