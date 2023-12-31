package calc;

import java.util.Locale;
import java.util.Scanner;

public class Random {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);
        while(true) {


            System.out.println("Calculadora randomica");
            System.out.println("Insira qualquer string para continuar");
            sc.next();
            System.out.println();

            int n1 = (int) (Math.random() * 10);

            System.out.println("Seu primeiro numero aleatorio é: " + n1);

            int n2 = (int) (Math.random() * 10);

            System.out.println("Seu segundo numero aleatorio é: " + n2);

            System.out.println("A soma deles resulta em: " + (n1 + n2));
            System.out.println("A subtração deles resulta em: " + (n1 - n2));
            System.out.println("A multiplicação deles resulta em: " + (n1 * n2));
            System.out.println("A divisão deles resulta em: " + (n1 / n2));
            System.out.println();
        }
    }
}
