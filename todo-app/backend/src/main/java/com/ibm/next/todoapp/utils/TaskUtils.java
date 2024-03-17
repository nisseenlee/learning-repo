package com.ibm.next.todoapp.utils;

import com.ibm.next.todoapp.dto.TaskDTO;
import com.ibm.next.todoapp.entity.Task;

public class TaskUtils {
    public static TaskDTO convertEntityToDTO(Task task) {
        return TaskDTO.builder()
                .id(task.getId())
                .title(task.getTitle())
                .description(task.getDescription())
                .build();
    }

    public static Task convertDTOtoEntity(TaskDTO taskDTO) {
        Task task = new Task();
        task.setId(taskDTO.getId());
        task.setTitle(taskDTO.getTitle());
        task.setDescription(taskDTO.getDescription());
        return task;
    }
}
