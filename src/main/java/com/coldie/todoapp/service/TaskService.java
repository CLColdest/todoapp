package com.coldie.todoapp.service;

import com.coldie.todoapp.mapper.TaskInDTOToTask;
import com.coldie.todoapp.persistence.entity.Task;
import com.coldie.todoapp.persistence.entity.TaskStatus;
import com.coldie.todoapp.persistence.repository.TaskRepository;
import com.coldie.todoapp.service.dto.TaskInDTO;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TaskService { //implementar lógica de negocio y funcionalidades

    private final TaskRepository repository;
    private final TaskInDTOToTask mapper;

    public TaskService(TaskRepository repository, TaskInDTOToTask mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    public Task createTask(TaskInDTO taskInDTO) {
        Task task = mapper.map(taskInDTO);
        return this.repository.save(task);

    }

    public List<Task> findAll() {
        return this.repository.findAll();
    }

    public List<Task> findAllByTaskStatus(TaskStatus status) {
        return this.repository.findAllByTaskStatus(status);
    }

    @Transactional
    public void updateTaskAsFinished(Long id){
        this.repository.markTaskAsFinished(id);
    }
}
