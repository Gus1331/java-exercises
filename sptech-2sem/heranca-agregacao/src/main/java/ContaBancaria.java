public class ContaBancaria {
    protected String nomeCliente;
    protected Double saldo;
    protected Integer qtdOperacoesRealizadas;

    // CONSTRUCTOR
    public ContaBancaria(String nomeCliente) {
        this.nomeCliente = nomeCliente;
        this.saldo = 0.0;
        this.qtdOperacoesRealizadas = 0;
    }

    // OUTROS METODOS

    public void sacar(Double valorSaque){
        if(this.saldo >= valorSaque && valorSaque > 0){
            this.saldo -= valorSaque;
            System.out.println("Saque efetuado");
        }
    }

    //GETTERS AND SETTERS

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public Double getSaldo() {
        return saldo;
    }

    public void setSaldo(Double saldo) {
        this.saldo = saldo;
    }

    public Integer getQtdOperacoesRealizadas() {
        return qtdOperacoesRealizadas;
    }

    public void setQtdOperacoesRealizadas(Integer qtdOperacoesRealizadas) {
        this.qtdOperacoesRealizadas = qtdOperacoesRealizadas;
    }

    // TO STRING

    @Override
    public String toString() {
        return "ContaBancaria{" +
                "nomeCliente='" + nomeCliente + '\'' +
                ", saldo=" + saldo +
                ", qtdOperacoesRealizadas=" + qtdOperacoesRealizadas +
                '}';
    }
}
