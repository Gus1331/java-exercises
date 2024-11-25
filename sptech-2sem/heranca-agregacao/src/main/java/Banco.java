import java.util.List;
import java.util.ArrayList;

public class Banco {
    private String nomeBanco;

    private List<ContaBancaria> contas;

    public Banco(String nomeBanco){
        this.nomeBanco = nomeBanco;
        this.contas = new ArrayList<>();
    }

    public void exibirContas(){
        for(ContaBancaria conta: this.contas){
            System.out.println(conta);
        }
    }

    public void exibirSomenteContasPoupancas(){
        for (ContaBancaria conta : this.contas){
            if (conta instanceof ContaPoupanca){
                System.out.println(conta);
            }
        }
    }

    public Double somarChequeEspecial(){
        Double total = 0.0;
        for (ContaBancaria conta : this.contas) {
            if (conta instanceof ContaCorrente){
                total += ((ContaCorrente) conta).getLimiteChequeEspecial();
            }
            if (conta instanceof ContaPoupanca ContaPoupanca){
                conta.
            }
        }
        return total;
    }

    public void cadastrarConta(ContaBancaria conta){
        contas.add(conta);
    }
}
