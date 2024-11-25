import java.util.Scanner;

public class Exercicio04 {
    public static void run(Scanner sc){
        System.out.println("-------------------------------------------");
        System.out.println("EXERCICIO 04");
        System.out.println();

        int[] nArray = new int[10];
        Integer qttRepeats = 0;

        nArray = Exercicio01.preencherVetor(sc, nArray);

        System.out.println();
        System.out.println("Digite um numero qualquer:");
        Integer number = sc.nextInt();

        for (int i = 0; i < nArray.length; i++) {
            if (number == nArray[i]){
                qttRepeats++;
            }
        }

        if (qttRepeats > 1){
            System.out.println("O número " + number + " ocorre " + qttRepeats + " vezes");
        } else if (qttRepeats == 1){
            System.out.println("O número " + number + " ocorre 1 vez");
        } else {
            System.out.println("O número " + number + " não ocorre nenhuma vez");
        }

        System.out.println();
        System.out.println("-------------------------------------------");
    }
}
