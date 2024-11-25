package school.sptech.teste_relacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import school.sptech.teste_relacionamento.entity.Curso;
import school.sptech.teste_relacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.teste_relacionamento.repository.CursoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CursoService {

    //@Autowired
    private final CursoRepository cursoRepository;

    public Curso cadastrar(Curso cursoParaCadastro) {
        return cursoRepository.save(cursoParaCadastro);
    }

    public List<Curso> listar() {
        return cursoRepository.findAll();
    }

    public Curso buscarPorId(int id) {
        return cursoRepository.findById(id).orElseThrow(
                () -> new EntidadeNaoEncontradaException("Curso de is %d não encontrado".formatted(id))
        );
    }
}
