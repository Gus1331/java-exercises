package school.sptech.ex_many_to_one_dto1.atividade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoMapper;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoRequestDto;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoResponseDto;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("5. [LÓGICA] - AtivoMapper")
class AtivoMapperLogicTest {

    @Test
    @DisplayName("Deve converter Ativo para AtivoResponseDto com sucesso usando Reflection e instanciando Ativo")
    void deveConverterAtivoParaAtivoResponseDtoComSucessoUsandoReflection() throws Exception {
        // Cenário: Carteira a ser associada ao Ativo
        Carteira carteira = new Carteira();
        Method setIdCarteira = Carteira.class.getDeclaredMethod("setId", Integer.class);
        Method setNomeCarteira = Carteira.class.getDeclaredMethod("setNome", String.class);
        Method setInvestidorCarteira = Carteira.class.getDeclaredMethod("setInvestidor", String.class);

        setIdCarteira.invoke(carteira, 1);
        setNomeCarteira.invoke(carteira, "Carteira de Ações");
        setInvestidorCarteira.invoke(carteira, "João");

        // Instanciar Ativo usando Reflection
        Constructor<Ativo> ativoConstructor = Ativo.class.getDeclaredConstructor();
        Ativo ativo = ativoConstructor.newInstance();

        // Usar Reflection para configurar os atributos do Ativo via setters
        Method setId = Ativo.class.getDeclaredMethod("setId", Integer.class);
        Method setNome = Ativo.class.getDeclaredMethod("setNome", String.class);
        Method setTipo = Ativo.class.getDeclaredMethod("setTipo", String.class);
        Method setValorAtual = Ativo.class.getDeclaredMethod("setValorAtual", Double.class);
        Method setCarteira = Ativo.class.getDeclaredMethod("setCarteira", Carteira.class);

        setId.invoke(ativo, 1);
        setNome.invoke(ativo, "Ação XYZ");
        setTipo.invoke(ativo, "Ação");
        setValorAtual.invoke(ativo, 150.0);
        setCarteira.invoke(ativo, carteira);

        // Converter Ativo para AtivoResponseDto via Reflection
        Method toAtivoResponseDtoMethod = AtivoMapper.class.getDeclaredMethod("toAtivoResponseDto", Ativo.class);
        AtivoResponseDto responseDto = (AtivoResponseDto) toAtivoResponseDtoMethod.invoke(null, ativo);

        // Verificações usando Reflection nos DTOs
        Method getIdResponse = AtivoResponseDto.class.getDeclaredMethod("getId");
        Method getNomeResponse = AtivoResponseDto.class.getDeclaredMethod("getNome");
        Method getTipoResponse = AtivoResponseDto.class.getDeclaredMethod("getTipo");
        Method getValorAtualResponse = AtivoResponseDto.class.getDeclaredMethod("getValorAtual");
        Method getCarteiraResponse = AtivoResponseDto.class.getDeclaredMethod("getCarteira");

        assertNotNull(responseDto, "O objeto AtivoResponseDto não deve ser nulo");
        assertEquals(1, getIdResponse.invoke(responseDto), "O ID do ativo deve ser 1");
        assertEquals("Ação XYZ", getNomeResponse.invoke(responseDto), "O nome do ativo deve ser 'Ação XYZ'");
        assertEquals("Ação", getTipoResponse.invoke(responseDto), "O tipo do ativo deve ser 'Ação'");
        assertEquals(150.0, getValorAtualResponse.invoke(responseDto), "O valor atual do ativo deve ser 150.0");

        Object carteiraResponse = getCarteiraResponse.invoke(responseDto);
        assertNotNull(carteiraResponse, "A carteira dentro de AtivoResponseDto não deve ser nula");

        Method getIdCarteiraResponse = carteiraResponse.getClass().getDeclaredMethod("getId");
        Method getNomeCarteiraResponse = carteiraResponse.getClass().getDeclaredMethod("getNome");
        Method getInvestidorCarteiraResponse = carteiraResponse.getClass().getDeclaredMethod("getInvestidor");

        assertEquals(1, getIdCarteiraResponse.invoke(carteiraResponse), "O ID da carteira deve ser 1");
        assertEquals("Carteira de Ações", getNomeCarteiraResponse.invoke(carteiraResponse), "O nome da carteira deve ser 'Carteira de Ações'");
        assertEquals("João", getInvestidorCarteiraResponse.invoke(carteiraResponse), "O investidor da carteira deve ser 'João'");
    }

