public class Alimento extends Produto{
    private Integer qtdVitamina;

    public Alimento(Integer codigo, String descricao, Double preco, Integer qtdVitamina) {
        super(codigo, descricao, preco);
        this.qtdVitamina = qtdVitamina;
    }

    @Override
    public Double getValorAtributo() {
        return this.getPreco() * 0.02;
    }

    public Integer getQtdVitamina() {
        return qtdVitamina;
    }

    public void setQtdVitamina(Integer qtdVitamina) {
        this.qtdVitamina = qtdVitamina;
    }

    @Override
    public String toString() {
        return "Alimento{" +
                "qtdVitamina=" + qtdVitamina +
                "} ";
    }
}
