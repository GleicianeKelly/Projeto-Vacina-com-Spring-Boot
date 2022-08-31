package com.api.vacina.controller;
import com.api.vacina.entities.Atendimento;
import com.api.vacina.entities.AtendimentoRequest;
import com.api.vacina.service.AtendimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atendimento")
public class AtendimentoController {

    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    public ResponseEntity<List<Atendimento>> findAll(){
        List<Atendimento> obj = atendimentoService.findAll();
        return ResponseEntity.ok().body(obj);
    }

    @GetMapping(value = "/{nome}")
    public ResponseEntity<Atendimento> findByName(@PathVariable String nome){
        Atendimento obj = atendimentoService.findByName(nome);
        return ResponseEntity.ok().body(obj);
    }


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody AtendimentoRequest atendimentoRequest){
        atendimentoService.save(atendimentoRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

}
