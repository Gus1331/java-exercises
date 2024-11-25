package school.sptech.teste_relacionamento.dto.aluno;

import school.sptech.teste_relacionamento.entity.Aluno;
import school.sptech.teste_relacionamento.entity.Curso;

public class AlunoMapper {

    public static AlunoDetalheResponseDto toRespostaDto(Aluno e){
        if(e == null) return null;

        Curso curso = e.getCurso();
        AlunoDetalheResponseDto.CursoDto cursoDto = AlunoDetalheResponseDto.CursoDto.builder()
                .id(curso.getId())
                .nome(curso.getNome())
                .categoria(curso.getCategoria())
                .preco(curso.getPreco())
                .build();

        return AlunoDetalheResponseDto.builder()
                .id(e.getId())
                .nome(e.getNome())
                .cpf(e.getCpf())
                .dataNascimento(e.getDataNascimento())
                .curso(cursoDto)
                .build();
    }

    public static Aluno toEntidadeDto(AlunoCriacaoRequisicaoDto dto){
        if(dto == null) return null;
        Aluno e = new Aluno();
        e.setNome(dto.getNome());
        e.setCpf(dto.getCpf());
        e.setDataNascimento(dto.getDataNascimento());

        return e;
    }
}
