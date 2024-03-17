package com.ibm.next.todoapp.service.taskService;

import com.ibm.next.todoapp.dto.TaskDTO;

import java.util.List;

public interface TaskService {

    TaskDTO saveTask(TaskDTO taskDTO);
    TaskDTO getTaskByID(Long id);
    List<TaskDTO> getAllTasks();
    TaskDTO updateTask(Long id, TaskDTO taskDTO);
    boolean deleteById(Long id);
}
