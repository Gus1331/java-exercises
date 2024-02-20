package dom;

public class Account {
    public int numConta;
    protected String tipo;
    private String dono;
    private double saldo;
    private boolean status;

    // GETTERS AND SETTERS
    public int getNumConta() {
        return numConta;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo.equals("cc") || tipo.equals("cp")) {
            this.tipo = tipo;
        } else {
            System.out.println("Erro");
        }
    }

    public String getDono() {
        return this.dono;
    }

    public void setDono(String dono) {
        this.dono = dono;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        if (this.status) {
            this.saldo = saldo;
        } else {
            System.out.println("A conta está fechada");
        }
    }

    public boolean getStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    // CONSTRUCTOR

    public Account(String dono, int numConta, String tipo) {
        if (tipo.equals("cc") || tipo.equals("cp")) {
            this.tipo = tipo;

        } else {
            System.out.println("Erro: tipo da conta precisa ser cc (conta corrente) ou cp (conta poupança);");
            return;
        }

        this.dono = dono;
        this.numConta = numConta;
        this.status = false;

        if (tipo.equals("cc")) {
            saldo = 50f;
        } else {
            saldo = 150f;
        }
    }

    // METODOS ADICIONAIS
    public void abrirConta() {
        System.out.println("conta aberta");
        this.status = true;
    }

    public void fecharConta() {
        if (this.saldo != 0) {
            System.out.println("Para fechar a conta, saque seu dinheiro ou pague o valor pendente");
        } else {
            System.out.println("conta fechada");
            this.status = false;
        }
    }

    public void depositar(double dinheiro) {
        if (this.status) {
            this.saldo += dinheiro;
        } else {
            System.out.println("A conta está fechada");
        }
    }

    public void sacar(double dinheiro) {
        if (this.status) {
            if (this.saldo >= dinheiro) {
                this.saldo -= dinheiro;
                System.out.println(dinheiro + "R$ sacados, saldo atual: " + this.saldo);
            } else {
                System.out.println("Você não possui esta quantia em saldo, seu saldo atual: "+ this.saldo);
            }
        } else {
            System.out.println("A conta está fechada");
        }
    }

    public void pagarMensal(){
        if(this.status){
            if(this.tipo.equals("cc")){
                this.saldo -= 12.00f;
            } else {
                this.saldo -= 20.00f;
            }
        } else{
            System.out.println("Conta fechada, nada a cobrar");
        }
    }
}
