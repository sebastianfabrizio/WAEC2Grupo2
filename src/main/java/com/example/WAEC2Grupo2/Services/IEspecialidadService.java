package com.example.WAEC2Grupo2.Services;

import com.example.WAEC2Grupo2.Model.bd.Especialidad;

import java.util.List;

public interface IEspecialidadService {
    List<Especialidad> listaEspecialidad();
    void guardarEspecialidad(Especialidad especialidad);
    Especialidad buscarEspecialidad(int id);
}
