package com.coldie.todoapp.controller;

import com.coldie.todoapp.persistence.entity.Task;
import com.coldie.todoapp.persistence.entity.TaskStatus;
import com.coldie.todoapp.service.TaskService;
import com.coldie.todoapp.service.dto.TaskInDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("/tasks")//permite definir el camino del controlador, por ejemplo ahora gestiona tareas siempre en plural
public class TaskController { //capa controladora solo debería comunicarse con la capa de servicio

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping//anotacion que permite crear elementos
    public Task createTask(@RequestBody TaskInDTO taskInDTO){
        return this.taskService.createTask(taskInDTO);
    }

    @GetMapping
    public List<Task> findAll(){
        return this.taskService.findAll();
    }

    @GetMapping("/status/{status}")
    public List<Task> findAllbyStatus(@PathVariable("status")TaskStatus status){ //forzar a que el usuario envie un valor taskstatus
        return this.taskService.findAllByTaskStatus(status);
    }

    @PatchMapping("/mark_as_finished/{id}")
    public ResponseEntity<Void> markAsFinished(@PathVariable("id")Long id){
        this.taskService.updateTaskAsFinished(id);
        return ResponseEntity.noContent().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable("id")Long id){
        this.taskService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
