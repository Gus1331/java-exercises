package calc;

import java.util.Locale;
import java.util.Scanner;

public class Sum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in).useLocale(Locale.US);

        System.out.println("Seu nome: ");
        String name = sc.next();

        System.out.println("Primeiro numero que deseja somar:");
        String n1sc = sc.next();
        int n1 = Integer.parseInt(n1sc);

        System.out.println("Segundo numero que deseja somar:");
        String n2sc = sc.next();
        int n2 = Integer.parseInt(n2sc);
        System.out.println("Olá " + name + ", o resultado da soma entre os numeros é: " + (n1 + n2));
    }
}