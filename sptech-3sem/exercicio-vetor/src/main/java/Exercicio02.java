import java.util.Scanner;

public class Exercicio02 {
    public static void run(Scanner sc){
        System.out.println("-------------------------------------------");
        System.out.println("EXERCICIO 02");
        System.out.println();

        int[] nArray = new int[10];
        int media = 0;

        nArray = Exercicio01.preencherVetor(sc, nArray);

        for (int i = 0; i < nArray.length; i++) {
            media += nArray[i];
        }
        media = media / nArray.length;

        System.out.println();
        System.out.println("A média dos vetores é: " + media);
        System.out.println("Numeros acima da média:");
        for (int i = 0; i < nArray.length; i++) {
            if(nArray[i] > media){
                System.out.println(nArray[i]);
            }
        }

        System.out.println();
        System.out.println("-------------------------------------------");
    }
}
