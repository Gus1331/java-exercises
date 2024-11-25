package school.sptech;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TesteGestaoPacientes {
    private Paciente[] pacientes;

    @BeforeEach
    void setUp() {
        pacientes = new Paciente[]{
                new Paciente(1001, "Leo", 150.42, 3),
                new Paciente(1002, "Ben", 100.21, 1),
                new Paciente(1003, "Mia", 560.32, 4),
                new Paciente(1004, "Dan", 299.90, 5),
                new Paciente(1005, "Tom", 175.67, 7),
                new Paciente(1006, "Ana", 470.80, 2),
        };
    }

    @Test
    @DisplayName("01) Método alterarValorConsulta - Altera Corretamente")
    void testAlterarValorConsulta_Success() {
        boolean result = GestaoPacientes.alterarValorConsulta(pacientes, 1003, 600.00);
        assertTrue(result);
        assertEquals(600.00, pacientes[2].getValorConsulta());
    }

    @Test
    @DisplayName("02) Método alterarValorConsulta - Quando id inválido")
    void testAlterarValorConsulta_IdNotFound() {
        boolean result = GestaoPacientes.alterarValorConsulta(pacientes, 9999, 600.00);
        assertFalse(result);
    }

    @Test
    @DisplayName("03) Método somaValorConsulta - Soma Corretamente")
    void testSomaValorConsulta_Success() {
        Double result = GestaoPacientes.somaValorConsulta(pacientes);
        assertEquals(1757.32, result);
    }

    @Test
    @DisplayName("04) Método somaValorConsulta - Com vetor vazio")
    void testSomaValorConsulta_EmptyArray() {
        Double result = GestaoPacientes.somaValorConsulta(new Paciente[0]);
        assertEquals(0.0, result);
    }

    @Test
    @DisplayName("05) Método trocaPacientes - Troca Corretamente")
    void testTrocaPacientes_Success() {
        GestaoPacientes.trocaPacientes(pacientes, 1001, 1004);

        assertEquals(1004, pacientes[0].getId());
        assertEquals("Dan", pacientes[0].getNome());
        assertEquals(299.90, pacientes[0].getValorConsulta());
        assertEquals(5, pacientes[0].getIdade());

        assertEquals(1001, pacientes[3].getId());
        assertEquals("Leo", pacientes[3].getNome());
        assertEquals(150.42, pacientes[3].getValorConsulta());
        assertEquals(3, pacientes[3].getIdade());
    }

    @Test
    @DisplayName("06) Método trocaPacientes - Com idPaciente01 e idPaciente02 iguais")
    void testTrocaPacientes_SameId() {
        GestaoPacientes.trocaPacientes(pacientes, 1001, 1001);

        assertEquals(1001, pacientes[0].getId());
        assertEquals("Leo", pacientes[0].getNome());
        assertEquals(150.42, pacientes[0].getValorConsulta());
        assertEquals(3, pacientes[0].getIdade());
    }

    @Test
    @DisplayName("07) Método trocaPacientes - Com idPaciente01 inválido")
    void testTrocaPacientes_IdNotFound() {
        GestaoPacientes.trocaPacientes(pacientes, 9999, 1004);
        assertEquals(1001, pacientes[0].getId());
        assertEquals(1004, pacientes[3].getId());
    }

    @Test
    @DisplayName("08) Método ordenarPorIdade - Ordena Corretamente")
    void testOrdenarPorIdade_Success() {
        GestaoPacientes.ordenarPorIdade(pacientes);

        assertEquals(1002, pacientes[0].getId());
        assertEquals("Ben", pacientes[0].getNome());
        assertEquals(100.21, pacientes[0].getValorConsulta());
        assertEquals(1, pacientes[0].getIdade());

        assertEquals(1006, pacientes[1].getId());
        assertEquals("Ana", pacientes[1].getNome());
        assertEquals(470.80, pacientes[1].getValorConsulta());
        assertEquals(2, pacientes[1].getIdade());

        assertEquals(1001, pacientes[2].getId());
        assertEquals("Leo", pacientes[2].getNome());
        assertEquals(150.42, pacientes[2].getValorConsulta());
        assertEquals(3, pacientes[2].getIdade());

        assertEquals(1003, pacientes[3].getId());
        assertEquals("Mia", pacientes[3].getNome());
        assertEquals(560.32, pacientes[3].getValorConsulta());
        assertEquals(4, pacientes[3].getIdade());

        assertEquals(1004, pacientes[4].getId());
        assertEquals("Dan", pacientes[4].getNome());
        assertEquals(299.90, pacientes[4].getValorConsulta());
        assertEquals(5, pacientes[4].getIdade());

        assertEquals(1005, pacientes[5].getId());
        assertEquals("Tom", pacientes[5].getNome());
        assertEquals(175.67, pacientes[5].getValorConsulta());
        assertEquals(7, pacientes[5].getIdade());
    }

    @Test
    @DisplayName("09) Método ordenarPorIdadeDecrescente - Ordena Corretamente")
    void testOrdenarPorIdadeDecrescente_Success() {
        GestaoPacientes.ordenarPorIdadeDecrescente(pacientes);

        assertEquals(1005, pacientes[0].getId());
        assertEquals("Tom", pacientes[0].getNome());
        assertEquals(175.67, pacientes[0].getValorConsulta());
        assertEquals(7, pacientes[0].getIdade());

        assertEquals(1004, pacientes[1].getId());
        assertEquals("Dan", pacientes[1].getNome());
        assertEquals(299.90, pacientes[1].getValorConsulta());
        assertEquals(5, pacientes[1].getIdade());

        assertEquals(1003, pacientes[2].getId());
        assertEquals("Mia", pacientes[2].getNome());
        assertEquals(560.32, pacientes[2].getValorConsulta());
        assertEquals(4, pacientes[2].getIdade());

        assertEquals(1001, pacientes[3].getId());
        assertEquals("Leo", pacientes[3].getNome());
        assertEquals(150.42, pacientes[3].getValorConsulta());
        assertEquals(3, pacientes[3].getIdade());

        assertEquals(1006, pacientes[4].getId());
        assertEquals("Ana", pacientes[4].getNome());
        assertEquals(470.80, pacientes[4].getValorConsulta());
        assertEquals(2, pacientes[4].getIdade());

        assertEquals(1002, pacientes[5].getId());
        assertEquals("Ben", pacientes[5].getNome());
        assertEquals(100.21, pacientes[5].getValorConsulta());
        assertEquals(1, pacientes[5].getIdade());
    }

    @Test
    @DisplayName("10) Método ordenarPorNomePaciente - Ordena Corretamente")
    void testOrdenarPorNomePaciente_Success() {
        GestaoPacientes.ordenarPorNomePaciente(pacientes);

        assertEquals(1006, pacientes[0].getId());
        assertEquals("Ana", pacientes[0].getNome());
        assertEquals(470.80, pacientes[0].getValorConsulta());
        assertEquals(2, pacientes[0].getIdade());

        assertEquals(1002, pacientes[1].getId());
        assertEquals("Ben", pacientes[1].getNome());
        assertEquals(100.21, pacientes[1].getValorConsulta());
        assertEquals(1, pacientes[1].getIdade());

        assertEquals(1004, pacientes[2].getId());
        assertEquals("Dan", pacientes[2].getNome());
        assertEquals(299.90, pacientes[2].getValorConsulta());
        assertEquals(5, pacientes[2].getIdade());

        assertEquals(1001, pacientes[3].getId());
        assertEquals("Leo", pacientes[3].getNome());
        assertEquals(150.42, pacientes[3].getValorConsulta());
        assertEquals(3, pacientes[3].getIdade());

        assertEquals(1003, pacientes[4].getId());
        assertEquals("Mia", pacientes[4].getNome());
        assertEquals(560.32, pacientes[4].getValorConsulta());
        assertEquals(4, pacientes[4].getIdade());

        assertEquals(1005, pacientes[5].getId());
        assertEquals("Tom", pacientes[5].getNome());
        assertEquals(175.67, pacientes[5].getValorConsulta());
        assertEquals(7, pacientes[5].getIdade());
    }
}
