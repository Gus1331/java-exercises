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
@DisplayName("Dado que o endpoint GET /usuarios seja chamado")
class ListarUsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            value = "/listar/listar_4_usuarios.json")
    @DisplayName("[1] - Quando houver 4 usuarios, então deve retornar status 200")
    void listarUsuarios() throws Exception {

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
                      "id": 2,
                      "nome": "Maria",
                      "email": "maria.santos@example.com",
                      "cpf": "222.222.222-22",
                      "dataNascimento": "1985-02-15"
                    },
                    {
                      "id": 3,
                      "nome": "Pedro",
                      "email": "pedro.silva@example.com",
                      "cpf": "333.333.333-33",
                      "dataNascimento": "1978-03-30"
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

        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(content().json(expected));
    }

    @Test
    @DisplayName("[2] - Quando não houver usuários, então deve retornar status 204")
    void listarUsuariosVazio() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            value = "/listar/listar_20_usuarios.json")
    @DisplayName("[3] - Quando houver 20 usuarios, então deve retornar status 200")
    void listarUsuarios20() throws Exception {
        mockMvc.perform(get("/usuarios"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.length()").value(20));
    }
}