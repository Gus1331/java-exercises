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
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DBUnit(allowEmptyFields = true, cacheConnection = false, alwaysCleanAfter = true, alwaysCleanBefore = true)
@DisplayName("Dado que o endpoint GET /usuarios/{id} seja chamado")
public class BuscarUsuarioPorIdTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/listar/listar_20_usuarios.json")
    @DisplayName("[1] - Quando o usuário existir, então deve retornar status 200")
    void buscarUsuario() throws Exception {
        mockMvc.perform(get("/usuarios/3"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").isNumber())
                .andExpect(jsonPath("$.nome").value("Pedro"))
                .andExpect(jsonPath("$.cpf").value("333.333.333-33"));

    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/listar/listar_20_usuarios.json")
    @DisplayName("[2] - Quando o usuário não existir, então deve retornar status 404")
    void buscarUsuarioNaoExistente() throws Exception {
        mockMvc.perform(get("/usuarios/42"))
                .andExpect(status().isNotFound());
    }
}
