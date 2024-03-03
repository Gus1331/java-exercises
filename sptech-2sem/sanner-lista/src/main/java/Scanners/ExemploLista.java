package Scanners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ExemploLista {
    public static void main(String[] args) {
        List listaMaluca = new ArrayList();
        listaMaluca.add("Manoel Gomes");
        listaMaluca.add(8);
        listaMaluca.add(true);
        listaMaluca.add(1.35);
        listaMaluca.add(0, "Thiago");
        listaMaluca.set(1, null);

        listaMaluca.remove(2);
        Integer valor = null;

        listaMaluca.remove(valor);
        System.out.println(listaMaluca);
        System.out.println(listaMaluca.get(0));



        List<Integer> listaNumeros = new ArrayList<>();
        listaNumeros.add(13);
        listaNumeros.add(15);
        listaNumeros.add(16);
        listaNumeros.add(17);
        listaNumeros.size(); // Retorna tamanho da lista


        for(int i = 0; i < listaNumeros.size(); i++){
            System.out.println(listaNumeros.get(i));
        }

        Scanner sc = new Scanner(System.in);
        List<Integer> valores = new ArrayList<>();

        System.out.println("Quantas valores vc deseja digitar?");

        Integer qtdValores = sc.nextInt();

        for(int i = 0; i < qtdValores; i++){
            System.out.println(
                    String.format("Informe o %d digitado", i + 1)
            );
            valores.add(sc.nextInt());
        }

        System.out.println(valores);
    }
}
