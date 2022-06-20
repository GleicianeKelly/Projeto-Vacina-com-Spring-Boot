package com.api.vacina.service;

import com.api.vacina.entities.Exception.ObjectConflictException;
import com.api.vacina.entities.Exception.ObjectInternalErrorException;
import com.api.vacina.entities.Exception.ObjectNotFoundException;
import com.api.vacina.entities.Paciente;
import com.api.vacina.repositories.PacienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Locale;
import java.util.Optional;


@Service
public class PacienteService {

    @Autowired
    private PacienteRepository pacienteRepository;

    @Transactional
     public Paciente save(Paciente paciente){
        try{
            existCpf(paciente.getCpf());
            paciente.setNomePaciente(paciente.getNomePaciente().toLowerCase(Locale.ROOT));
            return pacienteRepository.save(paciente);
        }catch(ObjectConflictException e){
            throw new ObjectConflictException(e.getMessage());
        }catch(RuntimeException e){
            throw new ObjectInternalErrorException(e.getMessage());
        }

    }



    public List<Paciente> findAll(){

        return pacienteRepository.findAll();
    }

    public Paciente findByName(String nome){
        Optional<Paciente> p = pacienteRepository.findByNomePaciente(nome);

        if(!p.isPresent()){
            throw new ObjectNotFoundException("Paciente não encontrado! ");
        }
        return p.get();
    }

    public Paciente findById(Paciente paciente){
        Optional<Paciente> pacienteEncontrado = pacienteRepository.findById(paciente.getId_paciente());
        if(!pacienteEncontrado.isPresent()){
            throw new ObjectNotFoundException("Paciente não encontrado! ");
        }
        return pacienteEncontrado.get();
    }

    public Paciente deleteById(Paciente paciente){
        Paciente pacienteDeletado = findById(paciente);
        pacienteRepository.delete(pacienteDeletado);
        return pacienteDeletado;
    }

    public Paciente update(Paciente paciente){
        Paciente pacienteEncontrado = findByName(paciente.getNomePaciente());
        pacienteEncontrado.setNomePaciente(paciente.getNomePaciente());
        pacienteEncontrado.setEndereco(paciente.getEndereco());
        pacienteEncontrado.setCpf(paciente.getCpf());
        return pacienteRepository.save(pacienteEncontrado);
    }


    private void existCpf(String cpf){
        if(pacienteRepository.existsByCpf(cpf)){
            throw new ObjectConflictException("Conflict: cpf já existe!");
        }
    }

}
