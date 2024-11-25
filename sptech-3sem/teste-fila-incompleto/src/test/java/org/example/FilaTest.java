package org.example;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class FilaTest {
    @Test
    public void isFullTrueQuandoFilaPreenchida() {
        Fila filaTest = new Fila(5);
        filaTest.insert("a");
        assertFalse(filaTest.isFull());
        filaTest.insert("b");
        assertFalse(filaTest.isFull());
        filaTest.insert("c");
        assertFalse(filaTest.isFull());
        filaTest.insert("d");
        assertFalse(filaTest.isFull());
        filaTest.insert("e");
        assertTrue(filaTest.isFull());
    }

    @Test
    public void isEmptyQuandoFilaVazia() {
        Fila filaTest = new Fila(8);
        assertTrue(filaTest.isEmpty());
        filaTest.insert("a");
        filaTest.insert("b");
        filaTest.insert("c");
        filaTest.insert("d");
        filaTest.insert("e");
        filaTest.insert("f");
        filaTest.insert("g");
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertFalse(filaTest.isEmpty());
        filaTest.poll();
        assertTrue(filaTest.isEmpty());
    }

    @Test
    public void peekQuandoFilaRetornaA() {
        Fila filaTest = new Fila(3);
        filaTest.insert("a");
        filaTest.insert("b");
        filaTest.insert("c");
        assertEquals("a", filaTest.peek());
    }

    @Test
    public void pollQuandoFilaRetornaA() {
        Fila filaTest = new Fila(3);
        filaTest.insert("a");
        filaTest.insert("b");
        filaTest.insert("b");
        assertEquals(3, filaTest.getTamanho());
        assertEquals("a", filaTest.poll());
    }

    @Test
    public void pollQuandoFilaRetornaC() {
        Fila filaTest = new Fila(3);
        filaTest.insert("a");
        filaTest.insert("b");
        filaTest.insert("c");
        assertEquals("a", filaTest.poll());
        assertEquals("b", filaTest.poll());
    }

    @Test
    public void insertLancaIllegalStateExceptionQuandoFilaCheia() {
        Fila filaTest = new Fila(6);
        filaTest.insert("a");
        filaTest.insert("b");
        filaTest.insert("c");
        filaTest.insert("d");
        filaTest.insert("e");
        filaTest.insert("f");
        assertThrows(IllegalStateException.class, () -> filaTest.insert("g"));
    }

    @Test
    public void insertQuandoFilaRetornaA() {
        Fila filaTest = new Fila(6);
        filaTest.insert("a");
        assertEquals("a", filaTest.peek());
        filaTest.insert("b");
        assertEquals("a", filaTest.peek());
        filaTest.insert("c");
        assertEquals("a", filaTest.peek());
        filaTest.insert("d");
        assertEquals("a", filaTest.peek());
    }

}
