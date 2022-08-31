package com.api.vacina.repositories;

import com.api.vacina.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query("select u from Atendimento u WHERE u.paciente.id_paciente = :id")
    Optional<Atendimento> findByPaciente(@Param("id") Long id);

}
