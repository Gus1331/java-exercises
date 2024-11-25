package school.sptech.sprint1_nota1.ex1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExercicioFacilController.class)
public class ExercicioFacilControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Quando a palavra for palíndromo, então retorna true")
    public void quandoPalavraForPalindromo_entaoRetornaTrue() throws Exception {
        mockMvc.perform(get("/ex-01/ana"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Quando a palavra não for palíndromo, então retorna false")
    public void quandoPalavraNaoForPalindromo_entaoRetornaFalse() throws Exception {
        mockMvc.perform(get("/ex-01/carro"))
                .andExpect(status().isOk())
                .andExpect(content().string("false"));
    }

    @Test
    @DisplayName("Quando a palavra for palíndromo com maiúsculas, então retorna true")
    public void quandoPalavraForPalindromoComMaiusculas_entaoRetornaTrue() throws Exception {
        mockMvc.perform(get("/ex-01/Ana"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }

    @Test
    @DisplayName("Quando a palavra for reviver, então retorna true")
    public void quandoPalavraForReviver_entaoRetornaTrue() throws Exception {
        mockMvc.perform(get("/ex-01/reviver"))
                .andExpect(status().isOk())
                .andExpect(content().string("true"));
    }
}
