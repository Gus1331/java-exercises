package school.sptech.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import school.sptech.demo.service.EmpresaService;

@WebMvcTest(EmpresaController.class)
@DisplayName("Testes de integração")
public class EmpressaControllerIntegration {
    @MockBean
    private EmpresaService empresaService;

    @Autowired
    private MockMvc mockMvc;

    @Test
    @DisplayName("Dado que, tenho empresas no banco, retorna a lista")
    public void buscarTodosCorretamente(){

    }
}
