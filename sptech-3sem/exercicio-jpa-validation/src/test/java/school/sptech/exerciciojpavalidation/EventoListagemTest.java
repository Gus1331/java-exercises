package school.sptech.exerciciojpavalidation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import school.sptech.exerciciojpavalidation.util.EnderecosEnum;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Dado que o usuário deseja listar eventos, então")
public class EventoListagemTest {

    public static final String URL_TESTE = EnderecosEnum.BASE_URL.PATH;

    public static final String FILL_DATABASE_SCRIPT = "/data/fill_database.sql";

    @Nested
    @DisplayName("Dados Corretos")
    public class Correto {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("1. Quando houver eventos cadastrados, então deve retornar status 200 e a lista de eventos.")
        public void teste1() throws Exception {

            mockMvc.perform(get(URL_TESTE))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(17)))
                    .andExpect(jsonPath("$[0].nome").value("Oficina de Fotografia"))
                    .andExpect(jsonPath("$[0].dataPublicacao").value("2025-05-01"))
                    .andExpect(jsonPath("$[1].nome").value("Festival de Música Solar"))
                    .andExpect(jsonPath("$[1].dataPublicacao").value("2025-07-20"));
        }
    }

    @Nested
    @DisplayName("Dados Incorretos")
    public class Incorreto {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("1. Quando não houver eventos cadastrados na tabela, então deve retornar status 204.")
        public void teste1() throws Exception {

            mockMvc.perform(get(URL_TESTE))
                    .andExpect(status().isNoContent());
        }
    }
}
