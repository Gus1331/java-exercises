package atleta;

public class Velocista implements Corredor{
    private String nome;

    public Velocista(String nome) {
        this.nome = nome;
    }

    @Override
    public void correr() {
        System.out.println("sim");
    }
}
