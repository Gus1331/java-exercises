public class PetShop {
    private String nome;

    private Double valorBanho;

    private Integer qtdBanhosRealizados;

    private Double valorTotalGanho;

    public PetShop(String nome, Double valorBanho) {
        this.nome = nome;
        this.valorBanho = valorBanho;
        this.qtdBanhosRealizados = 0;
        this.valorTotalGanho = 0.0;
    }

    public Double getValorBanho() {
        return valorBanho;
    }

    public void setValorBanho(Double valorBanho) {
        this.valorBanho = valorBanho;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getQtdBanhosRealizados() {
        return qtdBanhosRealizados;
    }

    public void setQtdBanhosRealizados(Integer qtdBanhosRealizados) {
        this.qtdBanhosRealizados = qtdBanhosRealizados;
    }

    public Double getValorTotalGanho() {
        return valorTotalGanho;
    }

    public void setValorTotalGanho(Double valorTotalGanho) {
        this.valorTotalGanho = valorTotalGanho;
    }

    public void darBanho(Pet pet){
        System.out.println("Dando banho no pet " + pet.getNome());
        pet.setQtdBanhosTomados(pet.getQtdBanhosTomados() + 1);
        pet.setValorGastoEmPetshops(pet.getValorGastoEmPetshops() + this.valorBanho);
        this.qtdBanhosRealizados++;
        this.valorTotalGanho += this.valorBanho;
    }

    @Override
    public String toString() {
        return String.format("""
                Nome: %s
                Valor banho: %.2f
                Valor total ganho: %.2f
                """, this.getNome(), this.getValorBanho(), this.getValorTotalGanho()
        );
    }
}
