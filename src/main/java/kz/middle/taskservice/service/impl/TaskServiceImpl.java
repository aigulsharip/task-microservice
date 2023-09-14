package kz.middle.taskservice.service.impl;

import kz.middle.taskservice.dto.TaskDto;
import kz.middle.taskservice.mapper.TaskMapper;
import kz.middle.taskservice.model.Task;
import kz.middle.taskservice.repository.TaskRepository;
import kz.middle.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    public List<TaskDto> getTasks() {
        return taskMapper.toDtoList(taskRepository.findAll());
    }

    @Override
    public TaskDto getTask(Long id) {
        return taskMapper.toDto(taskRepository.findById(id).orElse(null));
    }

    @Override
    public TaskDto addTask(TaskDto task) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(task)));
    }

    @Override
    public TaskDto updateTask(TaskDto task) {
        return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(task)));
    }

    @Override
    public void deleteTask(Long id) {
        Task deleteTask = taskRepository.findById(id).orElse(null);
        assert deleteTask != null;
        taskRepository.delete(deleteTask);
    }
}
