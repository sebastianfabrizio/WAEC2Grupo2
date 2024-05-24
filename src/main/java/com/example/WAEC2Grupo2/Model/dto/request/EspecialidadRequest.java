package com.example.WAEC2Grupo2.Model.dto.request;

import lombok.Data;

import java.time.LocalDate;

@Data
public class EspecialidadRequest {
    private Integer idespecialidad;
    private String titulo;
    private String funcion;
    private LocalDate fechgraduacion;
    private Integer idmedico;
}
