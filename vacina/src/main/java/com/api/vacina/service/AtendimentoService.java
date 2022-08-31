package com.api.vacina.service;
import com.api.vacina.entities.Atendimento;
import com.api.vacina.entities.AtendimentoRequest;
import com.api.vacina.entities.Exception.ObjectNotFoundException;
import com.api.vacina.entities.Paciente;
import com.api.vacina.entities.Vacina;
import com.api.vacina.repositories.AtendimentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AtendimentoService {

    @Autowired
    private AtendimentoRepository atendimentoRepository;

    @Autowired
    private PacienteService pacienteService;

    @Autowired
    private VacinaService vacinaService;

    public List<Atendimento> findAll(){
        return atendimentoRepository.findAll();
    }


    @Transactional
    public Atendimento findByName(String nome){
        Paciente p = pacienteService.findByName(nome);
        Optional<Atendimento> atendimento = atendimentoRepository.findByPaciente(p.getId_paciente());
        if(!atendimento.isPresent()){
            throw new ObjectNotFoundException("Atendimento não encontrado");
        }
        return atendimento.get();
    }

    @Transactional
    public void save(AtendimentoRequest atendimentoRequest){
       atendimentoRepository.save(mapeandoAtendimento(atendimentoRequest));
    }

    private Atendimento mapeandoAtendimento(AtendimentoRequest atendimentoRequest){
        Paciente paciente = pacienteService.findByName(atendimentoRequest.getNomePaciente());
        List<Vacina> vacina = atendimentoRequest.getNomeVacina().stream().map(u->vacinaService.findByName(u)).collect(Collectors.toList());
        Atendimento atendimento = new Atendimento();
        atendimento.setDt_atendimento(new Date());
        atendimento.setPaciente(paciente);
        atendimento.setVacina(vacina);
        return atendimento;
    }

}
