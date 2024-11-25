package atleta;

public class Triatleta implements Nadador, Corredor {
    private String nome;

    public Triatleta(String nome) {
        this.nome = nome;
    }

    @Override
    public void correr() {
        System.out.println("tmj");
    }

    @Override
    public void nadar() {
        System.out.println("preguiça");
    }
}
