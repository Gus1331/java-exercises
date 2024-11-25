package Alertas;

import java.sql.SQLOutput;

public class Metricas {
    private int maxRam;
    private int maxDisco;

    // constructor

    public Metricas(int maxRam, int maxDisco) {
        this.maxRam = maxRam;
        this.maxDisco = maxDisco;
    }

    // outros metodos

    public void gerarAlerta(){
        System.out.println("Alerta: PC com problemas!");
    }

    // getters

    public int getMaxRam() {
        return maxRam;
    }

    public int getMaxDisco() {
        return maxDisco;
    }
}
