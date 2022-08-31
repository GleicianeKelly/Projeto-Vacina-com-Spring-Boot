package com.api.vacina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "tb_vacina")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Vacina implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vacina;
    @Column(name = "nome_vacina", nullable = false)
    private String nomeVacina;
    @Column(nullable = false)
    private String marca;






}
