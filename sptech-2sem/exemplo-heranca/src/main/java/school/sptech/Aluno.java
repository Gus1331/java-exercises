package school.sptech;

public class Aluno {
    private String nome;

    private Double notaAtividade;
    private Double notaAvaliacao;

    public Aluno(String nome, Double notaAtividade, Double notaAvaliacao) {
        this.nome = nome;
        this.notaAtividade = notaAtividade;
        this.notaAvaliacao = notaAvaliacao;
    }

    public Double calcularNotaFinal(){
        return (this.notaAtividade * 0.4) + (this.notaAvaliacao * 0.6);
    }

    @Override
    public String toString() {
        return "Aluno{" +
                "nome='" + nome + '\'' +
                ", notaAtividade=" + notaAtividade +
                ", notaAvaliacao=" + notaAvaliacao +
                ", nota final="+ this.calcularNotaFinal() +
                '}';
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaAtividade() {
        return notaAtividade;
    }

    public void setNotaAtividade(Double notaAtividade) {
        this.notaAtividade = notaAtividade;
    }

    public Double getNotaAvaliacao() {
        return notaAvaliacao;
    }

    public void setNotaAvaliacao(Double notaAvaliacao) {
        this.notaAvaliacao = notaAvaliacao;
    }
}
