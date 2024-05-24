package com.example.WAEC2Grupo2.Repository;

import com.example.WAEC2Grupo2.Model.bd.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRepository extends JpaRepository<Medico, Integer> {

}
