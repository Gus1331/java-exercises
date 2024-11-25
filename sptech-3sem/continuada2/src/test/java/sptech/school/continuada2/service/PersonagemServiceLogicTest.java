package sptech.school.continuada2.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.opentest4j.AssertionFailedError;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import sptech.school.continuada2.entity.Personagem;
import sptech.school.continuada2.entity.Regiao;
import sptech.school.continuada2.exception.NaoEncontradoException;
import sptech.school.continuada2.repository.PersonagemRepository;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertInstanceOf;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@DisplayName("3. [LÓGICA] - Lógica da classe PersonagemService")
public class PersonagemServiceLogicTest {

    @Mock
    private PersonagemRepository personagemRepository;

    @Mock
    private RegiaoService regiaoService;

    @InjectMocks
    private PersonagemService personagemService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Deve chamar o método do personagemRepository ao buscar um personagem por ID")
    void deveBuscarPersonagemPorIdComSucesso() {
        try {
            Regiao regiao = Regiao.builder()
                    .id(1)
                    .nome("Região 1")
                    .sigla("R1")
                    .descricao("Descrição da Região 1")
                    .build();

            Personagem personagem = Personagem.builder()
                    .id(1)
                    .nome("Personagem 1")
                    .ultimate("Ultimate 1")
                    .funcaoPrincipal("Função 1")
                    .build();

            Method setRegiao = personagem.getClass().getMethod("setRegiao", Regiao.class);
            setRegiao.invoke(personagem, regiao);

            when(personagemRepository.findById(1)).thenReturn(Optional.of(personagem));

            Personagem result = personagemService.buscarPorId(1);

            Method getRegiao = Personagem.class.getDeclaredMethod("getRegiao");

            assertNotNull(result, "O método buscarPorId deve retornar um objeto Personagem");
            assertEquals(1, personagem.getId(), "O método buscarPorId deve retornar um objeto Personagem com o ID correto");
            assertEquals("Personagem 1", personagem.getNome(), "O método buscarPorId deve retornar um objeto Personagem com o nome correto");
            assertEquals("Ultimate 1", personagem.getUltimate(), "O método buscarPorId deve retornar um objeto Personagem com o ultimate correto");
            assertEquals("Função 1", personagem.getFuncaoPrincipal(), "O método buscarPorId deve retornar um objeto Personagem com a função principal correta");
            assertNotNull(getRegiao.invoke(result), "O método buscarPorId deve retornar um objeto Personagem com a região preenchida");

            verify(personagemRepository, times(1)).findById(1);
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve lançar uma exceção ao buscar um personagem por ID inexistente")
    void deveLancarExcecaoAoBuscarPersonagemPorIdInexistente() {
        when(personagemRepository.findById(1)).thenReturn(Optional.empty());

        try {
            Exception exception = assertThrows(Exception.class,
                    () -> personagemService.buscarPorId(1),
                    "Deveria ter lançado uma exceção NaoEncontradoException ao buscar um personagem por ID inexistente");

            verify(personagemRepository, times(1)).findById(1);
            assertInstanceOf(NaoEncontradoException.class, exception, "Deveria ter lançado uma exceção NaoEncontradoException ao buscar um personagem por ID inexistente");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorId(int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve chamar o método do personagemRepository ao cadastrar um personagem")
    void deveCadastrarPersonagemComSucesso() {
        try {
            Regiao regiao = Regiao.builder()
                    .id(1)
                    .nome("Região 1")
                    .sigla("R1")
                    .descricao("Descrição da Região 1")
                    .build();

            Personagem personagem = Personagem.builder()
                    .id(1)
                    .nome("Personagem 1")
                    .ultimate("Ultimate 1")
                    .funcaoPrincipal("Função 1")
                    .build();

            Method setRegiao = Personagem.class.getDeclaredMethod("setRegiao", Regiao.class);
            setRegiao.invoke(personagem, regiao);

            when(regiaoService.buscarPorId(1)).thenReturn(regiao);
            when(personagemRepository.save(personagem)).thenReturn(personagem);

            Personagem result = personagemService.cadastrar(personagem, 1);
            Method getRegiao = Personagem.class.getDeclaredMethod("getRegiao");

            assertNotNull(result, "O método cadastrar deve retornar um objeto Personagem");
            assertEquals(1, personagem.getId(), "O método cadastrar deve retornar um objeto Personagem com o ID correto");
            assertEquals("Personagem 1", personagem.getNome(), "O método cadastrar deve retornar um objeto Personagem com o nome correto");
            assertEquals("Ultimate 1", personagem.getUltimate(), "O método cadastrar deve retornar um objeto Personagem com o ultimate correto");
            assertEquals("Função 1", personagem.getFuncaoPrincipal(), "O método cadastrar deve retornar um objeto Personagem com a função principal correta");
            assertNotNull(getRegiao.invoke(result), "O Personagem salvo deve ter a região preenchida");

            verify(regiaoService, times(1)).buscarPorId(1);
            verify(personagemRepository, times(1)).save(personagem);
        } catch (Exception e) {
            fail("Erro ao executar o método 'cadastrar(Personagem, int)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve chamar o método personalizado do personagemRepository ao buscar personagens por nome da região aproximado")
    void deveBuscarPersonagensPorNomeRegiaoAproximado() {
        try {
            List<Personagem> personagens = List.of(
                    Personagem.builder()
                            .id(1)
                            .nome("Personagem 1")
                            .ultimate("Ultimate 1")
                            .funcaoPrincipal("Função 1")
                            .build(),
                    Personagem.builder()
                            .id(2)
                            .nome("Personagem 2")
                            .ultimate("Ultimate 2")
                            .funcaoPrincipal("Função 2")
                            .build()
            );

            Method methodDynamic = PersonagemRepository.class.getDeclaredMethod("findByRegiaoNomeContainingIgnoreCase", String.class);

            when(methodDynamic.invoke(personagemRepository, "re")).thenReturn(personagens);

            List<Personagem> result = personagemService.buscarPorRegiaoNomeAproximado("re");

            assertNotNull(result, "O método buscarPorRegiaoNomeAproximado deve retornar uma lista de Personagem filtrada por nome da região");
            assertEquals(2, result.size(), "O método buscarPorRegiaoNomeAproximado deve retornar uma lista de Personagem com o tamanho correto");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorRegiaoNomeAproximado(String)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve retornar lista vazia ao chamar e não ter personagens com nome da região aproximado")
    void deveRetornarListaVaziaAoBuscarPersonagensPorNomeRegiaoAproximado() {
        try {
            Method methodDynamic = PersonagemRepository.class.getDeclaredMethod("findByRegiaoNomeContainingIgnoreCase", String.class);

            when(methodDynamic.invoke(personagemRepository, "re")).thenReturn(List.of());

            List<Personagem> result = personagemService.buscarPorRegiaoNomeAproximado("re");

            assertTrue(result.isEmpty(), "O método buscarPorRegiaoNomeAproximado deve retornar uma lista de Personagem com o tamanho correto");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorRegiaoNomeAproximado(String)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve chamar o método do personagemRepository ao buscar personagens por função principal e sigla da região")
    void deveBuscarPersonagensPorFuncaoPrincipalESiglaRegiao() {
        try {
            List<Personagem> personagens = List.of(
                    Personagem.builder()
                            .id(1)
                            .nome("Personagem 1")
                            .ultimate("Ultimate 1")
                            .funcaoPrincipal("Função 1")
                            .build(),
                    Personagem.builder()
                            .id(2)
                            .nome("Personagem 2")
                            .ultimate("Ultimate 2")
                            .funcaoPrincipal("Função 2")
                            .build()
            );

            Method methodDynamic = PersonagemRepository.class.getDeclaredMethod("findByFuncaoPrincipalAndRegiaoSigla", String.class, String.class);

            when(methodDynamic.invoke(personagemRepository, "Função 2", "R1")).thenReturn(personagens);

            List<Personagem> result = personagemService.buscarPorfuncaoPrincipalAndRegiaoSigla("Função 2", "R1");

            assertNotNull(result, "O método buscarPorfuncaoPrincipalAndRegiaoSigla deve retornar uma lista de Personagem filtrada por função principal e sigla da região");
            assertEquals(2, result.size(), "O método buscarPorfuncaoPrincipalAndRegiaoSigla deve retornar uma lista de Personagem com o tamanho correto");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorfuncaoPrincipalAndRegiaoSigla(String, String)': " + e.getMessage());
        }
    }

    @Test
    @DisplayName("Deve retornar lista vazia ao chamar e não ter personagens com função principal e sigla da região")
    void deveRetornarListaVaziaAoBuscarPersonagensPorFuncaoPrincipalESiglaRegiao() {
        try {
            Method methodDynamic = PersonagemRepository.class.getDeclaredMethod("findByFuncaoPrincipalAndRegiaoSigla", String.class, String.class);

            when(methodDynamic.invoke(personagemRepository, "Função 2", "R1")).thenReturn(List.of());

            List<Personagem> result = personagemService.buscarPorfuncaoPrincipalAndRegiaoSigla("Função 2", "R1");

            assertTrue(result.isEmpty(), "O método buscarPorfuncaoPrincipalAndRegiaoSigla deve retornar uma lista de Personagem com o tamanho correto");
        } catch (Exception e) {
            fail("Erro ao executar o método 'buscarPorfuncaoPrincipalAndRegiaoSigla(String, String)': " + e.getMessage());
        }
    }
}
