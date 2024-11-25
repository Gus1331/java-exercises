package school.sptech.ex_many_to_one_dto1.atividade;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.stereotype.Service;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.repository.AtivoRepository;
import school.sptech.ex_many_to_one_dto1.service.AtivoService;
import school.sptech.ex_many_to_one_dto1.service.CarteiraService;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("2. [ESTRUTURA] - Estrutura da classe AtivoService")
class AtivoServiceStructureTest {

    private final Class<?> ativoServiceClass = AtivoService.class;

    @Test
    @DisplayName("Deve ter a anotação @Service na classe AtivoService")
    void testClassHasServiceAnnotation() {
        assertTrue(ativoServiceClass.isAnnotationPresent(Service.class),
                "A classe AtivoService deve estar anotada com @Service");
    }

    @Test
    @DisplayName("Deve ter um atributo do tipo AtivoRepository")
    void testHasAtivoRepositoryField() {
        try {
            Field repositoryField = ativoServiceClass.getDeclaredField("ativoRepository");

            assertEquals(AtivoRepository.class, repositoryField.getType(),
                    "A classe AtivoService deve ter um campo do tipo AtivoRepository");
            assertTrue(Modifier.isPrivate(repositoryField.getModifiers()),
                    "O campo ativoRepository deve ser privado");

        } catch (NoSuchFieldException e) {
            fail("O campo 'ativoRepository' não foi encontrado na classe AtivoService.");
        }
    }

    @Test
    @DisplayName("Deve ter um atributo do tipo CarteiraService")
    void testHasCarteiraServiceField() {
        try {
            Field carteiraServiceField = ativoServiceClass.getDeclaredField("carteiraService");

            assertEquals(CarteiraService.class, carteiraServiceField.getType(),
                    "A classe AtivoService deve ter um campo do tipo CarteiraService");
            assertTrue(Modifier.isPrivate(carteiraServiceField.getModifiers()),
                    "O campo carteiraService deve ser privado");

        } catch (NoSuchFieldException e) {
            fail("O campo 'carteiraService' não foi encontrado na classe AtivoService.");
        }
    }

