package com.example.WAEC2Grupo2.Services;

import com.example.WAEC2Grupo2.Model.bd.Medico;
import com.example.WAEC2Grupo2.Repository.MedicoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class MedicoService implements IMedicoService{

    private MedicoRepository medicoRepository;

    @Override
    public List<Medico> listadoMedicos() {
        return medicoRepository.findAll();
    }

    @Override
    public void guardarMedico(Medico medico) {
        medicoRepository.save(medico);
    }

    @Override
    public Medico buscarMedico(int id) {
        return medicoRepository.findById(id).orElse(null);
    }
}
