package school.sptech.prova_ac1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Validar classe Usuario")
class FidelidadeEspecificacaoTest {

    @Test
    @DisplayName("Verificar se a classe 'Usuario' tem a anotação @Entity")
    void testAnotacaoEntityNaClasse() {
        boolean isEntityPresent = Usuario.class.isAnnotationPresent(Entity.class);
        assertTrue(isEntityPresent, "A classe 'Usuario' não está anotada com @Entity.");
    }

    @Test
    @DisplayName("Verificar se o atributo 'id' tem a anotação @Id")
    void testAnotacaoIdNoAtributoId() {
        try {
            Field field = Usuario.class.getDeclaredField("id");
            assertTrue(field.isAnnotationPresent(Id.class), "O atributo 'id' não está anotado com @Id.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'id' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Verificar se o atributo 'id' tem a anotação @GeneratedValue com estratégia IDENTITY")
    void testAnotacaoGeneratedValueNoAtributoId() {
        try {
            Field field = Usuario.class.getDeclaredField("id");
            GeneratedValue generatedValue = field.getAnnotation(GeneratedValue.class);
            assertNotNull(generatedValue, "O atributo 'id' não está anotado com @GeneratedValue.");
            assertEquals(GenerationType.IDENTITY, generatedValue.strategy(), "A estratégia de @GeneratedValue no atributo 'id' não é IDENTITY.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'id' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'id'")
    void testAtributoId() {
        try {
            Field field = Usuario.class.getDeclaredField("id");
            assertNotNull(field, "O atributo 'id' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'id' não é privado.");
            assertEquals(Integer.class, field.getType(), "O tipo do atributo 'id' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'id' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'email'")
    void testAtributoEmail() {
        try {
            Field field = Usuario.class.getDeclaredField("email");
            assertNotNull(field, "O atributo 'email' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'email' não é privado.");
            assertEquals(String.class, field.getType(), "O tipo do atributo 'email' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'email' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'nome'")
    void testAtributoNome() {
        try {
            Field field = Usuario.class.getDeclaredField("nome");
            assertNotNull(field, "O atributo 'nome' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'nome' não é privado.");
            assertEquals(String.class, field.getType(), "O tipo do atributo 'nome' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'nome' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'cpf'")
    void testAtributoCpf() {
        try {
            Field field = Usuario.class.getDeclaredField("cpf");
            assertNotNull(field, "O atributo 'cpf' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'cpf' não é privado.");
            assertEquals(String.class, field.getType(), "O tipo do atributo 'cpf' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'cpf' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'senha'")
    void testAtributoSenha() {
        try {
            Field field = Usuario.class.getDeclaredField("senha");
            assertNotNull(field, "O atributo 'senha' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'senha' não é privado.");
            assertEquals(String.class, field.getType(), "O tipo do atributo 'senha' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'senha' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }

    @Test
    @DisplayName("Validar o atributo 'dataNascimento'")
    void testAtributoDataNascimento() {
        try {
            Field field = Usuario.class.getDeclaredField("dataNascimento");
            assertNotNull(field, "O atributo 'dataNascimento' não foi encontrado.");
            assertTrue(java.lang.reflect.Modifier.isPrivate(field.getModifiers()), "O atributo 'dataNascimento' não é privado.");
            assertEquals(LocalDate.class, field.getType(), "O tipo do atributo 'dataNascimento' está incorreto.");
        } catch (NoSuchFieldException e) {
            fail("Erro: O atributo 'dataNascimento' não foi encontrado na classe Usuario. Verifique se ele está declarado corretamente.", e);
        }
    }
}
