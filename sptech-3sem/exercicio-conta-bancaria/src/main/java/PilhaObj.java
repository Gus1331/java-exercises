public class PilhaObj<T>{

    private int topo;
    private T[] pilha;

    public PilhaObj(int tamanhoMax) {
        this.pilha = (T[]) new Object[tamanhoMax];
        topo = -1;
    }

    public boolean isEmpty() {
        return topo == -1;
    }

    public boolean isFull() {
        return topo == pilha.length - 1;
    }

    public void push(T n) {
        if (!isFull()) {
            pilha[++topo] = n;
        } else {
            throw new IllegalStateException();
        }

    }

    public T pop() {
        if (isEmpty()) return null;
        return pilha[topo--];
    }

    public T peek() {
        if (!isEmpty()) {
            return pilha[topo];
        } else return null;
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

    public T[] getPilha() {
        return pilha;
    }

}