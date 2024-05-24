package com.example.WAEC2Grupo2.Services;

import com.example.WAEC2Grupo2.Model.bd.Especialidad;
import com.example.WAEC2Grupo2.Repository.EspecialidadRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EspecialidadService implements IEspecialidadService{

    private EspecialidadRepository especialidadRepository;

    @Override
    public List<Especialidad> listaEspecialidad() {
        return especialidadRepository.findAll();
    }

    @Override
    public void guardarEspecialidad(Especialidad especialidad) {
        especialidadRepository.save(especialidad);
    }

    @Override
    public Especialidad buscarEspecialidad(int id) {
        return especialidadRepository.findById(id).orElse(null);
    }
}
