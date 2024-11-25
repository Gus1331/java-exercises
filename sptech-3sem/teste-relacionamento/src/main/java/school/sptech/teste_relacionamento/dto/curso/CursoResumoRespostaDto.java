package school.sptech.teste_relacionamento.dto.curso;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
public class CursoResumoRespostaDto {
    private Integer id;
    private String nome;
    private Double preco;
}
