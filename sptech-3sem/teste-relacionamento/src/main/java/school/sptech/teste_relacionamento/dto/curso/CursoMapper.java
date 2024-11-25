package school.sptech.teste_relacionamento.dto.curso;

import school.sptech.teste_relacionamento.entity.Curso;

public class CursoMapper {
    public static CursoDetalheRespostaDto toDetalheDto(Curso entity){
        if(entity == null){
            return null;
        }
        CursoDetalheRespostaDto dto = CursoDetalheRespostaDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .descricao(entity.getDescricao())
                .preco(entity.getPreco())
                .categoria(entity.getCategoria())
                .build();
        return dto;
    }

    public static CursoResumoRespostaDto toResumoDto(Curso entity){
        if(entity == null){
            return null;
        }
        CursoResumoRespostaDto dto = CursoResumoRespostaDto.builder()
                .id(entity.getId())
                .nome(entity.getNome())
                .preco(entity.getPreco())
                .build();

        return dto;
    }

    public static Curso toCriacaoDto(CursoCriacaoRequisicaoDto dto){
        if(dto == null){
            return null;
        }

        Curso entidade = Curso.builder()
                .nome(dto.getNome())
                .descricao(dto.getDescricao())
                .preco(dto.getPreco())
                .categoria(dto.getCategoria())
                .build();

        return entidade;
    }
}
