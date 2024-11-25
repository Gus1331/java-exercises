import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


@DisplayName("Teste para a classe calculadora.")
class CalculadoraTest {
    @Test // import org.junit.jupiter.api.Test;
    @DisplayName("Calcula corretamente")
    public void somarCorretamente() {
        // ARRANGE ACT ASSERT - TRIPLE A

        // ARRANGE
        Calculadora calculadora = new Calculadora();

        // ACT
        Double resultado = calculadora.somar(1.0, 2.0);

        // ASSERT
        assertEquals(3, resultado, "Teste deu erro aqui");
    }

    @Test
    @DisplayName("Calcula incorretamente")
    public void somarNull() {

        Calculadora calculadora = new Calculadora();

        //Arqui testamos caso de erro esperado.
        IllegalArgumentException ex = assertThrows(IllegalArgumentException.class, () -> calculadora.somar(null, 1.0));

        // valida mensagem do erro
        assertEquals("Achei paia", ex.getMessage());
    }
}
