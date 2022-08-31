package com.api.vacina.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;
import java.util.Date;
import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class AtendimentoRequest implements Serializable {
    private static final long serialVersionUID = 1L;
    private String nomePaciente;
    private List<String> nomeVacina;


}
