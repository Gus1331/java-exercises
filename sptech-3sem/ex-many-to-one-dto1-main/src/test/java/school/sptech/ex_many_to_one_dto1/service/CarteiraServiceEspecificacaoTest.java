package school.sptech.ex_many_to_one_dto1.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.stereotype.Service;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.repository.CarteiraRepository;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("[OK] - Especificação da classe CarteiraService")
class CarteiraServiceEspecificacaoTest {

    private final Class<?> carteiraServiceClass = CarteiraService.class;

    @Test
    @DisplayName("Deve ter a anotação @Service na classe CarteiraService")
    void testClassHasServiceAnnotation() {
        assertTrue(carteiraServiceClass.isAnnotationPresent(Service.class),
                "Dado que a classe CarteiraService é um serviço, então ela deve estar anotada com @Service");
    }

    @Test
    @DisplayName("Deve ter um método salvar(Carteira) que retorna um objeto do tipo Carteira")
    void testSalvarMethodExists() {
        try {
            Method salvarMethod = carteiraServiceClass.getDeclaredMethod("salvar", Carteira.class);

            assertEquals(Carteira.class, salvarMethod.getReturnType(),
                    "Dado que o método salvar é usado para persistir uma Carteira, então ele deve retornar um objeto do tipo Carteira");

            assertTrue(Modifier.isPublic(salvarMethod.getModifiers()),
                    "Dado que o método salvar é acessível externamente, então ele deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'salvar(Carteira)' não foi encontrado na classe CarteiraService. Verifique se o método está corretamente definido.");
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarTodos() que retorna uma lista de Carteira")
    void testBuscarTodosMethodExists() {
        try {
            Method buscarTodosMethod = carteiraServiceClass.getDeclaredMethod("buscarTodos");

            assertEquals(List.class, buscarTodosMethod.getReturnType(),
                    "Dado que o método buscarTodos é usado para recuperar todas as carteiras, então ele deve retornar uma lista de objetos do tipo Carteira");

            assertTrue(Modifier.isPublic(buscarTodosMethod.getModifiers()),
                    "Dado que o método buscarTodos é acessível externamente, então ele deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarTodos()' não foi encontrado na classe CarteiraService. Verifique se o método está corretamente definido.");
        }
    }

    @Test
    @DisplayName("Deve ter um método buscarPorId(int) que retorna uma Carteira")
    void testBuscarPorIdMethodExists() {
        try {
            Method buscarPorIdMethod = carteiraServiceClass.getDeclaredMethod("buscarPorId", int.class);

            assertEquals(Carteira.class, buscarPorIdMethod.getReturnType(),
                    "Dado que o método buscarPorId é usado para recuperar uma carteira pelo ID, então ele deve retornar um objeto do tipo Carteira");

            assertTrue(Modifier.isPublic(buscarPorIdMethod.getModifiers()),
                    "Dado que o método buscarPorId é acessível externamente, então ele deve ser público");

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorId(int)' não foi encontrado na classe CarteiraService. Verifique se o método está corretamente definido.");
        }
    }

    @Test
    @DisplayName("Deve ter um atributo carteiraRepository do tipo CarteiraRepository, privado e final")
    void testHasCarteiraRepositoryField() {
        try {
            Field repositoryField = carteiraServiceClass.getDeclaredField("carteiraRepository");

            assertEquals(CarteiraRepository.class, repositoryField.getType(),
                    "Dado que CarteiraService depende de CarteiraRepository, então ele deve ter um campo do tipo CarteiraRepository");

            assertTrue(Modifier.isPrivate(repositoryField.getModifiers()),
                    "Dado que carteiraRepository deve ser encapsulado, então ele deve ser privado");

            assertTrue(Modifier.isFinal(repositoryField.getModifiers()),
                    "Dado que carteiraRepository é injetado e não deve ser alterado, então ele deve ser final");

        } catch (NoSuchFieldException e) {
            fail("O campo 'carteiraRepository' não foi encontrado na classe CarteiraService. Verifique se o campo está corretamente definido.");
        }
    }
}
