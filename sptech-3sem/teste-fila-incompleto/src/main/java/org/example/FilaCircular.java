package org.example;

public class FilaCircular {
    // Atributos
    private int tamanho;
    private String[] fila;
    private int inicio;
    private int fim;

    // Construtor
    public FilaCircular(int capaciade) {
        fila = new String[capaciade];
        tamanho = 0;
        inicio = 0;
        fim = 0;
    }

    // Métodos

    /* Método isEmpty() - retorna true se a fila está vazia e false caso contrário */
    public boolean isEmpty() {
        return tamanho == 0;
    }

    /* Método isFull() - retorna true se a fila está cheia e false caso contrário */
    public boolean isFull() {
        return fila.length == tamanho;
    }

    /* Método insert - recebe um elemento e insere esse elemento na fila
                       no índice tamanho, e incrementa tamanho
                       Lançar IllegalStateException caso a fila esteja cheia
     */
    public void insert(String info) {
        if (isFull()) {
            throw new IllegalStateException();
        }
        fila[fim] = info;
        fim = (fim + 1) % fila.length;
        tamanho++;
    }

    /* Método peek - retorna o primeiro elemento da fila, sem removê-lo */
    public String peek() {
        return fila[inicio];
    }

    /* Método poll - remove e retorna o primeiro elemento da fila, se a fila não estiver
       vazia. Quando um elemento é removido, a fila "anda", e tamanho é decrementado
       Depois que a fila andar, "limpar" o ex-último elemento da fila, atribuindo null
     */
    public String poll() {
        if (isEmpty()) {
            return null;
        }
        String pool = fila[inicio];
        inicio = (inicio + 1) % fila.length;
        tamanho--;
        return pool;
    }

    /* Método exibe() - exibe o conteúdo da fila */
    public void exibe() {
        for (int i = inicio, cont = 0; cont < tamanho; cont++) {
            System.out.println(fila[(i + cont) % fila.length]);
        }
    }

    /* Usado nos testes  - complete para que fique certo */
    public int getTamanho() {
        return tamanho;
    }
}

