package com.no;

public class Main {
    public static void main(String[] args) {

        No no1 = new No("Conteudo no1");    //definindo nó1
        No no2 = new No("Conteudo no2");    //definindo nó2

        no1.setProxNo(no2);     //cria um nó
        System.out.println(no2);    //prntando nó criado
        System.out.println(no2.getProxNo());    //printando null

    }
}
