package com.api.vacina.repositories;

import com.api.vacina.entities.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PacienteRepository extends JpaRepository<Paciente, Long> {


    Optional<Paciente> findByNomePaciente(String name);
    Optional<Paciente> findByCpf(String cpf);
    Optional<Paciente> findById(Long id);
    boolean existsByCpf(String cpf);
}
