package com.example.WAEC2Grupo2.Repository;

import com.example.WAEC2Grupo2.Model.bd.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET password=:password WHERE nomusuario=:nomusuario", nativeQuery = true)
    void updateUser(@Param("password") String password,
                    @Param("nomusuario") String nomusuario);
}
