package com.example.WAEC2Grupo2.Repository;

import com.example.WAEC2Grupo2.Model.bd.Especialidad;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspecialidadRepository extends JpaRepository<Especialidad, Integer> {

}
