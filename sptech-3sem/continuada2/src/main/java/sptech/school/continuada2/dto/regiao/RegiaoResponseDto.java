package sptech.school.continuada2.dto.regiao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegiaoResponseDto {

    // WARN: Não edite essa classe! Já está pronta.

    private int id;
    private String nome;
    private String descricao;
    private String sigla;
}
