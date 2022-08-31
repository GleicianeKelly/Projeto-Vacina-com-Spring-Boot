package com.api.vacina.repositories;

import com.api.vacina.entities.Vacina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VacinaRepository extends JpaRepository<Vacina, Long> {


    Optional<Vacina> findByNomeVacina(String name);
    Optional<Vacina> findById(Long id);
    boolean existsByMarca(String marca);

}
