public class Filme {
    private Integer id;
    private String titulo;
    private Double nota;
    private Integer anoLancamento;

    public Filme(Integer id, String titulo, Double nota, Integer anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.nota = nota;
        this.anoLancamento = anoLancamento;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getNota() {
        return nota;
    }

    public void setNota(Double nota) {
        this.nota = nota;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    @Override
    public String toString() {
        return "Filme{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nota=" + nota +
                ", anoLancamento=" + anoLancamento +
                '}';
    }
}
