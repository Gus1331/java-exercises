public class teste {

    public static void main(String[] args) {
        BilheteUnico bilhete01 = new BilheteUnico();

        bilhete01.nomeTitular = "Giuliana";
        bilhete01.saldo = 0.0;
        bilhete01.codigo = "B001";

        bilhete01.carregar(42.0);

        CofrinhoDesafio cofre01 = new CofrinhoDesafio();
        cofre01.meta = "PS5";
        cofre01.quebrado = false;
        cofre01.depositar(99.9);
        cofre01.agitar();

    }
}

