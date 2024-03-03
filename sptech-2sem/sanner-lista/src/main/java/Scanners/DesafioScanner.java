package Scanners;

import java.util.Scanner;

public class DesafioScanner {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Nome do pet para o cadastro");

        String nomePet = sc.nextLine();

        System.out.println("Altura:");
        Double alturaPet = sc.nextDouble();

        System.out.println("Idade do Pet:");

        Integer idadePet = sc.nextInt();

        System.out.println(String.format("""
                PET : %s
                Altura: %.2f
                Idade: %d""", nomePet, alturaPet, idadePet));
    }
}
