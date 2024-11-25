package sptech.school.continuada2.controller;

import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@ActiveProfiles("test")
@DisplayName("6. [VALIDAÇÕES] - Testes de Validação do PersonagemRequestDto no PersonagemController (POST)")
class PersonagemControllerValidationTest {

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
    @DisplayName("Deve retornar erro para campos 'nome' e 'ultimate' inválidos com 'funcaoPrincipal' e 'regiaoId' corretos")
    void deveRetornarErroParaCamposNomeEUltimateInvalidos() throws Exception {
        String personagemInvalidoJson = """
                {
                    "nome": "",
                    "ultimate": "",
                    "funcaoPrincipal": "Dano",
                    "regiaoId": 1
                }
                """;

        mockMvc.perform(post("/personagens")
                        .contentType("application/json")
                        .content(personagemInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    verificarCamposNosErros(ex, List.of("nome", "ultimate"));
                });
    }

    @Test
    @DisplayName("Deve retornar erro para campos 'funcaoPrincipal' e 'regiaoId' inválidos com 'nome' e 'ultimate' corretos")
    void deveRetornarErroParaCamposFuncaoPrincipalERegiaoIdInvalidos() throws Exception {
        String personagemInvalidoJson = """
                {
                    "nome": "Jett",
                    "ultimate": "Corte de Vento",
                    "funcaoPrincipal": "",
                    "regiaoId": 0
                }
                """;

        mockMvc.perform(post("/personagens")
                        .contentType("application/json")
                        .content(personagemInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    verificarCamposNosErros(ex, List.of("funcaoPrincipal", "regiaoId"));
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'nome' vazio e 'funcaoPrincipal' inválida com 'ultimate' e 'regiaoId' corretos")
    void deveRetornarErroParaNomeVazioEFuncaoPrincipalInvalida() throws Exception {
        String personagemInvalidoJson = """
                {
                    "nome": "",
                    "ultimate": "Corte de Vento",
                    "funcaoPrincipal": "",
                    "regiaoId": 1
                    }
                """;

        mockMvc.perform(post("/personagens")
                        .contentType("application/json")
                        .content(personagemInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    verificarCamposNosErros(ex, List.of("nome", "funcaoPrincipal"));
                });
    }

    @Test
    @DisplayName("Deve retornar erro para 'ultimate' vazio e 'regiaoId' inválido com 'nome' e 'funcaoPrincipal' corretos")
    void deveRetornarErroParaUltimateVazioERegiaoIdInvalido() throws Exception {
        String personagemInvalidoJson = """
                {
                    "nome": "Jett",
                    "ultimate": "",
                    "funcaoPrincipal": "Dano",
                    "regiaoId": 0
                }
                """;

        mockMvc.perform(post("/personagens")
                        .contentType("application/json")
                        .content(personagemInvalidoJson))
                .andExpect(status().isBadRequest())
                .andExpect(result -> {
                    MethodArgumentNotValidException ex = (MethodArgumentNotValidException) result.getResolvedException();
                    verificarCamposNosErros(ex, List.of("ultimate", "regiaoId"));
                });
    }
}