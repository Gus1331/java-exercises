import java.util.Scanner;

public class Exercicio01 {
    public static void run(Scanner sc){
        System.out.println("-------------------------------------------");
        System.out.println("EXERCICIO 01");
        System.out.println();

        int[] nArray = new int[7];

        nArray = preencherVetor(sc, nArray);

        System.out.println();
        System.out.print("Ordem 1: ");
        for (int i = 0; i < nArray.length; i++) {
            if (i == nArray.length - 1){
                System.out.print(nArray[i] + ".");
            } else {
                System.out.print(nArray[i] + ", ");
            }
        }

        System.out.println();
        System.out.print("Ordem 2: ");
        for (int i = nArray.length - 1; i >= 0; i--) {
            if (i == 0){
                System.out.print(nArray[i] + ".");
            } else {
                System.out.print(nArray[i] + ", ");
            }
        }

        System.out.println();
        System.out.println("-------------------------------------------");
    }

    public static int[] preencherVetor(Scanner sc, int[] array){
        System.out.println("Preencha o vetor: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Posição: " + (i+1) + " = " );
            array[i] = sc.nextInt();
        }

        return array;
    }
}
