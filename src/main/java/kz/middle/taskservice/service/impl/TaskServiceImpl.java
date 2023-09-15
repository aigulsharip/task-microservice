package kz.middle.taskservice.service.impl;

import kz.middle.taskservice.dto.TaskDto;
import kz.middle.taskservice.dto.UserDto;
import kz.middle.taskservice.exception.UserNotFoundException;
import kz.middle.taskservice.feign.UserFeignClient;
import kz.middle.taskservice.mapper.TaskMapper;
import kz.middle.taskservice.model.Task;
import kz.middle.taskservice.repository.TaskRepository;
import kz.middle.taskservice.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    private final UserFeignClient userFeignClient;

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
        UserDto userDto = userFeignClient.getUser(task.getAuthorId());
        if (userDto != null) {
            task.setDateCreated(LocalDateTime.now());
            task.setStatus("Newx");
            return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(task)));
        }
        throw new UserNotFoundException(task.getAuthorId());
    }

    @Override
    public TaskDto updateTask(TaskDto task) {
        UserDto userDto = userFeignClient.getUser(task.getAuthorId());
        if (userDto != null) {
            return taskMapper.toDto(taskRepository.save(taskMapper.toEntity(task)));
       }
        throw new UserNotFoundException(task.getAuthorId());
    }

    @Override
    public void deleteTask(Long id) {
        Task deleteTask = taskRepository.findById(id).orElse(null);
        assert deleteTask != null;
        taskRepository.delete(deleteTask);
    }
}
