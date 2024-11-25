package test.Corvinal.entity;

public class Jogo {
    private Integer id;
    private String nome;
    private Integer anoLancamento;
    private Double nota;

    public Jogo(Integer id, String nome, Integer anoLancamento, Double nota) {
        this.id = id;
        this.nome = nome;
        this.anoLancamento = anoLancamento;
        this.nota = nota;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }
}
