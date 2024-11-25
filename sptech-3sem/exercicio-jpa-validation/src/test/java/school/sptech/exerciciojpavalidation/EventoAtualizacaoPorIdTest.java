package school.sptech.exerciciojpavalidation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import school.sptech.exerciciojpavalidation.util.EnderecosEnum;
import school.sptech.exerciciojpavalidation.util.ErrorMessageValidator;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Dado que o usuário deseja atualizar um evento por id, então")
public class EventoAtualizacaoPorIdTest {

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
        @DisplayName("1. Quando o evento existir e tudo estiver certo, então deve retornar status 200 e o evento.")
        public void teste1() throws Exception {

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true,
                        "cancelado": false
                    }
                    """;

            mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nome").value("Oficina de Imagem"))
                    .andExpect(jsonPath("$.local").value("Centro Cultural Nova Era"))
                    .andExpect(jsonPath("$.dataEvento").value("2025-06-10"))
                    .andExpect(jsonPath("$.gratuito").value(true));
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("2. Quando o evento enviado não tiver data de publicação, então deve retornar status 200 e o evento.")
        public void teste2() throws Exception {

            var evento = """
                    {
                        "nome": "Oficina de Arte Moderna",
                        "local": "Centro Cultural Nova Era",
                        "gratuito": true,
                        "cancelado": false,
                        "dataEvento": "2025-08-15",
                        "dataPublicacao": "2025-07-20"
                    }    
                    """;

            mockMvc.perform(put(URL_TESTE, 2)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isOk())
                    .andExpect(jsonPath("$.nome").value("Oficina de Arte Moderna"))
                    .andExpect(jsonPath("$.local").value("Centro Cultural Nova Era"))
                    .andExpect(jsonPath("$.dataEvento").value("2025-08-15"))
                    .andExpect(jsonPath("$.gratuito").value(true))
                    .andExpect(jsonPath("$.cancelado").value(false))
                    .andExpect(jsonPath("$.dataPublicacao").value("2025-07-20"));
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

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            mockMvc.perform(put(URL_TESTE, 42)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isNotFound());
        }

        @Test
        @DisplayName("2. Quando o evento não existir por tabela vazia, então deve retornar status 404.")
        public void teste2() throws Exception {

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isNotFound());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("3. Quando o evento estiver cancelado, então deve retornar status 422.")
        public void teste3() throws Exception {

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            mockMvc.perform(put(URL_TESTE, 8)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isUnprocessableEntity());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("4. Quando o evento estiver finalizado, então deve retornar status 422.")
        public void teste4() throws Exception {

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            mockMvc.perform(put(URL_TESTE, 17)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isUnprocessableEntity());
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("5. Quando o nome do evento for menor que 5 caracteres, então deve retornar status 400.")
        public void teste5() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 100"
            );

            var evento = """
                    {
                        "nome": "Ofi",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("6. Quando o nome do evento for maior que 100 caracteres, então deve retornar status 400.")
        public void teste6() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 100"
            );

            var evento = """
                    {
                        "nome": "Festival Internacional de Inovação, Criatividade e Empreendedorismo: Unindo Tecnologia, Arte e Sustentabilidade para um Futuro Melhor",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("7. Quando o nome estiver vazio, então deve retornar status 400.")
        public void teste7() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            var evento = """
                    {
                        "nome": "",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("8. Quando o nome estiver em branco, então deve retornar status 400.")
        public void teste8() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            var evento = """
                    {
                        "nome": " ",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("9. Quando o local do evento for menor que 5 caracteres, então deve retornar status 400.")
        public void teste9() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 150"
            );

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Cent",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("10. Quando o local do evento for maior que 150 caracteres, então deve retornar status 400.")
        public void teste10() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 150"
            );

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro de Convenções e Exposições Expansivo da Grande Metrópole, Localizado na Avenida da Inovação, Número 5000, Bairro do Futuro, Cidade das Oportunidades, Estado do Progresso, País das Maravilhas, CEP 12345-678, Ao Lado do Parque Tecnológico e Ambiental",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("11. Quando o local estiver vazio, então deve retornar status 400.")
        public void teste11() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("12. Quando o local estiver em branco, então deve retornar status 400.")
        public void teste12() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": " ",
                        "dataEvento": "2025-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("13. Quando a data é anterior a data atual, então deve retornar status 400.")
        public void teste13() throws Exception {

            var expectedMessages = List.of(
                    "must be a date in the present or in the future"
            );

            var evento = """
                    {
                        "nome": "Oficina de Imagem",
                        "local": "Centro Cultural Nova Era",
                        "dataEvento": "2021-06-10",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(put(URL_TESTE, 1)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest()).andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }
    }
}
