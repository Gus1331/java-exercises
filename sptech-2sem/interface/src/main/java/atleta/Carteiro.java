package atleta;

public class Carteiro implements Corredor {
    private String nome;

    public Carteiro(String nome) {
        this.nome = nome;
    }

    @Override
    public void correr() {
        System.out.println("se pa");
    }
}
