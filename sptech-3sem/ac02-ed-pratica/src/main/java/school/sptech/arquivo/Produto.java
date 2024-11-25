package school.sptech.arquivo;

//Classe pronta, NÃO é necessário alterar nada:
public class Produto {
    private Integer id;
    private String nome;
    private String categoria;
    private Integer pontuacao;
    private Double preco;
    private Integer quantidadeEstoque;

    public Produto(Integer id, String nome, String categoria, Integer pontuacao, Double preco, Integer quantidadeEstoque) {
        this.id = id;
        this.nome = nome;
        this.categoria = categoria;
        this.pontuacao = pontuacao;
        this.preco = preco;
        this.quantidadeEstoque = quantidadeEstoque;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public Integer getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(Integer pontuacao) {
        this.pontuacao = pontuacao;
    }

    public Integer getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Integer quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", pontuacao=" + pontuacao +
                ", preco=" + preco +
                ", quantidadeEstoque=" + quantidadeEstoque +
                '}';
    }
}
