package school.sptech.ex_many_to_one_dto1.dto.ativo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;

// TODO: TERMINAR A CLASSE
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AtivoRequestDto {
    @NotBlank
    private String nome;
    @NotBlank
    private String tipo;
    @Positive
    @NotNull
    private Double valorAtual;
    @Positive
    @NotNull
    private Integer carteiraId;
}
