package sptech.school.continuada2.dto.regiao;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class RegiaoCreateDto {

    // WARN: Não edite essa classe! Já está pronta.

    @NotBlank
    @Schema(description = "Nome da região", example = "Demacia")
    private String nome;

    @NotBlank
    @Schema(description = "Descrição da região", example = "Região de cavaleiros")
    private String descricao;

    @NotBlank
    @Schema(description = "Sigla da região", example = "DC")
    private String sigla;
}
