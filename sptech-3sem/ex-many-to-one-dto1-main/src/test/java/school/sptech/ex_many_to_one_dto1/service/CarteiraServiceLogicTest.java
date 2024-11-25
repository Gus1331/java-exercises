package school.sptech.ex_many_to_one_dto1.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.exception.NaoEncontradoException;
import school.sptech.ex_many_to_one_dto1.repository.CarteiraRepository;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("[OK] - Especificação de comportamento da lógica de CarteiraService")
class CarteiraServiceLogicTest {

    @Mock
    private CarteiraRepository carteiraRepository;

    @InjectMocks
    private CarteiraService carteiraService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve salvar a carteira quando o método salvar(Carteira) for chamado com sucesso")
    void deveSalvarCarteiraComSucesso() {
        Carteira carteira = Carteira.builder()
                .nome("Carteira Agressiva")
                .investidor("João")
                .build();

        try {
            Method salvarMethod = CarteiraService.class.getDeclaredMethod("salvar", Carteira.class);

            when(carteiraRepository.save(carteira)).thenReturn(carteira);

            Carteira result = (Carteira) salvarMethod.invoke(carteiraService, carteira);

            assertNotNull(result);
            assertEquals("Carteira Agressiva", result.getNome(), "A carteira deve ser salva com o nome correto");
            assertEquals("João", result.getInvestidor(), "O investidor deve ser salvo corretamente");

            verify(carteiraRepository, times(1)).save(carteira);

        } catch (NoSuchMethodException e) {
            fail("O método 'salvar(Carteira)' não foi encontrado na classe CarteiraService. Não é possível testar a lógica.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'salvar(Carteira)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve retornar a lista de todas as carteiras quando o método buscarTodos() for chamado")
    void deveBuscarTodasAsCarteiras() {
        try {
            Method buscarTodosMethod = CarteiraService.class.getDeclaredMethod("buscarTodos");

            List<Carteira> carteirasMock = List.of(
                    Carteira.builder().id(1).nome("Carteira Conservadora").investidor("Maria").build(),
                    Carteira.builder().id(2).nome("Carteira Moderada").investidor("Pedro").build()
            );

            when(carteiraRepository.findAll()).thenReturn(carteirasMock);

            List<Carteira> result = (List<Carteira>) buscarTodosMethod.invoke(carteiraService);

            assertEquals(2, result.size(), "Deve retornar duas carteiras");
            assertEquals("Carteira Conservadora", result.get(0).getNome(), "O nome da primeira carteira deve ser 'Carteira Conservadora'");
            assertEquals("Maria", result.get(0).getInvestidor(), "O investidor da primeira carteira deve ser 'Maria'");

            verify(carteiraRepository, times(1)).findAll();

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarTodos()' não foi encontrado na classe CarteiraService. Não é possível testar a lógica.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarTodos()': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve buscar a carteira por ID quando o método buscarPorId(int) for chamado com sucesso")
    void deveBuscarCarteiraPorIdComSucesso() {
        try {
            Method buscarPorIdMethod = CarteiraService.class.getDeclaredMethod("buscarPorId", int.class);

            Carteira carteiraMock = Carteira.builder()
                    .id(1)
                    .nome("Carteira Conservadora")
                    .investidor("Maria")
                    .build();

            when(carteiraRepository.findById(1)).thenReturn(Optional.of(carteiraMock));

            Carteira result = (Carteira) buscarPorIdMethod.invoke(carteiraService, 1);

            assertNotNull(result);
            assertEquals("Carteira Conservadora", result.getNome(), "A carteira retornada deve ter o nome 'Carteira Conservadora'");
            assertEquals("Maria", result.getInvestidor(), "O investidor retornado deve ser 'Maria'");

            verify(carteiraRepository, times(1)).findById(1);

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorId(int)' não foi encontrado na classe CarteiraService. Não é possível testar a lógica.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve lançar exceção NaoEncontradoException ao buscar carteira por ID inexistente")
    void deveLancarExcecaoAoBuscarCarteiraPorIdInexistente() {
        try {
            Method buscarPorIdMethod = CarteiraService.class.getDeclaredMethod("buscarPorId", int.class);

            when(carteiraRepository.findById(999)).thenReturn(Optional.empty());

            Exception exception = assertThrows(Exception.class, () -> {
                buscarPorIdMethod.invoke(carteiraService, 999);
            });

            assertTrue(exception.getCause() instanceof NaoEncontradoException, "Deve lançar NaoEncontradoException quando a carteira não for encontrada");
            assertEquals("Carteira de id: 999 não encontrada", exception.getCause().getMessage());

            verify(carteiraRepository, times(1)).findById(999);

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorId(int)' não foi encontrado na classe CarteiraService. Não é possível testar a lógica.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }
}

