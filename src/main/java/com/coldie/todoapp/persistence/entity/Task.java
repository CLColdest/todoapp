package com.coldie.todoapp.persistence.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data //obtener getter y setter
@Entity //Entidad de base de datos a la clase
@Table(name="task")
public class Task {
    @Id //llave primaria en bdd, identificador
    @GeneratedValue(strategy = GenerationType.AUTO) //permite generar automaticamente valores para un atributo
    private Long id;
    private String title;
    private String description;
    private LocalDateTime createdDate;
    private LocalDateTime eta;
    private boolean finished;
    private TaskStatus taskStatus;
}
