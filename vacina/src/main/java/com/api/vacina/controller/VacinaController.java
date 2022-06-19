package com.api.vacina.controller;

import com.api.vacina.entities.Vacina;
import com.api.vacina.service.VacinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;


@RestController
@RequestMapping(value = "/vacina")
public class VacinaController {

    @Autowired
    private VacinaService vacinaService;


    @PostMapping
    public ResponseEntity<Void> save(@RequestBody Vacina vacina){
        Vacina v = vacinaService.save(vacina);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<Vacina>> findAll(){
        return ResponseEntity.ok().body(vacinaService.findAll());
    }

    @GetMapping(value = "/{name}")
    public ResponseEntity<Vacina> findByName(@PathVariable String name){
        return ResponseEntity.ok().body(vacinaService.findByName(name.toLowerCase(Locale.ROOT)));
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Vacina> delete(@PathVariable Long id, @RequestBody Vacina vacina) {
        Vacina vacinaDeletada = vacinaService.deleteById(vacina);
        return ResponseEntity.ok().body(vacinaDeletada);
    }


    @PutMapping(value = "/{id}")
    public ResponseEntity<Vacina> update(@PathVariable Long id, @RequestBody Vacina vacina){
         Vacina vacinaEditada = vacinaService.update(id, vacina);
         return ResponseEntity.ok().body(vacinaEditada);
    }
}
