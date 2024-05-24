package com.example.WAEC2Grupo2.Model.bd;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Data
@Table(name="usuario")
public class Usuario {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Integer idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol", joinColumns = @JoinColumn(name="idusuario"),
    foreignKey = @ForeignKey(name="user_role_FK"), inverseJoinColumns = @JoinColumn(name = "idrol"), inverseForeignKey =
    @ForeignKey(name="user_role_FK_1"))
    private Set<Rol> roles;
}
