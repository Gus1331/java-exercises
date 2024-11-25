package org.example;

public class Pilha {

    private int topo;
    private int[] pilha;

    public Pilha(int tamanhoMax) {
        this.pilha = new int[tamanhoMax];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(int n) {
        if (!isFull()) {
            pilha[++topo] = n;
        } else {
            throw new IllegalStateException();
        }

    }

    public int pop() {
        if (isEmpty()) return -1;
        return pilha[topo--];
    }

    public int peek() {
        if (!isEmpty()) {
            return pilha[topo];
        } else return -1;
    }

    public void exibe() {
        if (!isEmpty()) {
            for (int i = 0; i < topo + 1; i++) {
                System.out.println(pilha[i]);
            }
        }
    }

    public int getTopo() {
        return topo;
    }

    public int[] getPilha() {
        return pilha;
    }

}