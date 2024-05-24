package com.example.WAEC2Grupo2.Services;

import com.example.WAEC2Grupo2.Model.bd.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioxNomUsuario(String nomusuario);
    Usuario guardarUsuario (Usuario usuario, String nombreRol);
    void actualizarUsuario(String password, String nomusuario);
}
