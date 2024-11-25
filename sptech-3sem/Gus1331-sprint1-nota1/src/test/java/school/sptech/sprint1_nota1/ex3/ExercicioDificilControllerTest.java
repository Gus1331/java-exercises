package school.sptech.sprint1_nota1.ex3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExercicioDificilController.class)
public class ExercicioDificilControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Quando N for positivo, então retorna valor e correspondente soma")
    public void quandoNForPositivo_entaoRetornaValorECorrespondenteSoma() throws Exception {
        mockMvc.perform(get("/ex-03/6"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(8))
                .andExpect(jsonPath("$.soma").value(20));

        mockMvc.perform(get("/ex-03/7"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(13))
                .andExpect(jsonPath("$.soma").value(33));
    }

    @Test
    @DisplayName("Quando N for zero, então retorna zero para termo e soma")
    public void quandoNForZero_entaoRetornaZeroParaTermoESoma() throws Exception {
        mockMvc.perform(get("/ex-03/0"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(0))
                .andExpect(jsonPath("$.soma").value(0));
    }

    @Test
    @DisplayName("Quando N for um, então retorna um para termo e soma")
    public void quandoNForUm_entaoRetornaUmParaTermoESoma() throws Exception {
        mockMvc.perform(get("/ex-03/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(1))
                .andExpect(jsonPath("$.soma").value(1));
    }

    @Test
    @DisplayName("Quando N for 10, então retorna 55 para termo e 143 para soma")
    public void quandoNForPositivoGrande_entaoRetornaValorECorrespondenteSoma() throws Exception {
        mockMvc.perform(get("/ex-03/10"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(55))
                .andExpect(jsonPath("$.soma").value(143));
    }

    @Test
    @DisplayName("Quando N for negativo, então retorna 0 para termo e soma")
    public void quandoNForNegativo_entaoRetornaZeroParaTermoESoma() throws Exception {
        mockMvc.perform(get("/ex-03/-1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.enesimoTermo").value(0))
                .andExpect(jsonPath("$.soma").value(0));
    }
}
