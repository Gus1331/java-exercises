package school.sptech.ex_many_to_one_dto1.atividade;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@ActiveProfiles("test")
@DisplayName("6. [VALIDACÕES] - Testes de Validação do AtivoRequestDto no AtivoController (POST)")
class AtivoControllerValidationTest {

    @Autowired
    private MockMvc mockMvc;

    private void verificarCamposNosErros(MethodArgumentNotValidException ex, List<String> camposEsperados) {
        assertNotNull(ex);

        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();

        assertEquals(camposEsperados.size(), fieldErrors.size());

        List<String> camposNosErros = fieldErrors.stream()
                .map(FieldError::getField)
                .toList();

        camposEsperados.forEach(campo -> assertTrue(camposNosErros.contains(campo), "Campo " + campo + " não encontrado entre os erros"));
    }

    @Test
    @DisplayName("Deve retornar erro para campos 'nome' e 'tipo' inválidos com 'valorAtual' e 'carteiraId' corretos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaCamposNomeETipoInvalidos() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "",
                    "tipo": "",
                    "valorAtual": 200.0,
                    "carteiraId": 1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("nome", "tipo");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'valorAtual' negativo e 'nome' vazio com 'tipo' e 'carteiraId' corretos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaValorAtualNegativoENomeVazio() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "",
                    "tipo": "Ação",
                    "valorAtual": -200.0,
                    "carteiraId": 1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("nome", "valorAtual");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'carteiraId' inválido e 'tipo' vazio com 'nome' e 'valorAtual' corretos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaCarteiraIdInvalidoETipoVazio() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "Ação XPTO",
                    "tipo": "",
                    "valorAtual": 200.0,
                    "carteiraId": 0
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("tipo", "carteiraId");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'nome' e 'carteiraId' inválidos com 'tipo' e 'valorAtual' corretos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaNomeECarteiraIdInvalidos() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "",
                    "tipo": "Ação",
                    "valorAtual": 200.0,
                    "carteiraId": -1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("nome", "carteiraId");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'tipo' vazio e 'valorAtual' negativo com 'nome' e 'carteiraId' corretos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaTipoEValorAtualInvalidos() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "Ação XPTO",
                    "tipo": "",
                    "valorAtual": -200.0,
                    "carteiraId": 1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("tipo", "valorAtual");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }

    @Test
    @DisplayName("Deve retornar erro para todos os campos inválidos")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarErroParaTodosOsCamposInvalidos() throws Exception {
        String ativoInvalidoJson = """
                {
                    "nome": "",
                    "tipo": "",
                    "valorAtual": -200.0,
                    "carteiraId": -1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(ativoInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    List<String> camposEsperados = List.of("nome", "tipo", "valorAtual", "carteiraId");
                    verificarCamposNosErros(ex, camposEsperados);
                });
    }
}
