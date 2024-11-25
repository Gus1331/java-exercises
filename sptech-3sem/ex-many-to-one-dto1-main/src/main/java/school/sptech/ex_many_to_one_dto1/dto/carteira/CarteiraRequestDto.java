package school.sptech.ex_many_to_one_dto1.dto.carteira;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CarteiraRequestDto {

    @NotBlank
    private String nome;

    @NotBlank
    private String investidor;
}
