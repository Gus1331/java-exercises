public class ContaPoupanca extends ContaBancaria{
    private Double taxaRendimento;

    // CONSTRUCTOR

    public ContaPoupanca(String nomeCliente, Double taxaRendimento) {
        super(nomeCliente);
        this.taxaRendimento = taxaRendimento;
    }

    // OUTROS METODOS

    public void calcularValorRendimento(){
        Double valorRendimento = super.saldo * this.taxaRendimento;
        saldo += valorRendimento;
    }

    // GETTER AND SETTER

    public Double getTaxaRendimento() {
        return taxaRendimento;
    }

    public void setTaxaRendimento(Double taxaRendimento) {
        this.taxaRendimento = taxaRendimento;
    }

    // TO STRING

    @Override
    public String toString() {
        return "ContaPoupanca{" +
                "taxaRendimento=" + taxaRendimento +
                "} " + super.toString();
    }
}
