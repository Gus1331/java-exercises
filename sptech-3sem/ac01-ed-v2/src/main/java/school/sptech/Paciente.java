package school.sptech;

//Classe completa - não é necessário alterar!
public class Paciente {
    private Integer id;
    private String nome;
    private Double valorConsulta;
    private Integer idade;

    public Paciente(Integer id, String nome, Double valorConsulta, Integer idade) {
        this.id = id;
        this.nome = nome;
        this.valorConsulta = valorConsulta;
        this.idade = idade;
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

    public Double getValorConsulta() {
        return valorConsulta;
    }

    public void setValorConsulta(Double valorConsulta) {
        this.valorConsulta = valorConsulta;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    @Override
    public String toString() {
        return """
        Id: %d     Nome: %s     Valor da Consulta: %.2f     Idade: %d""".formatted(id, nome, valorConsulta, idade);
    }
}
