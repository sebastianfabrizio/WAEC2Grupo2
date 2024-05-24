package com.example.WAEC2Grupo2.Model.bd;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Data
@Table(name="Especialidad")
public class Especialidad {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer  idespecialidad;
    private String titulo;
    private String funcion;
    @DateTimeFormat(pattern = "dd-mm-yyyy")
    private String fechgraduacion;
    private Integer idmedico;

    @ManyToOne
    @JoinColumn(name = "idmedico", insertable = false, updatable = false)
    private Medico medico;

}
