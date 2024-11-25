package school.sptech.demo.controller;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.service.EmpresaService;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@DisplayName("Testes unitários da EmpresaController")
class EmpresaControllerTest {

    @Mock
    private EmpresaService empresaService;

    @InjectMocks
    private EmpresaController empresaController;

    @Test
    @DisplayName("Dado que, ao chamar a buscarTodos, retorna uma lista")
    public void buscarTodosCorretamente(){
        List<Empresa> empresas = List.of(new Empresa(1,"","","", LocalDate.now()));
        Mockito.when(empresaService.buscarTodos()).thenReturn(empresas);
        ResponseEntity<List<Empresa>> resultado = empresaController.listar();

        assertNotNull(resultado.getBody());
        assertEquals(HttpStatusCode.valueOf(200),resultado.getStatusCode());
        assertEquals(empresas.get(0).getId(), resultado.getBody().get(0).getId());
        assertFalse(resultado.getBody().isEmpty());
    }

    @Test
    @DisplayName("Dado que, ao chamar a buscarTodos, retorna uma lista vazia")
    public void buscarTodosIncorretamente(){
        Mockito.when(empresaService.buscarTodos()).thenReturn(new ArrayList<>());
        ResponseEntity<List<Empresa>> resultado = empresaController.listar();

        assertNull(resultado.getBody());
        assertEquals(HttpStatusCode.valueOf(204),resultado.getStatusCode());
    }
}