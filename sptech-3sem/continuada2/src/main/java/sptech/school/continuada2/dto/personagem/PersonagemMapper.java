package sptech.school.continuada2.dto.personagem;

import sptech.school.continuada2.entity.Personagem;

public class PersonagemMapper {

    public static Personagem toEntity(PersonagemCreateDto dto) {

        if (dto == null) {
            return null;
        }

        // TODO: Implementar mapeamento de PersonagemCreateDto para Personagem
        return Personagem.builder()
                .nome(dto.getNome())
                .funcaoPrincipal(dto.getFuncaoPrincipal())
                .ultimate(dto.getUltimate())
                // TODO: Completar o de-para dos atributos
                .build();
    }

    public static PersonagemResponseDto toDto(Personagem entity) {

        if (entity == null) {
            return null;
        }

        // TODO: Implementar mapeamento de Regiao para RegiaoPersonagemResponseDto (classe interna de PersonagemResponseDto)
        PersonagemResponseDto.RegiaoPersonagemResponseDto regiaoDto =
                PersonagemResponseDto.RegiaoPersonagemResponseDto.builder()
                        .id(entity.getRegiao().getId())
                        .nome(entity.getRegiao().getNome())
                        .descricao(entity.getRegiao().getDescricao())
                        .sigla(entity.getRegiao().getSigla())
                        // TODO: Completar o de-para dos atributos
                        .build();

        // TODO: Implementar mapeamento de Personagem para PersonagemResponseDto
        return PersonagemResponseDto.builder()
                // TODO: Completar o de-para dos atributos
                .id(entity.getId())
                .nome(entity.getNome())
                .ultimate(entity.getUltimate())
                .funcaoPrincipal(entity.getFuncaoPrincipal())
                .regiao(regiaoDto)
                .build();
    }
}
