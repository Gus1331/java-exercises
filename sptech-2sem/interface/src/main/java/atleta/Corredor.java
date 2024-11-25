package atleta;

public interface Corredor {
    int teste = 13;
    void correr();

    default void tester(){
        System.out.println("se pa hein");
    }
}
