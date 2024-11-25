public class Perfume extends Produto{
    private String fragrancia;

    public Perfume(Integer codigo, String descricao, Double preco, String fragrancia) {
        super(codigo, descricao, preco);
        this.fragrancia = fragrancia;
    }

    @Override
    public Double getValorAtributo() {
        return this.getPreco() * 0.2;
    }

    public String getFragrancia() {
        return fragrancia;
    }

    public void setFragrancia(String fragrancia) {
        this.fragrancia = fragrancia;
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "fragrancia='" + fragrancia + '\'' +
                "} " + super.toString();
    }
}
