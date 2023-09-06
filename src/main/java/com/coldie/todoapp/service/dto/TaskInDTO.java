package com.coldie.todoapp.service.dto;

import lombok.Data;

import java.time.LocalDateTime;
@Data //habilitar getter y setter de la aplicacion con lombok
public class TaskInDTO {
    private String title;
    private String description;
    private LocalDateTime eta;
}
