public class Main {
    public static void main(String[] args) {
    ContaBancaria cb01 = new ContaBancaria("Sim");
    ContaPoupanca cp01 = new ContaPoupanca("Simm", 0.1);
    ContaCorrente cc01 = new ContaCorrente("Simm", 100.0);
    Banco b1 = new Banco("Sptik");
    b1.cadastrarConta(cb01);
    b1.cadastrarConta(cp01);
    b1.cadastrarConta(cc01);
    }
}
