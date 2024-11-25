package school.sptech.ex_many_to_one_dto1.controller;

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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@DBRider
@ActiveProfiles("test")
@DisplayName("[OK] - Especificações de comportamento da API CarteiraController")
class CarteiraControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Deve cadastrar uma nova carteira com sucesso quando os dados forem válidos e o banco deve refletir a criação corretamente")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true) // Limpa a tabela 'carteira' antes do teste
    @ExpectedDataSet(value = "datasets/apenas-carteira-apos-cadastro.json", ignoreCols = "id")
    void deveCadastrarCarteiraComSucesso() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": "Carteira Agressiva",
                    "investidor": "João"
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("Carteira Agressiva"))
                .andExpect(jsonPath("$.investidor").value("João"));
    }


    @Test
    @DisplayName("Deve retornar lista de todas as carteiras cadastradas com sucesso")
    @DataSet(value = "datasets/carteiras.json", cleanBefore = true)
    void deveRetornarTodasAsCarteiras() throws Exception {
        mockMvc.perform(get("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(2))
                .andExpect(jsonPath("$[0].nome").value("Carteira Conservadora"))
                .andExpect(jsonPath("$[1].nome").value("Carteira Moderada"));
    }

    @Test
    @DisplayName("Deve retornar 204 quando não houver carteiras cadastradas")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarNoContentQuandoNaoHouverCarteiras() throws Exception {
        mockMvc.perform(get("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());
    }

    @Test
    @DisplayName("Deve buscar uma carteira específica pelo ID com sucesso")
    @DataSet(value = "datasets/carteiras.json", cleanBefore = true)
    void deveBuscarCarteiraPorIdComSucesso() throws Exception {
        mockMvc.perform(get("/carteiras/{id}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.nome").value("Carteira Conservadora"))
                .andExpect(jsonPath("$.investidor").value("Maria"));
    }

    @Test
    @DisplayName("Deve retornar 404 ao buscar uma carteira inexistente pelo ID")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarNotFoundAoBuscarCarteiraPorIdInexistente() throws Exception {
        mockMvc.perform(get("/carteiras/{id}", 999)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNotFound());
    }

    @Test
    @DisplayName("Deve retornar 400 ao tentar criar uma carteira com nome nulo")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarBadRequestAoCadastrarCarteiraComNomeNulo() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": null,
                    "investidor": "João"
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar 400 ao tentar criar uma carteira com investidor nulo")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarBadRequestAoCadastrarCarteiraComInvestidorNulo() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": "Carteira Agressiva",
                    "investidor": null
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar 400 ao tentar criar uma carteira com nome em branco")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarBadRequestAoCadastrarCarteiraComNomeEmBranco() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": "   ",
                    "investidor": "João"
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar 400 ao tentar criar uma carteira com nome vazio")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarBadRequestAoCadastrarCarteiraComNomeVazio() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": "",
                    "investidor": "João"
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isBadRequest());
    }

    @Test
    @DisplayName("Deve retornar 400 ao tentar criar uma carteira com investidor vazio")
    @DataSet(value = "datasets/carteira-empty.json", cleanBefore = true)
    void deveRetornarBadRequestAoCadastrarCarteiraComInvestidorVazio() throws Exception {
        String novaCarteiraJson = """
                {
                    "nome": "Carteira Agressiva",
                    "investidor": ""
                }
                """;

        mockMvc.perform(post("/carteiras")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(novaCarteiraJson))
                .andExpect(status().isBadRequest());
    }
}
