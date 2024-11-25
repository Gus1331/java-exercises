package school.sptech.teste_relacionamento.dto.aluno;

import lombok.Builder;
import lombok.Data;
import java.time.LocalDate;

@Data
@Builder
public class AlunoDetalheResponseDto {
    private Integer id;
    private String nome;
    private String cpf;
    private LocalDate dataNascimento;
    private CursoDto curso;

    @Data
    @Builder
    //NESTED CLASS
    static class CursoDto{
        private Integer id;
        private String nome;
        private String descricao;
        private Double preco;
        private String categoria;
    }
}
