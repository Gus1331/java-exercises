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
import school.sptech.exerciciojpavalidation.util.DateUtil;
import school.sptech.exerciciojpavalidation.util.EnderecosEnum;
import school.sptech.exerciciojpavalidation.util.ErrorMessageValidator;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
@DisplayName("Dado que o usuário deseja criar um evento, então")
public class EventoCriacaoTest {

    public static final String URL_TESTE = EnderecosEnum.BASE_URL.PATH;

    public static final String FILL_DATABASE_SCRIPT = "/data/fill_database.sql";

    @Nested
    @DisplayName("Dados corretos")
    public class Correto {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @SqlGroup({
                @Sql(scripts = FILL_DATABASE_SCRIPT, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        })
        @DisplayName("1. Quando os dados do evento estão corretos, então o evento é criado com sucesso.")
        public void teste1() throws Exception {

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true,
                        "cancelado": false
                    }
                    """.formatted(dataTeste);

            mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isCreated())
                    .andExpect(jsonPath("$.id").isNumber())
                    .andExpect(jsonPath("$.nome").value("Churrasco de Aniversário"))
                    .andExpect(jsonPath("$.local").value("Casa do João"))
                    .andExpect(jsonPath("$.dataEvento").value(dataTeste))
                    .andExpect(jsonPath("$.gratuito").value(true))
                    .andExpect(jsonPath("$.cancelado").value(false))
                    .andExpect(jsonPath("$.dataPublicacao").value(LocalDate.now().toString()))
                    .andExpect(jsonPath("$.status").value("ABERTO"));
        }
    }

    @Nested
    @DisplayName("Dados incorretos")
    public class Incorreto {

        @Autowired
        private MockMvc mockMvc;

        @Test
        @DisplayName("1. Quando nome do evento está vazio, então retorna status 400.")
        public void teste1() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 100", "must not be blank"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("2. Quando nome contém apenas espaços, então retorna status 400.")
        public void teste2() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "     ",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("3. Quando nome do evento é nulo, então retorna status 400.")
        public void teste3() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("4. Quando nome tem menos de 5 caracteres, então retorna status 400.")
        public void teste4() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 100"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "João",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("5. Quando nome tem mais de 100 caracteres, então retorna status 400.")
        public void teste5() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 100"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Workshop de Desenvolvimento Profissional e Pessoal com Enfoque em Técnicas Avançadas de Comunicação e Liderança",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("6. Quando local do evento está vazio, então retorna status 400.")
        public void teste6() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank", "size must be between 5 and 150"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("7. Quando local contém apenas espaços, então retorna status 400.")
        public void teste7() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "     ",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("8. Quando local do evento é nulo, então retorna status 400.")
        public void teste8() throws Exception {

            var expectedMessages = List.of(
                    "must not be blank"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("9. Quando local tem menos de 5 caracteres, então retorna status 400.")
        public void teste9() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 150"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("10. Quando local tem mais de 150 caracteres, então retorna status 400.")
        public void teste10() throws Exception {

            var expectedMessages = List.of(
                    "size must be between 5 and 150"
            );

            String dataTeste = DateUtil.dataAtualPlus(20, 1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "Centro de Eventos Internacional dos Grandes Encontros Empresariais, Tecnológicos e Culturais da Região Metropolitana da Baía de São Francisco com Foco em Sustentabilidade e Inovação",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("11. Quando data do evento é nula, então retorna status 400.")
        public void teste11() throws Exception {

            var expectedMessages = List.of(
                    "must not be null"
            );

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "Casa do João",
                        "gratuito": true
                    }    
                    """;

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }

        @Test
        @DisplayName("12. Quando data do evento é passada, então retorna status 400.")
        public void teste12() throws Exception {

            var expectedMessages = List.of(
                    "must be a date in the present or in the future"
            );

            String dataTeste = DateUtil.dataAtualPlus(-5, -1, 0);

            var evento = """
                    {
                        "nome": "Churrasco de Aniversário",
                        "local": "Casa do João",
                        "dataEvento": "%s",
                        "gratuito": true
                    }    
                    """.formatted(dataTeste);

            MvcResult response = mockMvc.perform(post(URL_TESTE)
                            .contentType(MediaType.APPLICATION_JSON)
                            .content(evento))
                    .andExpect(status().isBadRequest())
                    .andReturn();

            ErrorMessageValidator.assertContainsErrorMessages(response, expectedMessages);
        }
    }
}
