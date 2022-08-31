package com.api.vacina.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Entity
@Table(name = "tb_atendimento")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Atendimento implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id_atendime;

    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    @OneToMany
    private List<Vacina> vacina = new ArrayList<>();

    private Date dt_atendimento;





}
