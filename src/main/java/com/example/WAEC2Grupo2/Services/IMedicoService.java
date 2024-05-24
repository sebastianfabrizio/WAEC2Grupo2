package com.example.WAEC2Grupo2.Services;

import com.example.WAEC2Grupo2.Model.bd.Medico;

import java.util.List;

public interface IMedicoService {
    List<Medico> listadoMedicos();
    void guardarMedico(Medico medico);
    Medico buscarMedico(int id);
}
