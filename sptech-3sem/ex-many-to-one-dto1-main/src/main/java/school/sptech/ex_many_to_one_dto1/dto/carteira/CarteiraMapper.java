package school.sptech.ex_many_to_one_dto1.dto.carteira;

import school.sptech.ex_many_to_one_dto1.entity.Carteira;

public class CarteiraMapper {

    public static CarteiraResponseDto toCarteiraResponseDto(Carteira carteira) {

        if (carteira == null) {
            return null;
        }

        return CarteiraResponseDto.builder()
                .id(carteira.getId())
                .nome(carteira.getNome())
                .investidor(carteira.getInvestidor())
                .build();
    }

    public static Carteira toCarteiraEntity(CarteiraRequestDto carteiraRequestDto) {

        if (carteiraRequestDto == null) {
            return null;
        }

        return Carteira.builder()
                .nome(carteiraRequestDto.getNome())
                .investidor(carteiraRequestDto.getInvestidor())
                .build();
    }
}
