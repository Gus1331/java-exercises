package school.sptech.teste_relacionamento.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.exception.EntidadeNaoEncontradaException;
import school.sptech.teste_relacionamento.repository.AlunoRepository;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlunoService {

    private final AlunoRepository alunoRepository;

    private final CursoService cursoService;

    public List<Aluno> listar(){
        return alunoRepository.findAll();
    }

    public Aluno porId(Integer id) {
        return alunoRepository.findById(id).orElseThrow(() -> new EntidadeNaoEncontradaException("Aluno"));
    }

    public Aluno criar(Aluno entidadeDto, Integer cursoId) {
        entidadeDto.setCurso(cursoService.buscarPorId(cursoId));
        return alunoRepository.save(entidadeDto);
    }
}
