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
@DisplayName("Dado que o usuário deseja listar eventos gratuitos, então")
public class EventoListagemGratuitosTest {

    public static final String URL_TESTE = EnderecosEnum.GRATUITOS.PATH;

    public static final String FILL_DATABASE_SCRIPT = "/data/fill_database.sql";
    public static final String FILL_DATABASE_PAID_SCRIPT = "/data/fill_database_only_paid.sql";

    @Nested
    @DisplayName("Dados Corretos")
    public class Correto{

        @Autowired
        private MockMvc mockMvc;

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("1. Quando houver eventos gratuitos cadastrados, então deve retornar status 200 e a lista de eventos gratuitos.")
        public void teste1() throws Exception{

            mockMvc.perform(get("/eventos/gratuitos"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(8)))
                    .andExpect(jsonPath("$[0].nome").value("Oficina de Fotografia"))
                    .andExpect(jsonPath("$[0].dataPublicacao").value("2025-05-01"))
                    .andExpect(jsonPath("$[1].nome").value("Feira de Artesanato"))
                    .andExpect(jsonPath("$[1].dataPublicacao").value("2025-08-30"));
        }
    }

    @Nested
    @DisplayName("Dados Incorretos")
    public class Incorreto{

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("1. Quando não houver eventos cadastrados, então deve retornar status 204.")
        public void teste1() throws Exception{

            mockMvc.perform(get("/eventos/gratuitos"))
                    .andExpect(status().isNoContent());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_PAID_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("2. Quando não houver eventos gratuitos cadastrados, então deve retornar status 204.")
        public void teste2() throws Exception{
            mockMvc.perform(get("/eventos/gratuitos"))
                    .andExpect(status().isNoContent());
        }
    }
}
