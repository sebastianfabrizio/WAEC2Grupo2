package com.example.WAEC2Grupo2.Model.bd;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

@Entity
@Data
@Table(name="Medico")
public class Medico {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idmedico;
    private String nommedico;
    private String apemedico;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate fechnacmedico;

    @JsonIgnore
    @OneToMany(mappedBy = "medico")
    private List<Especialidad> especialidadList;


}
