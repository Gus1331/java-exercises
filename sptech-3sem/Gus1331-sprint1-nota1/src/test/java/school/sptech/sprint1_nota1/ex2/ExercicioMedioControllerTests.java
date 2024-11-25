package school.sptech.sprint1_nota1.ex2;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(ExercicioMedioController.class)
public class ExercicioMedioControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Quando o número for primo, então retorna true")
    public void quandoNumeroForPrimo_entaoRetornaTrue() throws Exception {
        mockMvc.perform(get("/ex-02/7"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Quando o número não for primo, então retorna false")
    public void quandoNumeroNaoForPrimo_entaoRetornaFalse() throws Exception {
        mockMvc.perform(get("/ex-02/10"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Quando o número for menor ou igual a um, então retorna false")
    public void quandoNumeroForMenorOuIgualAUm_entaoRetornaFalse() throws Exception {
        mockMvc.perform(get("/ex-02/1"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));

        mockMvc.perform(get("/ex-02/-5"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

}
