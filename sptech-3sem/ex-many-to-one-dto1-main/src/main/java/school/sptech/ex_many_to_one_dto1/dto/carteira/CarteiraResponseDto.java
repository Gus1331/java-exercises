package school.sptech.ex_many_to_one_dto1.dto.carteira;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarteiraResponseDto {
    private int id;
    private String nome;
    private String investidor;
}
