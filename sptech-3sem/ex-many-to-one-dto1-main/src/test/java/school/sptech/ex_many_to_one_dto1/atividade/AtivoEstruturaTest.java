package school.sptech.ex_many_to_one_dto1.atividade;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("1. [ESTRUTURA] - Teste de Estrutura da Classe Ativo")
class AtivoEstruturaTest {

    @Test
    @DisplayName("Deve garantir que a classe Ativo esteja anotada com @Entity")
    void deveGarantirAnotacaoEntity() {
        assertTrue(Ativo.class.isAnnotationPresent(Entity.class),
                "A classe Ativo deve estar anotada com @Entity.");
    }

    @Test
    @DisplayName("Deve garantir que a classe Ativo tenha os construtores @AllArgsConstructor e @NoArgsConstructor (lombok opcionais)")
    void deveGarantirConstrutores() {
        Constructor<?>[] constructors = Ativo.class.getDeclaredConstructors();
        boolean temNoArgsConstructor = Arrays.stream(constructors)
                .anyMatch(constructor -> constructor.getParameterCount() == 0);
        boolean temAllArgsConstructor = Arrays.stream(constructors)
                .anyMatch(constructor -> constructor.getParameterCount() > 0);

        assertTrue(temNoArgsConstructor, "A classe Ativo deve ter um construtor sem argumentos (@NoArgsConstructor).");
        assertTrue(temAllArgsConstructor, "A classe Ativo deve ter um construtor com todos os argumentos (@AllArgsConstructor).");
    }

    @Test
    @DisplayName("Deve garantir que a classe Ativo tenha os atributos: id, nome, tipo, valorAtual e carteira")
    void deveGarantirAtributosPresentes() {
        try {
            Ativo.class.getDeclaredField("id");
            Ativo.class.getDeclaredField("nome");
            Ativo.class.getDeclaredField("tipo");
            Ativo.class.getDeclaredField("valorAtual");
            Ativo.class.getDeclaredField("carteira");
        } catch (NoSuchFieldException e) {
            fail("A classe Ativo deve conter os atributos id, nome, tipo, valorAtual e carteira.");
        }
    }

    @Test
    @DisplayName("Deve garantir que a classe Ativo tenha métodos getter e setter para todos os atributos")
    void deveGarantirGettersSetters() {
        try {
            Method getId = Ativo.class.getMethod("getId");
            Method setId = Ativo.class.getMethod("setId", Integer.class);

            Method getNome = Ativo.class.getMethod("getNome");
            Method setNome = Ativo.class.getMethod("setNome", String.class);

            Method getTipo = Ativo.class.getMethod("getTipo");
            Method setTipo = Ativo.class.getMethod("setTipo", String.class);

            Method getValorAtual = Ativo.class.getMethod("getValorAtual");
            Method setValorAtual = Ativo.class.getMethod("setValorAtual", Double.class);

            Method getCarteira = Ativo.class.getMethod("getCarteira");
            Method setCarteira = Ativo.class.getMethod("setCarteira", Carteira.class);

            assertNotNull(getId, "O método getId() deve existir.");
            assertNotNull(setId, "O método setId() deve existir.");

            assertNotNull(getNome, "O método getNome() deve existir.");
            assertNotNull(setNome, "O método setNome() deve existir.");

            assertNotNull(getTipo, "O método getTipo() deve existir.");
            assertNotNull(setTipo, "O método setTipo() deve existir.");

            assertNotNull(getValorAtual, "O método getValorAtual() deve existir.");
            assertNotNull(setValorAtual, "O método setValorAtual() deve existir.");

            assertNotNull(getCarteira, "O método getCarteira() deve existir.");
            assertNotNull(setCarteira, "O método setCarteira() deve existir.");

        } catch (NoSuchMethodException e) {
            fail("A classe Ativo deve conter os métodos getter e setter para todos os atributos.");
        }
    }

    @Test
    @DisplayName("Deve garantir que o campo 'id' esteja anotado com @Id e @GeneratedValue(strategy = GenerationType.IDENTITY)")
    void deveGarantirAnotacoesIdEGeneratedValue() {
        try {
            Field idField = Ativo.class.getDeclaredField("id");

            // Verifica se o campo 'id' tem a anotação @Id
            assertTrue(idField.isAnnotationPresent(Id.class),
                    "O campo 'id' deve estar anotado com @Id.");

            // Verifica se o campo 'id' tem a anotação @GeneratedValue com a estratégia GenerationType.IDENTITY
            GeneratedValue generatedValue = idField.getAnnotation(GeneratedValue.class);
            assertNotNull(generatedValue, "O campo 'id' deve estar anotado com @GeneratedValue.");
            assertEquals(GenerationType.IDENTITY, generatedValue.strategy(),
                    "A estratégia de geração de valor para o campo 'id' deve ser GenerationType.IDENTITY.");

        } catch (NoSuchFieldException e) {
            fail("O atributo 'id' deve existir na classe Ativo.");
        }
    }

    @Test
    @DisplayName("Deve garantir que o atributo 'carteira' tenha uma anotação de relacionamento")
    void deveGarantirAnotacaoDeRelacionamentoEmCarteira() {
        try {
            Field carteiraField = Ativo.class.getDeclaredField("carteira");
            assertTrue(carteiraField.isAnnotationPresent(ManyToOne.class),
                    "O campo 'carteira' deve ter uma anotação de relacionamento.");
        } catch (NoSuchFieldException e) {
            fail("O atributo 'carteira' deve existir na classe Ativo.");
        }
    }
}
