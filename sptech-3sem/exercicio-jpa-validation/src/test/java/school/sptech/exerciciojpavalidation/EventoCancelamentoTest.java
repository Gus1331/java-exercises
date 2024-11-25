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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Dado que o usuário deseja cancelar um evento, então")
public class EventoCancelamentoTest {

    public static final String URL_TESTE = EnderecosEnum.CANCELAR.PATH;

    public static final String FILL_DATABASE_SCRIPT = "/data/fill_database.sql";

    @Nested
    public class Correto {
        @Autowired
        private MockMvc mockMvc;

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("1. Quando o evento existir, então deve retornar status 204.")
        public void teste1() throws Exception {

            mockMvc.perform(patch(URL_TESTE, 15))
                    .andExpect(status().isNoContent());
        }
    }

    @Nested
    @DisplayName("Dados Incorretos")
    public class Incorreto {
        @Autowired
        private MockMvc mockMvc;

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("1. Quando o evento não existir, então deve retornar status 404.")
        public void teste1() throws Exception {

            mockMvc.perform(patch(URL_TESTE, 42))
                    .andExpect(status().isNotFound());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("2. Quando o evento já foi cancelado, então deve retornar status 422.")
        public void teste2() throws Exception {

            mockMvc.perform(patch(URL_TESTE, 8))
                    .andExpect(status().isUnprocessableEntity());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("3. Quando o evento já foi finalizado, então deve retornar status 422.")
        public void teste3() throws Exception {

            mockMvc.perform(patch(URL_TESTE, 17))
                    .andExpect(status().isUnprocessableEntity());
        }
    }
}
