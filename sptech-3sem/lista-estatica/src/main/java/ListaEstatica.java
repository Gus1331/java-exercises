public class ListaEstatica {

    private int[] vetor;
    private int nroElem;

    public ListaEstatica(int tamanhoMaximo){
        this.vetor = new int[tamanhoMaximo];
        this.nroElem = 0;
    }

    public void add(int n){
        if(nroElem >= vetor.length){
            System.out.println("Lista cheia");
            throw new IllegalStateException();
        } else{
            this.vetor[nroElem++] = n;
        }
    }

    public void print(){
        System.out.print("[");
        for (int i = 0; i < nroElem; i++) {

            if( i < vetor.length - 1){
                System.out.print(vetor[i] + ", ");
            } else {
                System.out.println(vetor[i] + "] ");
            }
        }
    }

    public int find(int n){
        for (int i = 0; i < nroElem; i++) {
            if(vetor[i] == n){
                return i;
            }
        }
        return  -1;
    }

    public boolean remove(int n){
        if(n >= vetor.length || n < 0){
            return false;
        }
        for (int i = n; i < nroElem - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        this.nroElem--;
        return true;
    }

    public boolean removeByContent(int n){
        boolean removed = false;
        for (int i = 0; i < nroElem; i++) {
            if(vetor[i] == n){
                remove(i);
                removed = true;
            }
        }
        return removed;
    }

    public int[] getVetor() {
        return vetor;
    }

    public void setVetor(int[] vetor) {
        this.vetor = vetor;
    }

    public int getNroElem() {
        return nroElem;
    }

    public void setNroElem(int nroElem) {
        this.nroElem = nroElem;
    }
}
