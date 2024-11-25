package school.sptech.prova_ac1;

import com.github.database.rider.core.api.configuration.DBUnit;
import com.github.database.rider.core.api.dataset.DataSet;
import com.github.database.rider.core.api.dataset.ExpectedDataSet;
import com.github.database.rider.spring.api.DBRider;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@DBRider
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DBUnit(allowEmptyFields = true, cacheConnection = false, alwaysCleanAfter = true, alwaysCleanBefore = true)
@DisplayName("Dado que o endpoint DELETE /usuarios/{id} seja chamado")
public class DeleteUsuarioTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/listar/listar_20_usuarios.json")
    @ExpectedDataSet(value = "/listar/listar_19_usuarios.json")
    @DisplayName("[1] - Quando o usuário existir, então deve retornar status 204")
    void deletarUsuario() throws Exception {
        mockMvc.perform(delete("/usuarios/2"))
                .andExpect(status().isNoContent());
    }

    @Test
    @DataSet(
            cleanBefore = true,
            cleanAfter = true,
            executeStatementsBefore = "TRUNCATE TABLE usuario RESTART IDENTITY",
            value = "/listar/listar_20_usuarios.json")
    @ExpectedDataSet(value = "/listar/listar_20_usuarios.json")
    @DisplayName("[2] - Quando o usuário não existir, então deve retornar status 404")
    void deletarUsuarioNaoExistente() throws Exception {
        mockMvc.perform(delete("/usuarios/42"))
                .andExpect(status().isNotFound());
    }
}
