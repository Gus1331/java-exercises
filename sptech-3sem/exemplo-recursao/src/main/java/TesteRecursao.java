public class TesteRecursao {
    public static void contagemRegressiva(int numero){
        for (int i = numero; i > 0; i--) {
            System.out.println(i);
        }
    }

    public static void contagemRegressivaRecursiva(int numero){

        System.out.println(numero);
        if(numero == 0){} else {
            contagemRegressivaRecursiva(numero-1);
        }
    }

    public static  int calcularFatorial(int numero){
        int resultadoFatorial = 1;

        for (int i = numero; i > 0; i--) {
            resultadoFatorial *= i;
        }
        return resultadoFatorial;
    }

    public static int calcularFatorialRecursivo(int numero){
        if(numero == 1){
            return 1;
        }
        return numero *= calcularFatorialRecursivo(numero - 1);
    }

    public static void exibeNomesRecursivos(String[] nomes, int indice){
        if(indice == nomes.length){
            return;
        }
        exibeNomesRecursivos(nomes, indice + 1);
        System.out.println(nomes[indice]);
    }

    public static int buscarQuantidadeVendas(int[] precos){
        return precos.length;
    }

    public static int somarVendas(int[] precos, int indice){
        if(indice > 1){
        return precos[indice-1] += somarVendas(precos, indice - 1);
        }
        return precos[0];
    }

    public static Boolean buscarPreco(int[] preco,int indice, int pesquisa){
        if(preco[indice] == pesquisa){
            return true;
        } else if(indice == 0){
            return false;
        }
        return buscarPreco(preco, indice - 1, pesquisa);
    }

    public static int buscarMaiorPreco(int[] preco,int indice){
        if(indice == 0){
            return preco[0];
        } else if(preco[indice] > buscarMaiorPreco(preco, indice - 1)){
            return preco[indice];
        }
        return preco[indice -1 ];
    }

    public static void main(String[] args) {
        // System.out.println(calcularFatorialRecursivo(5));
        // String[] nomes = {"Yasmilho", "kasmimon", "Hyasmin", "Giasmin"};
        // exibeNomesRecursivos(nomes, 0);

        int[] precos = {10,2,3,4,1,3,2,10};
        // System.out.println(somarVendas(precos, precos.length));
        // System.out.println(buscarPreco(precos, precos.length - 1, 2));


    }
}
