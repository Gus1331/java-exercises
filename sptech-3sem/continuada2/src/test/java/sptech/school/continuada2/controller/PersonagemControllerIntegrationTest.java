package sptech.school.continuada2.controller;

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
@DisplayName("7. [CONTROLLER] - Comportamento dos endpoints da PersonagemController")
class PersonagemControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve cadastrar um novo personagem com sucesso e verificar o estado esperado do banco")
    @DataSet(value = "datasets/personagens-empty.json", cleanBefore = true)
    @ExpectedDataSet(value = "datasets/personagens-apos-cadastro.json", ignoreCols = "id")
    void deveCadastrarPersonagemComSucesso() throws Exception {
        String novoPersonagemJson = """
                {
                    "nome": "Yasuo",
                    "ultimate": "Last Breath",
                    "funcaoPrincipal": "Dano",
                    "regiaoId": 1
                }
                """;

        mockMvc.perform(post("/personagens")
                        .contentType("application/json")
                        .content(novoPersonagemJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Yasuo"))
                .andExpect(jsonPath("$.ultimate").value("Last Breath"))
                .andExpect(jsonPath("$.funcaoPrincipal").value("Dano"))
                .andExpect(jsonPath("$.regiao.id").value(1))
                .andExpect(jsonPath("$.regiao.nome").value("Ionia"))
                .andExpect(jsonPath("$.regiao.sigla").value("IO"))
                .andExpect(jsonPath("$.regiao.descricao").value("Região de Yasuo"));
    }

    @Test
    @DisplayName("Deve retornar todos os personagens cadastrados com sucesso")
    @DataSet(value = "datasets/personagens.json", cleanBefore = true)
    void deveBuscarTodosOsPersonagens() throws Exception {
        mockMvc.perform(get("/personagens")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].nome").value("Yasuo"))
                .andExpect(jsonPath("$[0].regiao.id").value(1))
                .andExpect(jsonPath("$[0].regiao.nome").value("Ionia"))
                .andExpect(jsonPath("$[1].id").isNumber())
                .andExpect(jsonPath("$[1].nome").value("Riven"))
                .andExpect(jsonPath("$[1].regiao.id").value(2))
                .andExpect(jsonPath("$[1].regiao.nome").value("Demacia"));
    }

    @Test
    @DisplayName("Deve retornar status apropriado quando não houver personagens cadastrados")
    @DataSet(value = "datasets/personagens-empty.json", cleanBefore = true)
    void deveRetornarStatusApropriadoQuandoNaoHouverPersonagens() throws Exception {
        mockMvc.perform(get("/personagens")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve buscar um personagem pelo ID com sucesso")
    @DataSet(value = "datasets/personagens.json", cleanBefore = true)
    void deveBuscarPersonagemPorIdComSucesso() throws Exception {
        mockMvc.perform(get("/personagens/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Yasuo"))
                .andExpect(jsonPath("$.ultimate").value("Last Breath"))
                .andExpect(jsonPath("$.funcaoPrincipal").value("Dano"))
                .andExpect(jsonPath("$.regiao.id").value(1))
                .andExpect(jsonPath("$.regiao.nome").value("Ionia"))
                .andExpect(jsonPath("$.regiao.sigla").value("IO"))
                .andExpect(jsonPath("$.regiao.descricao").value("Região de Yasuo"));
    }

    @Test
    @DisplayName("Deve retornar status apropriado ao buscar personagem por ID inexistente")
    @DataSet(value = "datasets/personagens-empty.json", cleanBefore = true)
    void deveRetornarStatusApropriadoAoBuscarPersonagemPorIdInexistente() throws Exception {
        mockMvc.perform(get("/personagens/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Deve retornar os personagens de uma região com nome parcial e ignorando maiúsculas e minúsculas")
    @DataSet(value = "datasets/personagens.json", cleanBefore = true)
    void deveBuscarPersonagensPorRegiaoNomeComSucesso() throws Exception {
        mockMvc.perform(get("/personagens/filtro/regiao-nome")
                        .param("valorProcurado", "ion")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].nome").value("Yasuo"))
                .andExpect(jsonPath("$[0].regiao.id").value(1))
                .andExpect(jsonPath("$[0].regiao.nome").value("Ionia"));
    }

    @Test
    @DisplayName("Deve retornar status apropriado quando não houver personagens para a região informada")
    @DataSet(value = "datasets/personagens-empty.json", cleanBefore = true)
    void deveRetornarStatusApropriadoQuandoNaoHouverPersonagensPorRegiao() throws Exception {
        mockMvc.perform(get("/personagens/filtro/regiao-nome")
                        .param("valorProcurado", "a")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve retornar personagens com 'funcaoPrincipal' e 'regiao sigla' com valores exatos")
    @DataSet(value = "datasets/personagens.json", cleanBefore = true)
    void deveBuscarPersonagensPorFuncaoPrincipalEIdRegiaoComSucesso() throws Exception {
        mockMvc.perform(get("/personagens/filtro/funcao-regiao")
                        .param("funcao", "Dano")
                        .param("regiao", "IO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(1))
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].nome").value("Yasuo"))
                .andExpect(jsonPath("$[0].ultimate").value("Last Breath"))
                .andExpect(jsonPath("$[0].funcaoPrincipal").value("Dano"))
                .andExpect(jsonPath("$[0].regiao.id").value(1))
                .andExpect(jsonPath("$[0].regiao.nome").value("Ionia"))
                .andExpect(jsonPath("$[0].regiao.sigla").value("IO"))
                .andExpect(jsonPath("$[0].regiao.descricao").value("Região de Yasuo"));
    }

    @Test
    @DisplayName("Deve retornar status apropriado quando não houver personagens com a função e região informadas")
    @DataSet(value = "datasets/personagens-empty.json", cleanBefore = true)
    void deveRetornarStatusApropriadoQuandoNaoHouverPersonagensPorFuncaoERegiao() throws Exception {
        mockMvc.perform(get("/personagens/filtro/funcao-regiao")
                        .param("funcao", "Suporte")
                        .param("regiao", "IO")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }
}