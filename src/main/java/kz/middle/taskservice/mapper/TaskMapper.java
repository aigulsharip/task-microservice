package kz.middle.taskservice.mapper;

import kz.middle.taskservice.dto.TaskDto;
import kz.middle.taskservice.model.Task;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper (componentModel = "spring")

public interface TaskMapper {
    TaskDto toDto (Task task);
    Task toEntity (TaskDto taskDto);

    List<TaskDto> toDtoList (List<Task> tasks);
}
