package school.sptech.demo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import school.sptech.demo.controller.EmpresaController;
import school.sptech.demo.entity.Empresa;
import school.sptech.demo.exception.ConflitoException;
import school.sptech.demo.exception.EntidadeNaoEncontradaException;
import school.sptech.demo.repository.EmpresaRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class EmpresaControllerUnitTeste {

    @Mock
    private EmpresaRepository empresaRepository;

    @Mock
    private EmpresaController empresaController;

    @InjectMocks
    private EmpresaService empresaService;

    @Test
    @DisplayName("Dado que, não tenho nada no banco, retorna lista vazia")
    public void buscarTodosListaVazia() {
        // GIVEN / ARRANGE - config
        List<Empresa> lista = Collections.emptyList();

        // WHEN / ARRANGE
        Mockito.when(empresaRepository.findAll()).thenReturn(lista);

        // THEN//ACT
        List<Empresa> resultado = empresaService.buscarTodos();

        // ASSERT / ASSERT
        assertNotNull(resultado);

        assertTrue(resultado.isEmpty());
        assertEquals(0, resultado.size());

        Mockito.verify(empresaRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Dado que, tenho algo no banco, retorna lista com ")
    public void buscarTodosListaCheia() {
        List<Empresa> lista = List.of(
                new Empresa(1, "Nome", "razao", "cnpj", LocalDate.of(1885, 1, 1)),
                new Empresa(2, "SPTECO", "razao", "cnpj", LocalDate.of(2016, 1, 1))
        );

        Mockito.when(empresaRepository.findAll()).thenReturn(lista);

        List<Empresa> resultado = empresaService.buscarTodos();

        assertNotNull(resultado);
        assertFalse(resultado.isEmpty());
        assertEquals(lista.size(), resultado.size());
        for (int i = 0; i < resultado.size(); i++) {
            assertEquals(lista.get(i).getId(), resultado.get(i).getId());
            assertEquals(lista.get(i).getNomeFantasia(), resultado.get(i).getNomeFantasia());
            assertEquals(lista.get(i).getCnpj(), resultado.get(i).getCnpj());
            assertEquals(lista.get(i).getDataFundacao(), resultado.get(i).getDataFundacao());
            assertEquals(lista.get(i).getRazaoSocial(), resultado.get(i).getRazaoSocial());
        }
        Mockito.verify(empresaRepository, Mockito.times(1)).findAll();
    }

    @Test
    @DisplayName("Dado que, tenho uma empresa pelo id, retorne corretamente")
    public void buscaPorIdCorretamente(){
        Empresa empresaEsperada = new Empresa(1, "Nome", "razao", "cnpj", LocalDate.of(1885, 1, 1));

        Mockito.when(empresaRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(empresaEsperada));

        Empresa resultado = empresaService.buscarPorId(1);

        assertNotNull(resultado);
        assertEquals(empresaEsperada.getId(), resultado.getId());
        Mockito.verify(empresaRepository, Mockito.times(1)).findById(1);
        Mockito.verify(empresaRepository, Mockito.never()).findAll();
    };

    @Test
    void buscarPorIdInexistente(){
        Mockito.when(empresaRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());

        EntidadeNaoEncontradaException ex = assertThrows(EntidadeNaoEncontradaException.class, () ->{
            empresaService.buscarPorId(1);
        });

        assertEquals("Empresa", ex.getMessage());

        Mockito.verify(empresaRepository, Mockito.times(1)).findById(1);
        Mockito.verify(empresaRepository, Mockito.never()).findAll();
    }

    @Test
    @DisplayName("Dado que, a empresa existe por CNPJ, deve retornar conflito")
    void cadastrarFail(){
        Empresa empresaParaSalvar = new Empresa(1,"blabla", "blebleble", "fififi", LocalDate.now());
        // Mockito.when(empresaRepository.save(Mockito.any())).thenReturn(empresaParaSalvar);
        Mockito.when(empresaRepository.existsByCnpj(Mockito.any())).thenReturn(true);

        assertThrows(ConflitoException.class, () -> empresaService.salvar(empresaParaSalvar));

        Mockito.verify(empresaRepository, Mockito.times(1)).existsByCnpj(Mockito.any());
    }

    @Test
    @DisplayName("Dado que, a empresa não existe por CNPJ, deve retornar certo")
    void cadastrarSucess(){
        Empresa empresaParaSalvar = new Empresa(1,"blabla", "blebleble", "fififi", LocalDate.now());
        Mockito.when(empresaRepository.save(Mockito.any())).thenReturn(empresaParaSalvar);
        Mockito.when(empresaRepository.existsByCnpj(Mockito.any())).thenReturn(false);

        Empresa empresaRetornada = empresaService.salvar(empresaParaSalvar);

        assertNotNull(empresaRetornada);
        assertEquals(empresaParaSalvar.getId(), empresaParaSalvar.getId());
    }

    @Test
    @DisplayName("Dado que, buscarPorId não tenha por id informado, lança exception")
    public void buscarPorIdIncorretamente(){
        Integer idInformado = 1;

        Mockito.when(empresaService.buscarPorId(idInformado)).thenThrow(new EntidadeNaoEncontradaException("Empresa"));

        // ResponseEntity<Empresa> resultado = empresaController.porId()
        assertThrows(EntidadeNaoEncontradaException.class, () -> empresaService.buscarPorId(idInformado));
    }
}