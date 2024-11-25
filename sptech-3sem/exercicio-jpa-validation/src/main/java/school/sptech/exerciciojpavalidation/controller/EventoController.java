package school.sptech.exerciciojpavalidation.controller;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.exerciciojpavalidation.entity.Evento;
import school.sptech.exerciciojpavalidation.service.EventoService;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/eventos")
public class EventoController {

    @Autowired
    EventoService service;

    @PostMapping
    public ResponseEntity<Evento> criar(@RequestBody @Valid Evento evento) {
        return ResponseEntity.status(201).body(service.criar(evento));
        // return ResponseEntity.created(null).body(service.criar(evento));
    }

    @GetMapping
    public ResponseEntity<List<Evento>> listar() {
        List<Evento> evs = service.listar();
        if (evs.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(evs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Evento> buscarPorId(@PathVariable Integer id) {
        return ResponseEntity.ok(service.buscarPorId(id));
    }

    @GetMapping("/gratuitos")
    public ResponseEntity<List<Evento>> buscarGratuitos() {
        List<Evento> evs = service.buscarGratuitos();
        if (evs.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(evs);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Integer id) {
        if (service.deletar(id)) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(404).build();
    }

    @GetMapping("/data")
    public ResponseEntity<List<Evento>> buscarPorOcorrencia(@RequestParam("ocorrencia") LocalDate ocorrencia) {
        List<Evento> evs = service.buscarPorOcorrencia(ocorrencia);
        if (evs.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(evs);
    }

    @GetMapping("/periodo")
    public ResponseEntity<List<Evento>> buscarPorPeriodo(
            @RequestParam("inicio") LocalDate inicio,
            @RequestParam("fim") LocalDate fim) {
        List<Evento> evs = service.buscarPorPeriodo(inicio, fim);
        if (evs.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
        return ResponseEntity.status(200).body(evs);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evento> atualizar(@PathVariable Integer id, @RequestBody @Valid Evento ev) {
        Evento evs = service.atualizar(id, ev);
        return ResponseEntity.status(200).body(evs);
    }

    @PatchMapping("/{id}/cancelamento")
    public ResponseEntity<Void> cancelarEvento(@PathVariable Integer id){
        service.cancelar(id);
        return ResponseEntity.status(204).build();
    }
}
