package school.sptech.projeto_06_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.projeto_06_service.entity.Agendamento;
import school.sptech.projeto_06_service.exeption.EntidadeNaoEncontradaExeption;
import school.sptech.projeto_06_service.repository.AgendamentoRepository;

import java.util.List;
import java.util.Optional;

@Service
public class AgendamentoService {

    @Autowired
    private AgendamentoRepository agendamentoRepository;

    public List<Agendamento> listar(){
        return agendamentoRepository.findAll();
    }

    public Agendamento porId(Integer id){
        Optional<Agendamento> agOpt = agendamentoRepository.findById(id);

        if(agOpt.isEmpty()){
            throw new EntidadeNaoEncontradaExeption("Agendamento");
        }
        return agOpt.get();
    }

    public Agendamento criar(Agendamento novoAgendamento){
        if(agendamentoRepository.existsByData(novoAgendamento.getData())){
            throw new ResponseStatusException(HttpStatus.CONFLICT);
        }
        novoAgendamento.setId(null);
        return agendamentoRepository.save(novoAgendamento);
    }

    public Agendamento atualizar(Integer id, Agendamento agendamentoAtualizado){
        if(agendamentoRepository.existsById(id)){
            agendamentoAtualizado.setId(id);
            return agendamentoRepository.save(agendamentoAtualizado);
        }
        throw new EntidadeNaoEncontradaExeption("Agendamento");
    }

    public void deletar(Integer id) {
        if(agendamentoRepository.existsById(id)){
            agendamentoRepository.deleteById(id);
        }else{
            throw new EntidadeNaoEncontradaExeption("Agendamento");
        }
    }
}
