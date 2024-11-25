package school.sptech.prova_ac1;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import com.jayway.jsonpath.JsonPath;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DBUnit(allowEmptyFields = true, cacheConnection = false, alwaysCleanAfter = true, alwaysCleanBefore = true)
@DisplayName("Dado que o endpoint POST /usuarios seja chamado")
public class CadastrarUsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/datasets/listar/listar_20_usuarios.json")
    @ExpectedDataSet({
            "/datasets/listar/listar_20_usuarios.json",
            "/datasets/cadastrar/novo_usuario.json"})
    @DisplayName("[1] - Quando o usuário for cadastrado com sucesso, então deve retornar status 201 e id do usuário")
    void cadastrarUsuario() throws Exception {
        var body = """
                  {
                    "nome": "João",
                    "email": "test22@test.com",
                    "cpf": "454.111.111-11",
                    "dataNascimento": "1991-01-01"
                  }
                """;

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber());
    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/datasets/listar/listar_20_usuarios.json")
    @DisplayName("[2] - Quando o usuário for cadastrado com email já existente, então deve retornar status 409")
    void cadastrarUsuarioEmailExistente() throws Exception {
        var body = """
                {
                  "nome": "João",
                  "email": "test1@test.com",
                  "cpf": "454.111.111-11",
                  "dataNascimento": "1990-01-01"
                }
                """;

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isConflict());
    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/datasets/listar/listar_20_usuarios.json")
    @DisplayName("[3] - Quando o usuário for cadastrado com cpf já existente, então deve retornar status 409")
    void cadastrarUsuarioCpfExistente() throws Exception {
        var body = """
                {
                  "nome": "João",
                  "email": "test22@test.com",
                  "cpf": "111.111.111-11",
                  "dataNascimento": "1990-01-01"
                }
                """;

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isConflict());

    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/datasets/listar/listar_20_usuarios.json")
    @ExpectedDataSet({
            "/datasets/listar/listar_20_usuarios.json",
            "/datasets/cadastrar/novo_usuario.json"})
    @DisplayName("[4] - Caso o id seja informado, então deve ser ignorado e gerado um novo id")
    void cadastrarUsuarioComId() throws Exception {

        var id = 1;

        var body = """
                  {
                    "id": %d,
                    "nome": "João",
                    "email": "test22@test.com",
                    "cpf": "454.111.111-11",
                    "dataNascimento": "1991-01-01"
                  }
                """.formatted(id);

        var result = mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id").isNumber())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        Integer returnedId = JsonPath.parse(responseBody).read("$.id", Integer.class);

        assertNotEquals((int) returnedId, id, "O ID retornado não deve ser o mesmo ID enviado.");
    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/datasets/listar/listar_20_usuarios.json")
    @DisplayName("[5] - Quando o usuário for cadastrado com email e cpf já existentes, então deve retornar status 409")
    void cadastrarUsuarioEmailECpfExistente() throws Exception {
        var body = """
                {
                  "nome": "João",
                  "email": "teste1@test.com",
                  "cpf": "111.111.111-11",
                  "dataNascimento": "1990-01-01"
                }
                """;

        mockMvc.perform(post("/usuarios")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(body))
                .andExpect(status().isConflict());
    }
}
