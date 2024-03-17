package com.ibm.next.todoapp.service.taskService;

import com.ibm.next.todoapp.dto.TaskDTO;
import com.ibm.next.todoapp.entity.Task;
import com.ibm.next.todoapp.repository.TaskRepository;
import com.ibm.next.todoapp.utils.TaskUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }


    @Override
    public TaskDTO saveTask(TaskDTO taskDTO) {
        Task task = taskRepository.save(TaskUtils.convertDTOtoEntity(taskDTO));
        return TaskUtils.convertEntityToDTO(task);
    }

    @Override
    public TaskDTO getTaskByID(Long id) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        return optionalTask.map(TaskUtils::convertEntityToDTO).orElse(new TaskDTO());
    }

    @Override
    public List<TaskDTO> getAllTasks() {
        List<Task> taskList = taskRepository.findAll();
        return taskList.stream().map(TaskUtils::convertEntityToDTO).toList();
    }

    @Override
    public TaskDTO updateTask(Long id, TaskDTO taskDTO) {
        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = new Task();
            task.setId(taskDTO.getId());
            task.setTitle(taskDTO.getTitle());
            task.setDescription(taskDTO.getDescription());
            taskRepository.save(task);
            return taskDTO.toBuilder()
                    .updated(true)
                    .build();
        }

        return taskDTO;
    }

    @Override
    public boolean deleteById(Long id) {
        return taskRepository.findById(id).map(t -> {
            taskRepository.delete(t);
            return true;
        }).orElse(false);
    }
}
