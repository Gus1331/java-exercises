package org.example;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        FilaCircular fila = new FilaCircular(10);
        fila.insert("a");
        fila.insert("b");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");
        fila.insert("c");

        fila.exibe();
    }
}