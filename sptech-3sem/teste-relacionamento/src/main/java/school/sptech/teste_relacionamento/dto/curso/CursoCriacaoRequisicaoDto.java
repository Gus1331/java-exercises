package school.sptech.teste_relacionamento.dto.curso;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
@Builder
public class CursoCriacaoRequisicaoDto {
    private String nome;
    private String descricao;
    private Double preco;
    private String categoria;
}