    @Test
    @DisplayName("Deve converter AtivoRequestDto para Ativo com sucesso usando Reflection e instanciando Ativo")
    void deveConverterAtivoRequestDtoParaAtivoComSucessoUsandoReflection() throws Exception {
        // Criar AtivoRequestDto via Reflection e configurar os atributos
        Constructor<AtivoRequestDto> requestDtoConstructor = AtivoRequestDto.class.getDeclaredConstructor();
        AtivoRequestDto requestDto = requestDtoConstructor.newInstance();

        Method setNome = AtivoRequestDto.class.getDeclaredMethod("setNome", String.class);
        Method setTipo = AtivoRequestDto.class.getDeclaredMethod("setTipo", String.class);
        Method setValorAtual = AtivoRequestDto.class.getDeclaredMethod("setValorAtual", Double.class);

        setNome.invoke(requestDto, "Ação ABC");
        setTipo.invoke(requestDto, "Ação");
        setValorAtual.invoke(requestDto, 200.0);

        // Usar Reflection para chamar o método de conversão
        Method toAtivoEntityMethod = AtivoMapper.class.getDeclaredMethod("toAtivoEntity", AtivoRequestDto.class);
        Ativo ativo = (Ativo) toAtivoEntityMethod.invoke(null, requestDto);

        // Usar Reflection para verificar os atributos do Ativo via getters
        Method getNome = Ativo.class.getDeclaredMethod("getNome");
        Method getTipo = Ativo.class.getDeclaredMethod("getTipo");
        Method getValorAtual = Ativo.class.getDeclaredMethod("getValorAtual");

        // Verificações
        assertNotNull(ativo, "O objeto Ativo não deve ser nulo");
        assertEquals("Ação ABC", getNome.invoke(ativo), "O nome do ativo deve ser 'Ação ABC'");
        assertEquals("Ação", getTipo.invoke(ativo), "O tipo do ativo deve ser 'Ação'");
        assertEquals(200.0, getValorAtual.invoke(ativo), "O valor atual do ativo deve ser 200.0");
    }

    @Test
    @DisplayName("Deve instanciar AtivoRequestDto com valores via Reflection e verificar os atributos")
    void deveInstanciarAtivoRequestDtoComReflection() throws Exception {
        // Usar Reflection para criar a instância do AtivoRequestDto
        Constructor<AtivoRequestDto> ativoRequestDtoConstructor = AtivoRequestDto.class.getDeclaredConstructor();
        AtivoRequestDto requestDto = ativoRequestDtoConstructor.newInstance();

        // Usar Reflection para configurar os atributos do AtivoRequestDto
        Method setNome = AtivoRequestDto.class.getDeclaredMethod("setNome", String.class);
        Method setTipo = AtivoRequestDto.class.getDeclaredMethod("setTipo", String.class);
        Method setValorAtual = AtivoRequestDto.class.getDeclaredMethod("setValorAtual", Double.class);

        setNome.invoke(requestDto, "Ação XYZ");
        setTipo.invoke(requestDto, "Ação");
        setValorAtual.invoke(requestDto, 150.0);

        // Usar Reflection para verificar os atributos do AtivoRequestDto via getters
        Method getNome = AtivoRequestDto.class.getDeclaredMethod("getNome");
        Method getTipo = AtivoRequestDto.class.getDeclaredMethod("getTipo");
        Method getValorAtual = AtivoRequestDto.class.getDeclaredMethod("getValorAtual");

        // Verificação: Garantir que os valores foram atribuídos corretamente
        assertNotNull(requestDto, "O objeto AtivoRequestDto não deve ser nulo");
        assertEquals("Ação XYZ", getNome.invoke(requestDto), "O nome do AtivoRequestDto deve ser 'Ação XYZ'");
        assertEquals("Ação", getTipo.invoke(requestDto), "O tipo do AtivoRequestDto deve ser 'Ação'");
        assertEquals(150.0, getValorAtual.invoke(requestDto), "O valor atual do AtivoRequestDto deve ser 150.0");
    }

    @Test
    @DisplayName("Deve retornar null ao tentar converter AtivoRequestDto nulo para Ativo usando Reflection")
    void deveRetornarNullAoConverterAtivoRequestDtoNuloParaAtivoUsandoReflection() throws Exception {
        // Usar Reflection para chamar o método com null
        Method toAtivoEntityMethod = AtivoMapper.class.getDeclaredMethod("toAtivoEntity", AtivoRequestDto.class);
        Ativo ativo = (Ativo) toAtivoEntityMethod.invoke(null, (AtivoRequestDto) null);

        assertNull(ativo, "O método deve retornar null ao passar um AtivoRequestDto nulo");
    }
}
