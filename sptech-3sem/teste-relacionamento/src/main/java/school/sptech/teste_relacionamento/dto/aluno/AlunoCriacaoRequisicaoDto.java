package school.sptech.teste_relacionamento.dto.aluno;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AlunoCriacaoRequisicaoDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String cpf;
    @Past
    private LocalDate dataNascimento;
    @NotNull
    private Integer cursoId;
}
