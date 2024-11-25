public class Calculadora {
    // posicione o cursor em cima da classe: alt + enter -> create test

    public Double somar(Double n1, Double n2){
        if(n1 == null || n2 == null){
            throw new IllegalArgumentException("Achei paia");
        }
        return n1 + n2;
    }
}
