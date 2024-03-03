package Scanners;
import java.util.Scanner;

public class ExemploScanner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um número inteiro:");
        Integer numero = scanner.nextInt();

        System.out.println("O número que você digitou foi: " + numero);

        System.out.println("Digite um número real");

        Double numeroRealDigitado = scanner.nextDouble();

        System.out.println("O número digitado foi: " + numeroRealDigitado);

        System.out.println("Digite seu nome: ");

        String nome = scanner.nextLine();

        System.out.println("O nome digitado foi: " + nome);
    }
}
