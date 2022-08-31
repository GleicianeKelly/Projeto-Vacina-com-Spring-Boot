package com.api.vacina.service;

import com.api.vacina.entities.Exception.ObjectConflictException;
import com.api.vacina.entities.Exception.ObjectInternalErrorException;
import com.api.vacina.entities.Exception.ObjectNotFoundException;
import com.api.vacina.entities.Vacina;
import com.api.vacina.repositories.VacinaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.Optional;

@Service
public class VacinaService {

    @Autowired
    private VacinaRepository vacinaRepository;

    public Vacina save(Vacina vacina) {
        try{
            existMarca(vacina.getMarca());
            vacina.setNomeVacina(vacina.getNomeVacina().toLowerCase(Locale.ROOT));
            return vacinaRepository.save(vacina);
        }
        catch(ObjectConflictException e){
            throw new ObjectConflictException(e.getMessage());
        }
        catch(RuntimeException e){
            throw new ObjectInternalErrorException(e.getMessage());
        }
    }

    public Vacina update(Vacina vacina){
        Vacina vacinaEditada = findByName(vacina.getNomeVacina());
        vacinaEditada.setNomeVacina(vacina.getNomeVacina());
        vacinaEditada.setMarca(vacina.getMarca());
        return vacinaRepository.save(vacinaEditada);
    }

    public Vacina findByName(String name) {
        Optional<Vacina> vacinaEncontrada = vacinaRepository.findByNomeVacina(name);
        if (!vacinaEncontrada.isPresent()) {
            throw new ObjectNotFoundException("Vacina não encontrada");
        }
        else{
            return vacinaEncontrada.get();
        }
    }

    public  Vacina findById(Vacina vacina){
        Optional<Vacina> vacinaEncontrada = vacinaRepository.findById(vacina.getId_vacina());
        if (!vacinaEncontrada.isPresent()) {
            throw new ObjectNotFoundException("Vacina não encontrada");
        }

            return vacinaEncontrada.get();

    }

    public Vacina deleteById(Vacina vacina) {
        Vacina vacinaDeletada = findById(vacina);
        vacinaRepository.delete(vacinaDeletada);
        return vacinaDeletada;
    }

    public List<Vacina> findAll(){

        return vacinaRepository.findAll();
    }

    public void existMarca(String marca){
        if(vacinaRepository.existsByMarca(marca)){
            throw new ObjectConflictException("Conflict: Vacina já existe");
        }
    }
}
