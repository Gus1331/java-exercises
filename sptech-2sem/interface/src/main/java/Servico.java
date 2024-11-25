public class Servico implements  Tributavel{
    private String descricao;
    private Double preco;

    public Servico(String descricao, Double preco) {
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public Double getValorAtributo() {
        return this.preco * 0.1;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    @Override
    public String toString() {
        return "Servico{" +
                "descricao='" + descricao + '\'' +
                ", preco=" + preco +
                '}';
    }
}
