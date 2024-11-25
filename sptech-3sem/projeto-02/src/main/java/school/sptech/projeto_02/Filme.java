package school.sptech.projeto_02;

public class Filme {
    private String nome;
    private String diretor;

    public Filme() {}

    public Filme(String nome, String diretor) {
        this.nome = nome;
        this.diretor = diretor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    // campo virtual // campo calculado (fórmula)
    public String getCalculado(){
        return "Td calculado";
    }

    public String getDiretor() {
        return diretor;
    }

    public void setDiretor(String diretor) {
        this.diretor = diretor;
    }
}
