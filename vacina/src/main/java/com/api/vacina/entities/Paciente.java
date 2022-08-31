package com.api.vacina.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "tb_paciente")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Paciente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_paciente;

    @Column(unique=true)
    private String cpf;
    @Column(nullable = false)
    private String nomePaciente;
    @Column(nullable = false)
    private String endereco;


    @OneToMany(mappedBy = "paciente")
    private List<Atendimento> atendimento = new ArrayList<>();


}
