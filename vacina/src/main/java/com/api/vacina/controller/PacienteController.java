package com.api.vacina.controller;

import com.api.vacina.entities.Paciente;
import com.api.vacina.service.PacienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService pacienteService;

    @PostMapping
    public ResponseEntity<Void> salvar(@RequestBody Paciente paciente){
        Paciente p = pacienteService.save(paciente);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> findAll(){

        return ResponseEntity.ok().body(pacienteService.findAll());
    }

    @GetMapping("/{name}")
    public ResponseEntity<Paciente> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(pacienteService.findByName(name.toLowerCase(Locale.ROOT)));
    }

}
