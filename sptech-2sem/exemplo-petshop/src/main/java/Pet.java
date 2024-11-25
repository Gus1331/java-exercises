public class Pet {
    private String nome;

    private Integer qtdBanhosTomados;

    private Double valorGastoEmPetshops;

    public Pet(String nome) {
        this.nome = nome;
        this.qtdBanhosTomados = 0;
        this.valorGastoEmPetshops = 0.0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdBanhosTomados() {
        return qtdBanhosTomados;
    }

    public void setQtdBanhosTomados(Integer qtdBanhosTomados) {
        this.qtdBanhosTomados = qtdBanhosTomados;
    }

    public Double getValorGastoEmPetshops() {
        return valorGastoEmPetshops;
    }

    public void setValorGastoEmPetshops(Double valorGastoEmPetshops) {
        this.valorGastoEmPetshops = valorGastoEmPetshops;
    }
}
