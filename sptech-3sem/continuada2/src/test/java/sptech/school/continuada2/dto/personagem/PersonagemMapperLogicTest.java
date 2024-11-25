package sptech.school.continuada2.dto.personagem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.function.Try;
import sptech.school.continuada2.entity.Personagem;
import sptech.school.continuada2.entity.Regiao;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static org.hibernate.validator.internal.util.Contracts.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("5. [LÓGICA] - Estrutura da classe PersonagemMapper")
class PersonagemMapperLogicTest {

    @Test
    @DisplayName("Deve implementar mapeamento de PersonagemCreateDto para Personagem")
    void deveConverterPersonagemCreateDtoParaPersonagemComSucesso() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {
            PersonagemCreateDto personagemCreateDto = new PersonagemCreateDto();
            personagemCreateDto.setNome("Yasuo");
            personagemCreateDto.setUltimate("Last Breath");
            personagemCreateDto.setFuncaoPrincipal("Mid");

            Personagem personagemConvertido = PersonagemMapper.toEntity(personagemCreateDto);

            Method getRegiao = Personagem.class.getDeclaredMethod("getRegiao");

            assertNotNull(personagemConvertido, "O objeto Personagem não deve ser nulo");
            assertEquals(personagemCreateDto.getNome(), personagemConvertido.getNome(), "O nome do Personagem deve ser igual ao nome do PersonagemCreateDto");
            assertEquals(personagemCreateDto.getUltimate(), personagemConvertido.getUltimate(), "O ultimate do Personagem deve ser igual ao ultimate do PersonagemCreateDto");
            assertEquals(personagemCreateDto.getFuncaoPrincipal(), personagemConvertido.getFuncaoPrincipal(), "A função principal do Personagem deve ser igual à função principal do PersonagemCreateDto");
            assertNull(getRegiao.invoke(personagemConvertido), "A região do Personagem deve ser nula no momento da conversão");
        } catch (NoSuchMethodException e) {
            fail("Não foi possível acessar os métodos de Região dentro de personagem");
        }
    }

    @Test
    @DisplayName("Deve implementar mapeamento de Personagem para PersonagemResponseDto")
    void deveConverterPersonagemParaPersonagemResponseDtoComSucesso() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        try {


            Regiao regiao = new Regiao();
            regiao.setId(1);
            regiao.setNome("Ionia");
            regiao.setSigla("IO");
            regiao.setDescricao("Região de Yasuo");

            Personagem personagem = new Personagem();
            personagem.setId(1);
            personagem.setNome("Yasuo");
            personagem.setUltimate("Last Breath");
            personagem.setFuncaoPrincipal("Mid");
            Personagem.class.getDeclaredMethod("setRegiao", Regiao.class).invoke(personagem, regiao);

            Method getRegiaoId = Personagem.class.getDeclaredMethod("getRegiao").invoke(personagem).getClass().getDeclaredMethod("getId");
            Method getRegiaoNome = Personagem.class.getDeclaredMethod("getRegiao").invoke(personagem).getClass().getDeclaredMethod("getNome");
            Method getRegiaoSigla = Personagem.class.getDeclaredMethod("getRegiao").invoke(personagem).getClass().getDeclaredMethod("getSigla");
            Method getRegiaoDescricao = Personagem.class.getDeclaredMethod("getRegiao").invoke(personagem).getClass().getDeclaredMethod("getDescricao");

            PersonagemResponseDto personagemResponseDto = PersonagemMapper.toDto(personagem);

            assertNotNull(personagemResponseDto, "O objeto PersonagemResponseDto não deve ser nulo");
            assertEquals(personagem.getId(), personagemResponseDto.getId(), "O ID do Personagem deve ser igual ao ID do PersonagemResponseDto");
            assertEquals(personagem.getNome(), personagemResponseDto.getNome(), "O nome do Personagem deve ser igual ao nome do PersonagemResponseDto");
            assertEquals(personagem.getUltimate(), personagemResponseDto.getUltimate(), "O ultimate do Personagem deve ser igual ao ultimate do PersonagemResponseDto");
            assertEquals(personagem.getFuncaoPrincipal(), personagemResponseDto.getFuncaoPrincipal(), "A função principal do Personagem deve ser igual à função principal do PersonagemResponseDto");
            assertEquals(getRegiaoId.invoke(regiao), personagemResponseDto.getRegiao().getId(), "O ID da região do Personagem deve ser igual ao ID da região do PersonagemResponseDto");
            assertEquals(getRegiaoNome.invoke(regiao), personagemResponseDto.getRegiao().getNome(), "O nome da região do Personagem deve ser igual ao nome da região do PersonagemResponseDto");
            assertEquals(getRegiaoSigla.invoke(regiao), personagemResponseDto.getRegiao().getSigla(), "A sigla da região do Personagem deve ser igual à sigla da região do PersonagemResponseDto");
            assertEquals(getRegiaoDescricao.invoke(regiao), personagemResponseDto.getRegiao().getDescricao(), "A descrição da região do Personagem deve ser igual à descrição da região do PersonagemResponseDto");

        } catch (NoSuchMethodException e) {
            fail("Não foi possível acessar os métodos de Região dentro de personagem");
        }
    }

    @Test
    @DisplayName("Deve retornar null ao converter um Personagem nulo para PersonagemResponseDto")
    void deveRetornarNullAoConverterPersonagemNuloParaPersonagemResponseDto() {
        PersonagemResponseDto personagemResponseDto = PersonagemMapper.toDto(null);
        assertNull(personagemResponseDto, "O objeto PersonagemResponseDto deve ser nulo ao converter um Personagem nulo");
    }

    @Test
    @DisplayName("Deve retornar null ao converter um PersonagemCreateDto nulo para Personagem")
    void deveRetornarNullAoConverterPersonagemCreateDtoNuloParaPersonagem() {
        Personagem personagem = PersonagemMapper.toEntity(null);
        assertNull(personagem, "O objeto Personagem deve ser nulo ao converter um PersonagemCreateDto nulo");
    }
}