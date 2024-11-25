import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nome;
    private List<Contato> integrantes;

    public Grupo(String nome) {
        this.nome = nome;
        this.integrantes = new ArrayList<>();
    }

    public Grupo() {
    }

    public void adicionar(Contato integrante){
        this.integrantes.add(integrante);
    }

    public void remover(Contato integrante){
        this.integrantes.remove(integrante);
    }

    @Override
    public String toString() {
        return """
                Nome do grupo %s
                Lista de Contatos %s
                """.formatted(this.nome, this.integrantes);
    }
}
