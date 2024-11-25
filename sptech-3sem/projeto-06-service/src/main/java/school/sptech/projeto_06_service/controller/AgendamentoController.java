package school.sptech.projeto_06_service.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.projeto_06_service.entity.Agendamento;
import school.sptech.projeto_06_service.repository.AgendamentoRepository;
import school.sptech.projeto_06_service.service.AgendamentoService;

import java.util.List;

@RestController
@RequestMapping("/agendamentos")
public class AgendamentoController {

    @Autowired
    private AgendamentoService service;

    @GetMapping
    public ResponseEntity<List<Agendamento>> listar(){
        List<Agendamento> agendamentos = service.listar();

        if(agendamentos.isEmpty()){
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.ok(agendamentos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Agendamento> buscarPorId(@PathVariable Integer id){
        return ResponseEntity.ok(service.porId(id));
    }

    @PostMapping
    public ResponseEntity<Agendamento> criar(@RequestBody @Valid Agendamento novoAgendamento){
        Agendamento agendamentoCriado = service.criar(novoAgendamento);

        // retorna ponto pra consumo do item criado
        return ResponseEntity.created(null).body(agendamentoCriado);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Agendamento> atualizar(
            @PathVariable Integer id,
            @RequestBody @Valid Agendamento agendamentoAtualizado){
        Agendamento agendamentoRetorno = service.atualizar(id, agendamentoAtualizado);
        return ResponseEntity.ok(agendamentoRetorno);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id){
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
