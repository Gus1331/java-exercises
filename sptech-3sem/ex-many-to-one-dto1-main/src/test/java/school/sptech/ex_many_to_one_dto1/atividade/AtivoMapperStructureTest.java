package school.sptech.ex_many_to_one_dto1.atividade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoMapper;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoRequestDto;
import school.sptech.ex_many_to_one_dto1.dto.ativo.AtivoResponseDto;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("4. [ESTRUTURA] - Estrutura da classe AtivoMapper")
class AtivoMapperStructureTest {

    private final Class<?> ativoMapperClass = AtivoMapper.class;

    @Test
    @DisplayName("Deve ter o método estático toAtivoResponseDto(Ativo) que retorna AtivoResponseDto")
    void testToAtivoResponseDtoMethodExists() {
        try {
            Method toAtivoResponseDtoMethod = ativoMapperClass.getDeclaredMethod("toAtivoResponseDto", Ativo.class);

            assertTrue(Modifier.isStatic(toAtivoResponseDtoMethod.getModifiers()),
                    "O método toAtivoResponseDto deve ser estático");
            assertEquals(AtivoResponseDto.class, toAtivoResponseDtoMethod.getReturnType(),
                    "O método toAtivoResponseDto deve retornar um objeto do tipo AtivoResponseDto");
            assertTrue(Modifier.isPublic(toAtivoResponseDtoMethod.getModifiers()),
                    "O método toAtivoResponseDto deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'toAtivoResponseDto(Ativo)' não foi encontrado na classe AtivoMapper.");
        }
    }

    @Test
    @DisplayName("Deve ter o método estático toAtivoEntity(AtivoRequestDto) que retorna Ativo")
    void testToAtivoEntityMethodExists() {
        try {
            Method toAtivoEntityMethod = ativoMapperClass.getDeclaredMethod("toAtivoEntity", AtivoRequestDto.class);

            assertTrue(Modifier.isStatic(toAtivoEntityMethod.getModifiers()),
                    "O método toAtivoEntity deve ser estático");
            assertEquals(Ativo.class, toAtivoEntityMethod.getReturnType(),
                    "O método toAtivoEntity deve retornar um objeto do tipo Ativo");
            assertTrue(Modifier.isPublic(toAtivoEntityMethod.getModifiers()),
                    "O método toAtivoEntity deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'toAtivoEntity(AtivoRequestDto)' não foi encontrado na classe AtivoMapper.");
        }
    }
}
