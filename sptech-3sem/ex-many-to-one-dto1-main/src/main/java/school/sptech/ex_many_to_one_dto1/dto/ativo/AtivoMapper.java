package school.sptech.ex_many_to_one_dto1.dto.ativo;

import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;


public class AtivoMapper {


    public static AtivoResponseDto toAtivoResponseDto(Ativo ativo){
        if(ativo == null) return null;
        AtivoResponseDto.AtivoCarteiraResponseDto carteiraDto =AtivoResponseDto.AtivoCarteiraResponseDto.builder()
                .id(ativo.getCarteira().getId())
                .nome(ativo.getCarteira().getNome())
                .investidor(ativo.getCarteira().getInvestidor())
                .build();

        return new AtivoResponseDto().builder()
                .id(ativo.getId())
                .tipo(ativo.getTipo())
                .nome(ativo.getNome())
                .valorAtual(ativo.getValorAtual())
                .carteira(carteiraDto)
                .build();
    }

    public static Ativo toAtivoEntity(AtivoRequestDto a){
        if(a == null) return null;

        return new Ativo().builder()
                .tipo(a.getTipo())
                .nome(a.getNome())
                .valorAtual(a.getValorAtual())
                .carteira(Carteira.builder()
                        .id(a.getCarteiraId())
                        .build())
                .build();
    }
}
