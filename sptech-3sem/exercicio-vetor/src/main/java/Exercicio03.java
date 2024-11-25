import java.util.Scanner;

public class Exercicio03 {
    public static void run(Scanner sc){
        System.out.println("-------------------------------------------");
        System.out.println("EXERCICIO 03");
        System.out.println();

        String[] sArray = new String[10];

        preencherVetor(new Scanner(System.in), sArray);

        System.out.println();
        System.out.println("Procure por um nome: ");
        String nome = new Scanner(System.in).nextLine();

        Boolean found = false;
        for (int i = 0; i < sArray.length; i++) {
            if(sArray[i].equals(nome)){
                found = true;
                System.out.println("Nome encontrado no índice " + i);
            } else if ((i + 1) == sArray.length && !found) {
                System.out.println("Nome não encontrado");
            }
        }

        System.out.println();
        System.out.println("-------------------------------------------");
    }

    public static String[] preencherVetor(Scanner sc, String[] array){
        System.out.println("Preencha o vetor com nomes: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print("Posição: " + (i+1) + " = " );
            array[i] = sc.nextLine();
        }

        return array;
    }
}
