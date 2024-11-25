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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Dado que o usuário deseja buscar um evento por id, então")
public class EventoPorIdTest {

    public static final String URL_TESTE = EnderecosEnum.POR_ID.PATH;

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
        @DisplayName("1. Quando o evento existir, então deve retornar status 200 e o evento.")
        public void teste1() throws Exception {

            mockMvc.perform(get(URL_TESTE, 15))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nome").value("Curso de Programação para Iniciantes"))
                    .andExpect(jsonPath("$.dataPublicacao").value("2025-07-15"));
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

            mockMvc.perform(get(URL_TESTE, 42))
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("2. Quando o evento não existir por tabela vazia, então deve retornar status 404.")
        public void teste2() throws Exception {

            mockMvc.perform(get(URL_TESTE, 1))
                    .andExpect(status().isNotFound());
        }
    }
}
