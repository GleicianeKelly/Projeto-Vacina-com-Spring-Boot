package com.api.vacina.entities.Exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class StandardErrorResponse implements Serializable {


    private LocalDateTime timeStamp;
    private Integer status;
    private String mensagem;
    private String path;


}
