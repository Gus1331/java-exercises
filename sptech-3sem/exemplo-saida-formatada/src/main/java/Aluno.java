public class Aluno {
    private Integer ra;
    private String nome;
    private Double notaFinal;
    private Integer qtdFaltas;

    public Aluno(Integer ra, String nome, Double notaFinal, Integer qtdFaltas) {
        this.ra = ra;
        this.nome = nome;
        this.notaFinal = notaFinal;
        this.qtdFaltas = qtdFaltas;
    }

    public Integer getRa() {
        return ra;
    }

    public void setRa(Integer ra) {
        this.ra = ra;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(Double notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Integer getQtdFaltas() {
        return qtdFaltas;
    }

    public void setQtdFaltas(Integer qtdFaltas) {
        this.qtdFaltas = qtdFaltas;
    }
}
