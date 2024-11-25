package sptech.school.continuada2.dto.personagem;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sptech.school.continuada2.entity.Personagem;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("4. [ESTRUTURA] - Estrutura da classe PersonagemMapper")
class PersonagemMapperStructureTest {

    private final Class<?> personagemMapperClass = PersonagemMapper.class;

    @Test
    @DisplayName("Deve ter o método estático toEntity(Personagem) que retorna Personagem")
    void testToEntityMethodExists() {
        try {
            Method toEntityMethod = personagemMapperClass.getDeclaredMethod("toEntity", PersonagemCreateDto.class);

            assertTrue(toEntityMethod.getReturnType().equals(Personagem.class),
                    "O método 'toEntity' deve retornar um objeto do tipo 'Personagem'.");
            assertEquals(1, toEntityMethod.getParameterCount(),
                    "O método 'toEntity' deve receber um parâmetro.");
            assertTrue(Modifier.isPublic(toEntityMethod.getModifiers()),
                    "O método 'toEntity' deve ser público.");
            assertTrue(Modifier.isStatic(toEntityMethod.getModifiers()),
                    "O método 'toEntity' deve ser estático.");
        } catch (NoSuchMethodException e) {
            fail("O método 'toEntity(Personagem)' não foi encontrado na classe PersonagemMapper com o parâmetro 'PersonagemCreateDto'.");
        }
    }

    @Test
    @DisplayName("Deve ter o método estático toDto(Personagem) que retorna PersonagemResponseDto")
    void testToResponseDtoMethodExists() {
        try {
            Method toResponseDtoMethod = personagemMapperClass.getDeclaredMethod("toDto", Personagem.class);

            assertTrue(toResponseDtoMethod.getReturnType().equals(PersonagemResponseDto.class),
                    "O método 'toResponseDto' deve retornar um objeto do tipo 'PersonagemResponseDto'.");
            assertEquals(1, toResponseDtoMethod.getParameterCount(),
                    "O método 'toResponseDto' deve receber um parâmetro.");
            assertTrue(Modifier.isPublic(toResponseDtoMethod.getModifiers()),
                    "O método 'toResponseDto' deve ser público.");
            assertTrue(Modifier.isStatic(toResponseDtoMethod.getModifiers()),
                    "O método 'toResponseDto' deve ser estático.");
        } catch (NoSuchMethodException e) {
            fail("O método 'toResponseDto(Personagem)' não foi encontrado na classe PersonagemMapper.");
        }
    }



}