import java.util.Scanner;

public class ExemploVetor {
    public static void main(String[] args) {

        String[] palavras = new String[50];
        palavras[42] = "Resposta";
        int[] vetorComValores = { 10, 20, 30, 40, 50};
        int[] vetor = new int[5];
        vetor[0] = 10;
        vetor[1] = 20;

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

        String palavra = "Teste";

        System.out.println("A palavra é: " + palavra);

        Scanner sc = new Scanner(System.in);

        int[] vetorUsuario = new int[7];

            for (int i = 0; i < vetorUsuario.length; i++) {
                System.out.println("Preencha o vetor [" + i + "]: ");
                vetorUsuario[i] = sc.nextInt();
            }

        exibeVetorDeInteiros(vetorUsuario);
    }

    public static void exibeVetorDeInteiros(int[] vetor){
        for (int i = 0; i < vetor.length; i++) {
            System.out.println("vetor [" + i + "] = " + vetor[i]);
        }
    }
}
