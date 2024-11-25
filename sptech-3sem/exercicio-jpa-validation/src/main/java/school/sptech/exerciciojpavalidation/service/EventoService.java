package school.sptech.exerciciojpavalidation.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import school.sptech.exerciciojpavalidation.entity.Evento;
import school.sptech.exerciciojpavalidation.repository.EventoRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class EventoService {

    @Autowired
    EventoRepository repository;

    public Evento criar(Evento evento) {
        return repository.save(evento);
    }

    public List<Evento> listar() {
        return repository.findAll();
    }

    public Evento buscarPorId(Integer id) {
        if (repository.existsById(id)) {
            return repository.findById(id).get();
        }
        throw new ResponseStatusException(HttpStatusCode.valueOf(404));
    }

    public List<Evento> buscarGratuitos() {
        return repository.findByGratuito(true);
    }

    public boolean deletar(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        } else return false;
    }

    public List<Evento> buscarPorOcorrencia(LocalDate ocorrencia) {
        return repository.findByDataEventoOrDataPublicacao(ocorrencia, ocorrencia);
    }

    public List<Evento> buscarPorPeriodo(LocalDate inicio, LocalDate fim) {
        if (inicio.isAfter(fim)) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }
        return repository.findByDataEventoBetween(inicio, fim);
    }


    public Evento atualizar(Integer id, Evento ev) {
        Optional<Evento> evAntigo = repository.findById(id);
        if (evAntigo.isPresent()) {
            if (evAntigo.get().getCancelado() || evAntigo.get().getDataEvento().isBefore(LocalDate.now())) {
                throw new ResponseStatusException(HttpStatusCode.valueOf(422));
            }
            return repository.save(ev);
        } else{
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }

    public void cancelar(Integer id) {
        Optional<Evento> ev = repository.findById(id);
        if (ev.isPresent()) {
            if (ev.get().getCancelado()) {
                throw new ResponseStatusException(HttpStatusCode.valueOf(422));
            } else {
                ev.get().setCancelado(false);
                repository.save(ev.get());
            }
        } else {
            throw new ResponseStatusException(HttpStatusCode.valueOf(404));
        }
    }
}
