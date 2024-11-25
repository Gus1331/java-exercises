package school.sptech.ex_many_to_one_dto1.atividade;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import school.sptech.ex_many_to_one_dto1.entity.Ativo;
import school.sptech.ex_many_to_one_dto1.entity.Carteira;
import school.sptech.ex_many_to_one_dto1.exception.NaoEncontradoException;
import school.sptech.ex_many_to_one_dto1.repository.AtivoRepository;
import school.sptech.ex_many_to_one_dto1.service.AtivoService;
import school.sptech.ex_many_to_one_dto1.service.CarteiraService;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@DisplayName("3. [LÓGICA] - AtivoService")
class AtivoServiceLogicTest {

    @Mock
    private AtivoRepository ativoRepository;

    @InjectMocks
    private AtivoService ativoService;

    @Mock
    private CarteiraService carteiraService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve salvar o ativo quando o método salvar(Ativo, int carteiraId) for chamado com sucesso")
    void deveSalvarAtivoComSucesso() {
        try {
            // Usar o construtor padrão da classe Ativo e setters via reflection
            Ativo ativo = Ativo.class.getDeclaredConstructor().newInstance();
            Method setNome = Ativo.class.getDeclaredMethod("setNome", String.class);
            Method setTipo = Ativo.class.getDeclaredMethod("setTipo", String.class);
            Method setValorAtual = Ativo.class.getDeclaredMethod("setValorAtual", Double.class);
            setNome.invoke(ativo, "Ação XYZ");
            setTipo.invoke(ativo, "Ação");
            setValorAtual.invoke(ativo, 100.0);

            Carteira carteira = Carteira.builder()
                    .id(1)
                    .nome("Carteira Agressiva")
                    .build();

            int carteiraId = 1;

            when(ativoRepository.save(any(Ativo.class))).thenAnswer(invocation -> {
                Ativo ativoSalvo = invocation.getArgument(0);
                Method setCarteira = Ativo.class.getDeclaredMethod("setCarteira", Carteira.class);
                setCarteira.invoke(ativoSalvo, carteira);
                return ativoSalvo;
            });

            Method salvarMethod = AtivoService.class.getDeclaredMethod("salvar", Ativo.class, int.class);
            Ativo result = (Ativo) salvarMethod.invoke(ativoService, ativo, carteiraId);

            // Verificar os atributos do ativo salvo via reflection
            Method getNome = Ativo.class.getDeclaredMethod("getNome");
            Method getTipo = Ativo.class.getDeclaredMethod("getTipo");
            Method getValorAtual = Ativo.class.getDeclaredMethod("getValorAtual");
            Method getCarteira = Ativo.class.getDeclaredMethod("getCarteira");

            assertNotNull(result, "O ativo salvo não deve ser nulo");
            assertEquals("Ação XYZ", getNome.invoke(result), "O nome do ativo salvo deve ser 'Ação XYZ'");
            assertEquals("Ação", getTipo.invoke(result), "O tipo do ativo salvo deve ser 'Ação'");
            assertEquals(100.0, getValorAtual.invoke(result), "O valor atual do ativo salvo deve ser 100.0");
            assertNotNull(getCarteira.invoke(result), "O ativo salvo deve estar associado a uma carteira");

            verify(ativoRepository, times(1)).save(ativo);
            verify(carteiraService, times(1)).buscarPorId(carteiraId);

        } catch (Exception e) {
            fail("Erro ao executar o método 'salvar(Ativo, int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve retornar a lista de todos os ativos quando o método buscarTodos() for chamado")
    void deveBuscarTodosOsAtivos() {
        try {
            Method buscarTodosMethod = AtivoService.class.getDeclaredMethod("buscarTodos");

            Carteira carteiraMock = Carteira.class.getDeclaredConstructor().newInstance();
            Method setCarteiraId = Carteira.class.getDeclaredMethod("setId", Integer.class);
            Method setCarteiraNome = Carteira.class.getDeclaredMethod("setNome", String.class);
            setCarteiraId.invoke(carteiraMock, 1);
            setCarteiraNome.invoke(carteiraMock, "Carteira Agressiva");

            Ativo ativo1 = Ativo.class.getDeclaredConstructor().newInstance();
            Ativo ativo2 = Ativo.class.getDeclaredConstructor().newInstance();
            Method setId = Ativo.class.getDeclaredMethod("setId", Integer.class);
            Method setNome = Ativo.class.getDeclaredMethod("setNome", String.class);
            Method setTipo = Ativo.class.getDeclaredMethod("setTipo", String.class);
            Method setValorAtual = Ativo.class.getDeclaredMethod("setValorAtual", Double.class);
            Method setCarteira = Ativo.class.getDeclaredMethod("setCarteira", Carteira.class);

            setId.invoke(ativo1, 1);
            setNome.invoke(ativo1, "Ação ABC");
            setTipo.invoke(ativo1, "Ação");
            setValorAtual.invoke(ativo1, 50.0);
            setCarteira.invoke(ativo1, carteiraMock);

            setId.invoke(ativo2, 2);
            setNome.invoke(ativo2, "Fundo Imobiliário XYZ");
            setTipo.invoke(ativo2, "Fundo Imobiliário");
            setValorAtual.invoke(ativo2, 150.0);
            setCarteira.invoke(ativo2, carteiraMock);

            List<Ativo> ativosMock = List.of(ativo1, ativo2);
            when(ativoRepository.findAll()).thenReturn(ativosMock);

            List<Ativo> result = (List<Ativo>) buscarTodosMethod.invoke(ativoService);

            Method getNome = Ativo.class.getDeclaredMethod("getNome");
            Method getCarteira = Ativo.class.getDeclaredMethod("getCarteira");
            Method getCarteiraNome = Carteira.class.getDeclaredMethod("getNome");

            assertEquals(2, result.size(), "Deve retornar dois ativos");

            assertEquals("Ação ABC", getNome.invoke(result.get(0)), "O nome do primeiro ativo deve ser 'Ação ABC'");
            Object carteira1 = getCarteira.invoke(result.get(0));
            assertNotNull(carteira1, "O primeiro ativo deve estar associado a uma carteira");
            assertEquals("Carteira Agressiva", getCarteiraNome.invoke(carteira1), "O nome da carteira do primeiro ativo deve ser 'Carteira Agressiva'");

            assertEquals("Fundo Imobiliário XYZ", getNome.invoke(result.get(1)), "O nome do segundo ativo deve ser 'Fundo Imobiliário XYZ'");
            Object carteira2 = getCarteira.invoke(result.get(1));
            assertNotNull(carteira2, "O segundo ativo deve estar associado a uma carteira");
            assertEquals("Carteira Agressiva", getCarteiraNome.invoke(carteira2), "O nome da carteira do segundo ativo deve ser 'Carteira Agressiva'");

            verify(ativoRepository, times(1)).findAll();
        } catch (NoSuchMethodException e) {
            fail("O método 'buscarTodos()' não foi encontrado na classe AtivoService.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarTodos()': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve buscar o ativo por ID quando o método buscarPorId(int) for chamado com sucesso")
    void deveBuscarAtivoPorIdComSucesso() {
        try {
            Method buscarPorIdMethod = AtivoService.class.getDeclaredMethod("buscarPorId", int.class);

            Carteira carteiraMock = Carteira.builder().id(1).nome("Carteira Agressiva").build();

            // Usando o construtor padrão e setters via reflection
            Ativo ativoMock = Ativo.class.getDeclaredConstructor().newInstance();

            Method setId = Ativo.class.getDeclaredMethod("setId", Integer.class);
            Method setNome = Ativo.class.getDeclaredMethod("setNome", String.class);
            Method setTipo = Ativo.class.getDeclaredMethod("setTipo", String.class);
            Method setValorAtual = Ativo.class.getDeclaredMethod("setValorAtual", Double.class);
            Method setCarteira = Ativo.class.getDeclaredMethod("setCarteira", Carteira.class);

            setId.invoke(ativoMock, 1);
            setNome.invoke(ativoMock, "Ação ABC");
            setTipo.invoke(ativoMock, "Ação");
            setValorAtual.invoke(ativoMock, 50.0);
            setCarteira.invoke(ativoMock, carteiraMock);

            when(ativoRepository.findById(1)).thenReturn(Optional.of(ativoMock));

            Ativo result = (Ativo) buscarPorIdMethod.invoke(ativoService, 1);

            // Using getter methods for validation
            Method getNome = Ativo.class.getDeclaredMethod("getNome");
            Method getValorAtual = Ativo.class.getDeclaredMethod("getValorAtual");
            Method getCarteira = Ativo.class.getDeclaredMethod("getCarteira");

            assertNotNull(result);
            assertEquals("Ação ABC", getNome.invoke(result), "O nome do ativo retornado deve ser 'Ação ABC'");
            assertEquals(50.0, getValorAtual.invoke(result), "O valor atual do ativo retornado deve ser 50.0");
            assertNotNull(getCarteira.invoke(result), "O ativo retornado deve estar associado a uma carteira");

            verify(ativoRepository, times(1)).findById(1);

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorId(int)' não foi encontrado na classe AtivoService.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve lançar exceção NaoEncontradoException ao buscar ativo por ID inexistente")
    void deveLancarExcecaoAoBuscarAtivoPorIdInexistente() {
        try {
            Method buscarPorIdMethod = AtivoService.class.getDeclaredMethod("buscarPorId", int.class);

            when(ativoRepository.findById(999)).thenReturn(Optional.empty());

            Exception exception = assertThrows(Exception.class, () -> {
                buscarPorIdMethod.invoke(ativoService, 999);
            });

            assertTrue(exception.getCause() instanceof NaoEncontradoException, "Deve lançar NaoEncontradoException quando o ativo não for encontrado");
            assertEquals("Ativo de id: 999 não encontrado", exception.getCause().getMessage());

            verify(ativoRepository, times(1)).findById(999);

        } catch (NoSuchMethodException e) {
            fail("O método 'buscarPorId(int)' não foi encontrado na classe AtivoService.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve deletar o ativo quando o método deletarPorId(int) for chamado com sucesso")
    void deveDeletarAtivoComSucesso() {
        try {
            Method deletarPorIdMethod = AtivoService.class.getDeclaredMethod("deletarPorId", int.class);

            when(ativoRepository.existsById(1)).thenReturn(true);

            deletarPorIdMethod.invoke(ativoService, 1);

            verify(ativoRepository, times(1)).deleteById(1);

        } catch (NoSuchMethodException e) {
            fail("O método 'deletarPorId(int)' não foi encontrado na classe AtivoService.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'deletarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve lançar exceção NaoEncontradoException ao deletar ativo inexistente")
    void deveLancarExcecaoAoDeletarAtivoInexistente() {
        try {
            Method deletarPorIdMethod = AtivoService.class.getDeclaredMethod("deletarPorId", int.class);

            when(ativoRepository.existsById(999)).thenReturn(false);

            Exception exception = assertThrows(Exception.class, () -> {
                deletarPorIdMethod.invoke(ativoService, 999);
            });

            assertInstanceOf(NaoEncontradoException.class, exception.getCause(), "Deve lançar NaoEncontradoException quando o ativo não for encontrado para deleção");
            assertEquals("Ativo de id: 999 não encontrado", exception.getCause().getMessage());

            verify(ativoRepository, times(1)).existsById(999);

        } catch (NoSuchMethodException e) {
            fail("O método 'deletarPorId(int)' não foi encontrado na classe AtivoService.");
        } catch (Exception e) {
            fail("Erro ao executar o método 'deletarPorId(int)': " + e.getMessage());
        }
    }
}
