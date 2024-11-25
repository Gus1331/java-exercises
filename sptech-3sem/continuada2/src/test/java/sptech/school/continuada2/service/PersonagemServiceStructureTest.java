package sptech.school.continuada2.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import sptech.school.continuada2.entity.Personagem;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

@DisplayName("2. [ESTRUTURA] - Estrutura da classe PersonagemService")
class PersonagemServiceStructureTest {

    private final Class<?> personagemServiceClass = PersonagemService.class;

    @Test
    @DisplayName("Deve ter um método cadastrar(Personagem, int ou Integer) que retorna Personagem")
    void testCadastrarMethodExists() {
        boolean methodFound = false;
        try {
            Method cadastrarMethodInt = personagemServiceClass.getDeclaredMethod("cadastrar", Personagem.class, int.class);
            methodFound = true;
            assertEquals(Personagem.class, cadastrarMethodInt.getReturnType(),
                    "O método cadastrar deve retornar um objeto do tipo Personagem");
            assertTrue(Modifier.isPublic(cadastrarMethodInt.getModifiers()),
                    "O método cadastrar deve ser público");
        } catch (NoSuchMethodException e) {
            // Tentamos com Integer
        }

        try {
            Method cadastrarMethodInteger = personagemServiceClass.getDeclaredMethod("cadastrar", Personagem.class, Integer.class);
            methodFound = true;
            assertEquals(Personagem.class, cadastrarMethodInteger.getReturnType(),
                    "O método cadastrar deve retornar um objeto do tipo Personagem");
            assertTrue(Modifier.isPublic(cadastrarMethodInteger.getModifiers()),
                    "O método cadastrar deve ser público");
        } catch (NoSuchMethodException e) {
            if (!methodFound) {
                fail("O método 'cadastrar(Personagem, int)' ou 'cadastrar(Personagem, Integer)' não foi encontrado na classe PersonagemService.");
            }
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarPorId(int ou Integer) que retorna um objeto Personagem")
    void testBuscarPorIdMethodExists() {
        boolean methodFound = false;
        try {
            Method buscarPorIdMethodInt = personagemServiceClass.getDeclaredMethod("buscarPorId", int.class);
            methodFound = true;
            assertEquals(Personagem.class, buscarPorIdMethodInt.getReturnType(),
                    "O método buscarPorId deve retornar um objeto do tipo Personagem");
            assertTrue(Modifier.isPublic(buscarPorIdMethodInt.getModifiers()),
                    "O método buscarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            // Tentamos com Integer
        }

        try {
            Method buscarPorIdMethodInteger = personagemServiceClass.getDeclaredMethod("buscarPorId", Integer.class);
            methodFound = true;
            assertEquals(Personagem.class, buscarPorIdMethodInteger.getReturnType(),
                    "O método buscarPorId deve retornar um objeto do tipo Personagem");
            assertTrue(Modifier.isPublic(buscarPorIdMethodInteger.getModifiers()),
                    "O método buscarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            if (!methodFound) {
                fail("O método 'buscarPorId(int)' ou 'buscarPorId(Integer)' não foi encontrado na classe PersonagemService.");
            }
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarPorRegiaoNomeAproximado(String) que retorna uma lista de Personagem")
    void testBuscarPorRegiaoNomeAproximadoMethodExists() {
        try {
            Method buscarPorRegiaoNomeAproximadoMethod = personagemServiceClass.getDeclaredMethod("buscarPorRegiaoNomeAproximado", String.class);

            assertEquals(List.class, buscarPorRegiaoNomeAproximadoMethod.getReturnType(),
                    "O método buscarPorRegiaoNomeAproximado deve retornar um objeto do tipo Personagem");

            assertTrue(Modifier.isPublic(buscarPorRegiaoNomeAproximadoMethod.getModifiers()),
                    "O método buscarPorRegiaoNomeAproximado deve ser público");
        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorRegiaoNomeAproximado(String)' não foi encontrado na classe PersonagemService.");
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarPorfuncaoPrincipalAndRegiaoSigla(String, String) que retorna uma lista de Personagem")
    void testBuscarPorfuncaoPrincipalAndRegiaoSiglaMethodExists() {
        try {
            Method buscarPorfuncaoPrincipalAndRegiaoSiglaMethod = personagemServiceClass.getDeclaredMethod("buscarPorfuncaoPrincipalAndRegiaoSigla", String.class, String.class);

            assertEquals(List.class, buscarPorfuncaoPrincipalAndRegiaoSiglaMethod.getReturnType(),
                    "O método buscarPorfuncaoPrincipalAndRegiaoSigla deve retornar um objeto do tipo Personagem");

            assertTrue(Modifier.isPublic(buscarPorfuncaoPrincipalAndRegiaoSiglaMethod.getModifiers()),
                    "O método buscarPorfuncaoPrincipalAndRegiaoSigla deve ser público");
        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorfuncaoPrincipalAndRegiaoSigla(String, String)' não foi encontrado na classe PersonagemService.");
        }
    }
}