package com.example.WAEC2Grupo2.Model.bd;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name="rol")
public class Rol {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idrol;
    private String nomrol;
}
