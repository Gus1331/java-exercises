package sptech.school.continuada2.dto.regiao;

import sptech.school.continuada2.entity.Regiao;

public class RegiaoMapper {

    // WARN: Não edite essa classe! Já está pronta.

    public static RegiaoResponseDto toResponseDto(Regiao regiao) {

        if (regiao == null) {
            return null;
        }

        return RegiaoResponseDto.builder()
                .id(regiao.getId())
                .nome(regiao.getNome())
                .descricao(regiao.getDescricao())
                .sigla(regiao.getSigla())
                .build();
    }

    public static Regiao toEntity(RegiaoCreateDto regiaoCreateDto) {

        if (regiaoCreateDto == null) {
            return null;
        }

        return Regiao.builder()
                .nome(regiaoCreateDto.getNome())
                .descricao(regiaoCreateDto.getDescricao())
                .sigla(regiaoCreateDto.getSigla())
                .build();
    }
}
