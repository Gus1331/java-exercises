import java.util.List;

public class Utilitaria {
    void exibirMensagem() {
        System.out.println("Hello world!");
    }

    Integer somar(int a, int b) {
        return a + b;
    }

    void exibirLista(List<String> lista) {
        for (int i = 0; i < lista.size(); i++) {
            System.out.println(lista.get(i));
        }
    }

    Boolean busca(List<String> lista, String busca) {
        Boolean existeNaLista = false;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).equals(busca)){
                return true;
            }
        }
        return false;
    }

}