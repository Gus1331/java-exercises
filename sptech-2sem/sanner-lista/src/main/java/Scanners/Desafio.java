package Scanners;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Desafio {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> listaNumerica = new ArrayList<>();

        listaNumerica.add(1);
        listaNumerica.add(13);
        listaNumerica.add(11);
        listaNumerica.add(26);
        listaNumerica.add(24);
        listaNumerica.add(3);

        Integer somaListaNumerica = 0;

        for(int i = 0; i < listaNumerica.size(); i++){
            somaListaNumerica += listaNumerica.get(i);
        }
        System.out.println(somaListaNumerica);



        for(int i = 0; i < listaNumerica.size(); i++){
            if((listaNumerica.get(i) % 2) == 0){
                listaNumerica.remove(i);
                i--;
            }
        }

        System.out.println(listaNumerica);
    }
}
