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
@DisplayName("Dado que o usuário deseja listar eventos por período, então")
public class EventoListagemPeriodoTest {

    public static final String URL_TESTE = EnderecosEnum.PERIODO.PATH;

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
        @DisplayName("1. Quando houver eventos cadastrados no período, então deve retornar status 200.")
        public void teste1() throws Exception {

            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2025-07-01")
                    .param("fim", "2025-07-31"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(3)))
                    .andExpect(jsonPath("$[0].nome").value("Caminhada Ecológica"))
                    .andExpect(jsonPath("$[0].dataPublicacao").value("2025-06-15"))
                    .andExpect(jsonPath("$[0].dataEvento").value("2025-07-05"))
                    .andExpect(jsonPath("$[1].nome").value("Congresso de Tecnologia"))
                    .andExpect(jsonPath("$[1].dataEvento").value("2025-07-20"))
                    .andExpect(jsonPath("$[1].dataPublicacao").value("2025-06-25"));
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName(("2. Quando a data inicio for igual a data fim, então deve retornar status 200."))
        public void teste2() throws Exception {
            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2025-07-05")
                    .param("fim", "2025-07-05"))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$", hasSize(1)))
                    .andExpect(jsonPath("$[0].nome").value("Caminhada Ecológica"))
                    .andExpect(jsonPath("$[0].dataPublicacao").value("2025-06-15"))
                    .andExpect(jsonPath("$[0].dataEvento").value("2025-07-05"));
        }
    }

    @Nested
    @DisplayName("Dados Incorretos")
    public class Incorreto {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("1. Quando não houver eventos cadastrados, então deve retornar status 204.")
        public void teste1() throws Exception {

            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2025-07-01")
                    .param("fim", "2025-07-31"))
                    .andExpect(status().isNoContent());
        }

        @Test
        @DisplayName("2. Quando a data inicio for maior que a data fim, então deve retornar status 400.")
        public void teste2() throws Exception {
            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2025-07-31")
                    .param("fim", "2025-07-01"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("3. Quando a data inicio for nula, então deve retornar status 400.")
        public void teste3() throws Exception {
            mockMvc.perform(get(URL_TESTE)
                    .param("fim", "2025-07-01"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @DisplayName("4. Quando a data fim for nula, então deve retornar status 400.")
        public void teste4() throws Exception {
            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2025-07-01"))
                    .andExpect(status().isBadRequest());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("5. Quando não houver eventos cadastrados no período, então deve retornar status 204.")
        public void teste5() throws Exception {
            mockMvc.perform(get(URL_TESTE)
                    .param("inicio", "2018-08-01")
                    .param("fim", "2019-08-31"))
                    .andExpect(status().isNoContent());
        }
    }

}
