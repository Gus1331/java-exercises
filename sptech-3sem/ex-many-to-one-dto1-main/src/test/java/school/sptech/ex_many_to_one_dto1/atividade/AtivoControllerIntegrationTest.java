package school.sptech.ex_many_to_one_dto1.atividade;

import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.closeTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@ActiveProfiles("test")
@DisplayName("7. [CONTROLLER] - Comportamento dos endpoints da AtivoController")
class AtivoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve cadastrar um novo ativo com sucesso e verificar o estado esperado do banco")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    @ExpectedDataSet(value = "datasets/ativos-apos-cadastro.json", ignoreCols = "id")
    void deveCadastrarAtivoComSucesso() throws Exception {
        String novoAtivoJson = """
                {
                    "nome": "Ação XPTO",
                    "tipo": "Ação",
                    "valorAtual": 200.0,
                    "carteiraId": 1
                }
                """;

        mockMvc.perform(post("/ativos")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novoAtivoJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Ação XPTO"))
                .andExpect(jsonPath("$.tipo").value("Ação"))
                .andExpect(jsonPath("$.valorAtual").value(200.0));
    }

    @Test
    @DisplayName("Deve retornar todos os ativos cadastrados com sucesso")
    @DataSet(value = "datasets/ativos.json", cleanBefore = true)
    void deveBuscarTodosOsAtivos() throws Exception {
        mockMvc.perform(get("/ativos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nome").value("Ação XPTO"))
                .andExpect(jsonPath("$[1].nome").value("Fundo Imobiliário ABC"));
    }

    @Test
    @DisplayName("Deve retornar 204 quando não houver ativos cadastrados")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarNoContentQuandoNaoHouverAtivos() throws Exception {
        mockMvc.perform(get("/ativos")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve buscar um ativo pelo ID com sucesso")
    @DataSet(value = "datasets/ativos.json", cleanBefore = true)
    void deveBuscarAtivoPorIdComSucesso() throws Exception {
        mockMvc.perform(get("/ativos/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Ação XPTO"))
                .andExpect(jsonPath("$.tipo").value("Ação"))
                .andExpect(jsonPath("$.valorAtual").value(100.0));
    }

    @Test
    @DisplayName("Deve retornar 404 ao buscar ativo por ID inexistente")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarNotFoundAoBuscarAtivoPorIdInexistente() throws Exception {
        mockMvc.perform(get("/ativos/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Deve deletar um ativo por ID com sucesso e verificar o estado do banco")
    @DataSet(value = "datasets/ativos.json", cleanBefore = true)
    @ExpectedDataSet(value = "datasets/ativos-apos-delecao.json", ignoreCols = "id")
    void deveDeletarAtivoPorIdComSucesso() throws Exception {
        mockMvc.perform(delete("/ativos/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve retornar 404 ao tentar deletar um ativo por ID inexistente")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarNotFoundAoDeletarAtivoInexistente() throws Exception {
        mockMvc.perform(delete("/ativos/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Deve retornar os ativos de uma carteira ao buscar por nome do investidor com sucesso")
    @DataSet(value = "datasets/ativos-por-carteira.json", cleanBefore = true)
    void deveBuscarAtivosPorCarteiraNomeComSucesso() throws Exception {
        mockMvc.perform(get("/ativos/carteiras")
                        .param("nomeInvestidor", "João Silva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nome").value("Ação XPTO"))
                .andExpect(jsonPath("$[0].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[0].carteira.investidor").value("João Silva"))
                .andExpect(jsonPath("$[1].nome").value("Fundo Imobiliário ABC"))
                .andExpect(jsonPath("$[1].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[1].carteira.investidor").value("João Silva"));
    }

    @Test
    @DisplayName("Deve retornar os ativos de uma carteira ao buscar por nome (ignorando letras maiúsculas e minúsculas) do investidor com sucesso")
    @DataSet(value = "datasets/ativos-por-carteira.json", cleanBefore = true)
    void deveBuscarAtivosPorCarteiraNomeIgnorandoCaseComSucesso() throws Exception {
        mockMvc.perform(get("/ativos/carteiras")
                        .param("nomeInvestidor", "joão silva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nome").value("Ação XPTO"))
                .andExpect(jsonPath("$[0].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[0].carteira.investidor").value("João Silva"))
                .andExpect(jsonPath("$[1].nome").value("Fundo Imobiliário ABC"))
                .andExpect(jsonPath("$[1].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[1].carteira.investidor").value("João Silva"));
    }

    @Test
    @DisplayName("Deve retornar 204 quando não houver ativos para o investidor")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarNoContentQuandoNaoHouverAtivosPorCarteira() throws Exception {
        mockMvc.perform(get("/ativos/carteiras")
                        .param("nomeInvestidor", "Investidor Inexistente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve retornar os ativos de uma carteira ao buscar por nome (nome parcial) do investidor com sucesso")
    @DataSet(value = "datasets/ativos-por-carteira.json", cleanBefore = true)
    void deveBuscarAtivosPorCarteiraNomeParcialComSucesso() throws Exception {
        mockMvc.perform(get("/ativos/carteiras")
                        .param("nomeInvestidor", "Silva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nome").value("Ação XPTO"))
                .andExpect(jsonPath("$[0].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[0].carteira.investidor").value("João Silva"))
                .andExpect(jsonPath("$[1].nome").value("Fundo Imobiliário ABC"))
                .andExpect(jsonPath("$[1].carteira.nome").value("Carteira de Investimentos A"))
                .andExpect(jsonPath("$[1].carteira.investidor").value("João Silva"));
    }

    @Test
    @DisplayName("Deve retornar a média do valor dos ativos ao buscar por nome do investidor com sucesso")
    @DataSet(value = "datasets/ativos-por-carteira.json", cleanBefore = true)
    void deveBuscarMediaAtivosPorCarteiraNomeComSucesso() throws Exception {
        mockMvc.perform(get("/ativos/carteiras/media")
                        .param("nomeInvestidor", "João Silva")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$").value(closeTo(150.25, 1.0)));
    }


    @Test
    @DisplayName("Deve retornar 404 quando não houver ativos ao buscar a média por nome do investidor")
    @DataSet(value = "datasets/ativos-empty.json", cleanBefore = true)
    void deveRetornarNoContentQuandoNaoHouverAtivosParaCalcularMedia() throws Exception {
        mockMvc.perform(get("/ativos/carteiras/media")
                        .param("nomeInvestidor", "Investidor Inexistente")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }
}
