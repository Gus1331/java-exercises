package sptech.school.continuada2.dto.personagem;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonagemResponseDto {

    // WARN: Não edite essa classe! Já está pronta.

    private int id;
    private String nome;
    private String ultimate;
    private String funcaoPrincipal;
    private RegiaoPersonagemResponseDto regiao;

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RegiaoPersonagemResponseDto {
        private int id;
        private String nome;
        private String descricao;
        private String sigla;
    }
}