    @Test
    @DisplayName("Deve ter um método salvar(Ativo, int ou Integer) que retorna Ativo")
    void testSalvarMethodExists() {
        boolean methodFound = false;
        try {
            Method salvarMethodInt = ativoServiceClass.getDeclaredMethod("salvar", Ativo.class, int.class);
            methodFound = true;
            assertEquals(Ativo.class, salvarMethodInt.getReturnType(),
                    "O método salvar deve retornar um objeto do tipo Ativo");
            assertTrue(Modifier.isPublic(salvarMethodInt.getModifiers()),
                    "O método salvar deve ser público");
        } catch (NoSuchMethodException e) {
            // Tentamos com Integer
        }

        try {
            Method salvarMethodInteger = ativoServiceClass.getDeclaredMethod("salvar", Ativo.class, Integer.class);
            methodFound = true;
            assertEquals(Ativo.class, salvarMethodInteger.getReturnType(),
                    "O método salvar deve retornar um objeto do tipo Ativo");
            assertTrue(Modifier.isPublic(salvarMethodInteger.getModifiers()),
                    "O método salvar deve ser público");
        } catch (NoSuchMethodException e) {
            if (!methodFound) {
                fail("O método 'salvar(Ativo, int)' ou 'salvar(Ativo, Integer)' não foi encontrado na classe AtivoService.");
            }
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarTodos() que retorna uma lista de Ativos")
    void testBuscarTodosMethodExists() {
        try {
            Method buscarTodosMethod = ativoServiceClass.getDeclaredMethod("buscarTodos");

            assertEquals(List.class, buscarTodosMethod.getReturnType(),
                    "O método buscarTodos deve retornar uma lista de objetos do tipo Ativo");

            assertTrue(Modifier.isPublic(buscarTodosMethod.getModifiers()),
                    "O método buscarTodos deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarTodos()' não foi encontrado na classe AtivoService.");
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarPorId(int ou Integer) que retorna um objeto Ativo")
    void testBuscarPorIdMethodExists() {
        boolean methodFound = false;
        try {
            Method buscarPorIdMethodInt = ativoServiceClass.getDeclaredMethod("buscarPorId", int.class);
            methodFound = true;
            assertEquals(Ativo.class, buscarPorIdMethodInt.getReturnType(),
                    "O método buscarPorId deve retornar um objeto do tipo Ativo");
            assertTrue(Modifier.isPublic(buscarPorIdMethodInt.getModifiers()),
                    "O método buscarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            // Tentamos com Integer
        }

        try {
            Method buscarPorIdMethodInteger = ativoServiceClass.getDeclaredMethod("buscarPorId", Integer.class);
            methodFound = true;
            assertEquals(Ativo.class, buscarPorIdMethodInteger.getReturnType(),
                    "O método buscarPorId deve retornar um objeto do tipo Ativo");
            assertTrue(Modifier.isPublic(buscarPorIdMethodInteger.getModifiers()),
                    "O método buscarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            if (!methodFound) {
                fail("O método 'buscarPorId(int)' ou 'buscarPorId(Integer)' não foi encontrado na classe AtivoService.");
            }
        }
    }

    @Test
    @DisplayName("Deve ter um método deletarPorId(int ou Integer) que não retorna nada (void)")
    void testDeletarPorIdMethodExists() {
        boolean methodFound = false;
        try {
            Method deletarPorIdMethodInt = ativoServiceClass.getDeclaredMethod("deletarPorId", int.class);
            methodFound = true;
            assertEquals(void.class, deletarPorIdMethodInt.getReturnType(),
                    "O método deletarPorId deve ser void");
            assertTrue(Modifier.isPublic(deletarPorIdMethodInt.getModifiers()),
                    "O método deletarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            // Tentamos com Integer
        }

        try {
            Method deletarPorIdMethodInteger = ativoServiceClass.getDeclaredMethod("deletarPorId", Integer.class);
            methodFound = true;
            assertEquals(void.class, deletarPorIdMethodInteger.getReturnType(),
                    "O método deletarPorId deve ser void");
            assertTrue(Modifier.isPublic(deletarPorIdMethodInteger.getModifiers()),
                    "O método deletarPorId deve ser público");
        } catch (NoSuchMethodException e) {
            if (!methodFound) {
                fail("O método 'deletarPorId(int)' ou 'deletarPorId(Integer)' não foi encontrado na classe AtivoService.");
            }
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarAtivosPorInvestidorNome(String) que retorna uma lista de Ativos")
    void testBuscarAtivosPorInvestidorNomeMethodExists() {
        try {
            Method buscarAtivosPorInvestidorNomeMethod = ativoServiceClass.getDeclaredMethod("buscarAtivosPorInvestidorNome", String.class);

            assertEquals(List.class, buscarAtivosPorInvestidorNomeMethod.getReturnType(),
                    "O método buscarAtivosPorInvestidorNome deve retornar uma lista de objetos do tipo Ativo");

            assertTrue(Modifier.isPublic(buscarAtivosPorInvestidorNomeMethod.getModifiers()),
                    "O método buscarAtivosPorInvestidorNome deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarAtivosPorInvestidorNome(String)' não foi encontrado na classe AtivoService.");
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarMediaAtivosPorInvestidorNome(String) que retorna um Double")
    void testBuscarMediaAtivosPorInvestidorNomeMethodExists() {
        try {
            Method buscarMediaAtivosPorInvestidorNomeMethod = ativoServiceClass.getDeclaredMethod("buscarMediaAtivosPorInvestidorNome", String.class);

            assertEquals(Double.class, buscarMediaAtivosPorInvestidorNomeMethod.getReturnType(),
                    "O método buscarMediaAtivosPorInvestidorNome deve retornar um valor do tipo Double");

            assertTrue(Modifier.isPublic(buscarMediaAtivosPorInvestidorNomeMethod.getModifiers()),
                    "O método buscarMediaAtivosPorInvestidorNome deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarMediaAtivosPorInvestidorNome(String)' não foi encontrado na classe AtivoService.");
        }
    }
}
