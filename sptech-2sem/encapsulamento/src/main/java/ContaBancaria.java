public class ContaBancaria {
    private String nomeTitular;
    private Double saldo;
    public void sacar(Double valorSaque){
        if (valorSaque <= 0 || valorSaque > this.saldo){
            System.out.println("Não");
        } else {
            saldo -= valorSaque;
            System.out.println("Sim");
        }
    }
    public ContaBancaria(String nome){
        this.nomeTitular = nome;
        this.saldo = 0.0;
    }

    public ContaBancaria() {}

    public void mudarNomeTitular(String nomeNovo){
        nomeTitular = nomeNovo;
    }

    public String buscarNomeTitular(){
        return nomeTitular;
    }

}
