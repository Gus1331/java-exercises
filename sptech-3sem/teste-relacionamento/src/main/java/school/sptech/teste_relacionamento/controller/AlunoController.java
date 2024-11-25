package school.sptech.teste_relacionamento.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import school.sptech.teste_relacionamento.dto.aluno.AlunoCriacaoRequisicaoDto;
import school.sptech.teste_relacionamento.dto.aluno.AlunoDetalheResponseDto;
import school.sptech.teste_relacionamento.dto.aluno.AlunoMapper;
import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.service.AlunoService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/alunos")
@RequiredArgsConstructor
public class AlunoController {

    private final AlunoService alunoService;

    public ResponseEntity<List<AlunoDetalheResponseDto>> listar(){
        List<Aluno> alunos = alunoService.listar();

        if(alunos.isEmpty()){
            return ResponseEntity.status(HttpStatusCode.valueOf(204)).build();
        }

        List<AlunoDetalheResponseDto> listaAuxiliar = new ArrayList<>();

        for(Aluno a: alunos){
            AlunoDetalheResponseDto dto = AlunoMapper.toRespostaDto(a);
            listaAuxiliar.add(dto);
        }
        return ResponseEntity.ok(listaAuxiliar);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AlunoDetalheResponseDto> porId(@PathVariable Integer id){
        Aluno e = alunoService.porId(id);
        AlunoDetalheResponseDto res = AlunoMapper.toRespostaDto(e);
        return ResponseEntity.ok(res);
    }

    @PostMapping
    public ResponseEntity<AlunoDetalheResponseDto> cadastrar(@RequestBody @Valid AlunoCriacaoRequisicaoDto criacaoDto){

        Aluno e = alunoService.criar(AlunoMapper.toEntidadeDto(criacaoDto), criacaoDto.getCursoId());

        AlunoDetalheResponseDto res = AlunoMapper.toRespostaDto(e);
        return ResponseEntity.ok(res);
    }
}
