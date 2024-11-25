package school.sptech.teste_relacionamento.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.teste_relacionamento.dto.curso.CursoCriacaoRequisicaoDto;
import school.sptech.teste_relacionamento.dto.curso.CursoDetalheRespostaDto;
import school.sptech.teste_relacionamento.dto.curso.CursoMapper;
import school.sptech.teste_relacionamento.dto.curso.CursoResumoRespostaDto;
import school.sptech.teste_relacionamento.entity.Curso;
import school.sptech.teste_relacionamento.service.CursoService;

import java.util.List;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @PostMapping
    public ResponseEntity<CursoDetalheRespostaDto> cadastro(
            @RequestBody CursoCriacaoRequisicaoDto cursoCriacaoDto
    ) {
        Curso entidade = CursoMapper.toCriacaoDto(cursoCriacaoDto);
        Curso cursoSalvo = this.cursoService.cadastrar(entidade);
        CursoDetalheRespostaDto dtoResposta = CursoMapper.toDetalheDto(entidade);
        return ResponseEntity.status(201).body(dtoResposta);
    }

    @GetMapping
    public ResponseEntity<List<CursoResumoRespostaDto>> listagem() {
        List<Curso> listagem = cursoService.listar();
        if (listagem.isEmpty()) {
            return ResponseEntity.status(204).build();
        }
//        List<CursoResumoRespostaDto> listaDto = new ArrayList<>();
//
//        for (Curso curso : listagem){
//            CursoResumoRespostaDto dto = CursoMapper.toResumoDto(curso);
//
//            listaDto.add(dto);
//        }

        List<CursoResumoRespostaDto> listaDto = listagem.stream().map(CursoMapper::toResumoDto).toList();
        return ResponseEntity.status(200).body(listaDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CursoDetalheRespostaDto> buscarPorId(@PathVariable Integer id) {
        Curso curso = this.cursoService.buscarPorId(id);

        CursoDetalheRespostaDto dto = CursoMapper.toDetalheDto(curso);
        return ResponseEntity.status(200).body(dto);
    }
}
