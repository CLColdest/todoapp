package com.coldie.todoapp.persistence.repository;

import com.coldie.todoapp.persistence.entity.Task;
import com.coldie.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface TaskRepository extends JpaRepository <Task, Long>{ //repositorio de acceso a datos

    public List<Task>  findAllByTaskStatus(TaskStatus status);

    @Modifying//query de actualizacion
    @Query(value = "UPDATE TASK SET FINISHED=true WHERE ID =:id",nativeQuery = true) //anotacion para usar querys en spring, pueden ser querys nativas
    public void markTaskAsFinished(@Param("id") Long id);
}
