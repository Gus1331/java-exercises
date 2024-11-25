public class ContaCorrente extends ContaBancaria{
    private Double limiteChequeEspecial;

    // CONSTRUCTOR
    public ContaCorrente(String nomeCliente, Double limiteChequeEspecial) {
        super(nomeCliente);
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // OUTROS METODOS

    @Override
    public void sacar(Double valorSaque) {
        Double valorPermitidoSaque = saldo + limiteChequeEspecial;
        if(valorSaque > 0 && valorSaque <= valorPermitidoSaque){
            saldo -= valorSaque;
            System.out.println("Saque efetuado!");
        }
    }


    // GETTER AND SETTER

    public Double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public void setLimiteChequeEspecial(Double limiteChequeEspecial) {
        this.limiteChequeEspecial = limiteChequeEspecial;
    }

    // TO STRING

    @Override
    public String toString() {
        return "ContaCorrente{" +
                "limiteChequeEspecial=" + limiteChequeEspecial +
                "} " + super.toString();
    }
}
