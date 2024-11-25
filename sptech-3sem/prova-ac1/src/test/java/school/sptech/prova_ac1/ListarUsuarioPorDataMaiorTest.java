package school.sptech.prova_ac1;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DBUnit(allowEmptyFields = true, cacheConnection = false, alwaysCleanAfter = true, alwaysCleanBefore = true)
@DisplayName("Dado que o endpoint GET /usuarios/filtro-data seja chamado")
class ListarUsuarioPorDataMaiorTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            value = "/listar/listar_4_usuarios.json")
    @DisplayName("[1] - Quando houver 2 usuarios com data de nascimento maior a 1990-01-01, então deve retornar status 200")
    void listarUsuariosDataMaior() throws Exception {

        var expected = """
                [
                    {
                      "id": 1,
                      "nome": "João",
                      "email": "test1@test.com",
                      "cpf": "111.111.111-11",
                      "dataNascimento": "1991-01-01"
                    },
                    {
                      "id": 4,
                      "nome": "Ana",
                      "email": "ana.carvalho@example.com",
                      "cpf": "444.444.444-44",
                      "dataNascimento": "1992-04-10"
                    }
                ]
                """;

        mockMvc.perform(get("/usuarios/filtro-data")
                        .queryParam("dataNascimento", "1990-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected))
                .andExpect(jsonPath("$[0].id").isNumber())
                .andExpect(jsonPath("$[0].cpf").value("111.111.111-11"))
                .andExpect(jsonPath("$[1].cpf").value("444.444.444-44"));

    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            value = "/listar/listar_4_usuarios.json")
    @DisplayName("[2] - Quando não houver 2 usuarios com data de nascimento maior a 1995-01-01, então deve retornar status 204")
    void listarUsuariosDataMaiorNaoExistente() throws Exception {

        mockMvc.perform(get("/usuarios/filtro-data")
                        .queryParam("dataNascimento", "1995-01-01"))
                .andExpect(status().isNoContent());

    }
}